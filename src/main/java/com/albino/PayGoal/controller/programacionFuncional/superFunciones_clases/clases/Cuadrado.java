package com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.interfaces.IFuncion;



public class Cuadrado implements IFuncion {
    @Override
    public Integer aplicar(Integer valor) {
        return valor*valor;
    }
}
