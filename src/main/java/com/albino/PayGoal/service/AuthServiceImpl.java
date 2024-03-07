package com.albino.PayGoal.service;

import com.albino.PayGoal.dtos.LoguinDto;
import com.albino.PayGoal.dtos.ResponseDto;
import com.albino.PayGoal.model.userEntity;
import com.albino.PayGoal.repository.IUserRepository;
import com.albino.PayGoal.validaciones.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IJWATUtilityService jwatUtilityService;

    @Autowired
    private UserValidation userValidation;
    @Override
    public HashMap<String, String> loguin(LoguinDto loguinDto) throws Exception {

        try {

            HashMap<String, String> jwt = new HashMap<>();
            Optional<userEntity> user = userRepository.findByEmail(loguinDto.getEmail());

            if(user.isEmpty()){
                jwt.put("Error", "Usuario no registrado!");
                return jwt;
            }

            if(verifyPassword(loguinDto.getPassword(), user.get().getPassword())){
                jwt.put("jwt", jwatUtilityService.generateJWT(user.get().getId()));
            } else{
                jwt.put("Error", "Autenticacion fallida");
            }

            return  jwt;

        } catch (Exception ex){
            throw  new Exception(ex.toString());
        }
    }

    public ResponseDto register(userEntity user) throws  Exception{
        try {
            ResponseDto response =  userValidation.validation(user);

            if(response.getNumOfErrors() > 0) {
                return response;
            }

            List<userEntity> getAllUsers = userRepository.findAll();

            for (userEntity existingUser : getAllUsers) {
                if (existingUser.getEmail().equals(user.getEmail())) {
                    response.setMessage("Email already exists!");
                    return response;
                }
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            response.setMessage("Registro exitoso!");

            return response;

        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.matches(enteredPassword, storedPassword);
    }
}
