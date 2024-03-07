package com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.interfaces.IProveedor;

import java.util.Random;

public class Aleatorio implements IProveedor {

     Random random = new Random();
    @Override
    public Integer obtener() {
        return random.nextInt(1000);
    }
}
