package com.albino.PayGoal.service;

import com.albino.PayGoal.dtos.LoguinDto;
import com.albino.PayGoal.dtos.ResponseDto;
import com.albino.PayGoal.model.userEntity;

import java.util.HashMap;

public interface IAuthService {

    public HashMap<String, String> loguin(LoguinDto loguinDto) throws Exception;
    public ResponseDto register(userEntity user) throws  Exception;
}
