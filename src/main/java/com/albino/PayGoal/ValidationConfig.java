package com.albino.PayGoal;

import com.albino.PayGoal.validaciones.UserValidation;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    @Bean
    public UserValidation userValidation(){
        return  new UserValidation();
    }
}
