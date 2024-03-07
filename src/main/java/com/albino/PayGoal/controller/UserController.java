package com.albino.PayGoal.controller;

import com.albino.PayGoal.model.userEntity;
import com.albino.PayGoal.service.IuserService;
import com.albino.PayGoal.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IuserService userService;

    @GetMapping("/findAll")
    private ResponseEntity<List<userEntity>> getAllUser(){
        List<userEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
