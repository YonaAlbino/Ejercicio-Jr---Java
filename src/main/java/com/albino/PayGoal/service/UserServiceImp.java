package com.albino.PayGoal.service;

import com.albino.PayGoal.model.userEntity;
import com.albino.PayGoal.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements IuserService{

    @Autowired
    IUserRepository userRepository;
    @Override
    public List<userEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
