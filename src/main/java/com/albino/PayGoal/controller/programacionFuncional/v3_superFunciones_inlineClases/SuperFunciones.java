package com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases;

import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.Consumidor;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.IFuncion;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.IPredicado;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.IProveedor;

import java.util.ArrayList;
import java.util.List;

public class SuperFunciones {

    public static List<Integer> filrar(List<Integer> valores, IPredicado IPredicado){
        List<Integer> resultado = new ArrayList<Integer>();
        for(Integer valor:valores){
            if(IPredicado.test(valor))
                resultado.add(valor);
        }
        return resultado;
    }

    public static List<Integer> proveer(int size, IProveedor predicado){

        List<Integer> resultado = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            resultado.add(predicado.obtener());
        }
        return resultado;
    }

    public static List<Integer> transformar(List<Integer> valores, IFuncion funcion){
        List<Integer> resultado = new ArrayList<Integer>();
        for(Integer valor:valores){
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }


    public static List<Integer> actuar(List<Integer> valores, Consumidor consumidor){
        for (Integer valor:valores){
            consumidor.aceptar(valor);
        }
        return valores;
    }

    public static void consumir(List<Integer> valores, Consumidor consumidor){
        for (Integer valor:valores){
            consumidor.aceptar(valor);
        }
    }




}
