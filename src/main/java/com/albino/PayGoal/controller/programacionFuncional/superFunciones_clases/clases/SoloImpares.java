package com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.interfaces.IPredicado;

import java.util.List;

public class SoloImpares implements IPredicado {
    @Override
    public boolean test(Integer valor) {
        return valor%2 != 0;
    }


}
