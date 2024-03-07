package com.albino.PayGoal.controller;

import com.albino.PayGoal.dtos.LoguinDto;
import com.albino.PayGoal.dtos.ResponseDto;
import com.albino.PayGoal.model.userEntity;
import com.albino.PayGoal.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/*@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IAuthService authService;

    @PostMapping("/register")
    private ResponseEntity<ResponseDto> register(@RequestBody userEntity user) throws Exception {
        return  new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/loguin")
    private ResponseEntity<HashMap<String, String>> loguin(@RequestBody LoguinDto loguinRequest) throws Exception {
        HashMap<String, String> loguin = authService.loguin(loguinRequest);
        if(loguin.containsKey("jwt")){
            return new ResponseEntity<>(loguin, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(loguin, HttpStatus.UNAUTHORIZED);
        }
    }
}*/
