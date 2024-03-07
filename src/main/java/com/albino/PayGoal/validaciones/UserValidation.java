package com.albino.PayGoal.validaciones;

import com.albino.PayGoal.dtos.ResponseDto;
import com.albino.PayGoal.model.userEntity;

public class UserValidation {
    public ResponseDto validation(userEntity user){
        ResponseDto response = new ResponseDto();
        response.setNumOfErrors(0);

        if(user.getName() == null || user.getName().length() <3 || user.getName().length() > 15){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo name no puede ser nulo, debe tener entre 3 y 15 caracteres");
        }

        if(user.getLastName() == null || user.getLastName().length() > 30 || user.getLastName().length() < 3){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo lastname no puede ser nulo, debe tener entre 3 y 15 caracteres");
        }

       /* if(!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n")){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo email no es valido");
        }*/

        /*(user.getPassword() == null || !user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n")){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo password debe tener al menos 1 mayuscula, 1 carater especial y debe ser mayor a 8 caracteres");
        }*/

        return  response;
    }
}
