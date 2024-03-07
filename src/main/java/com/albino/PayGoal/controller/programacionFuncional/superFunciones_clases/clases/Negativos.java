package com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.interfaces.IProveedor;

import java.util.List;

public class Negativos implements IProveedor {

    private static int valor = 0;
    @Override
    public Integer obtener() {
        return valor--;
    }
}
