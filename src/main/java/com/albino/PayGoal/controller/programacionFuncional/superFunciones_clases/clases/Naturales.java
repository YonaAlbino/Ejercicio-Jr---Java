package com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.interfaces.IProveedor;

import java.util.Random;

public class Naturales implements IProveedor {

     private static int next = 0;
    @Override
    public Integer obtener() {
        return next++;
    }
}
