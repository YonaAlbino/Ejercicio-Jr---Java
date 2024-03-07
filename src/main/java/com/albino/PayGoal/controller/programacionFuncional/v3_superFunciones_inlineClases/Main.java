package com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases.*;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.Consumidor;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.IFuncion;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.IPredicado;
import com.albino.PayGoal.controller.programacionFuncional.v3_superFunciones_inlineClases.interfaces.IProveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Tareas
        //1-Crear una lista de enteros
        List<Integer> listaEnteros = SuperFunciones.proveer(10, new IProveedor() {
            Random random = new Random();
            @Override
            public Integer obtener() {
                return random.nextInt(10);
            }
        });
        System.out.println("Lista de números aleatorios " + listaEnteros);

        List<Integer> listaNaturales = SuperFunciones.proveer(10, new IProveedor() {
            int next = 0;
            @Override
            public Integer obtener() {
                return next++;
            }
        });
        System.out.println("Lista de números naturales " + listaNaturales);

        List<Integer> listaNegativos = SuperFunciones.proveer(10, new IProveedor() {
            int next = 0;
            @Override
            public Integer obtener() {
                return next--;
            }
        });
        System.out.println("Lista de números negativos " + listaNegativos);


        //2-Obtener solo los pares
        List<Integer> listaPares =  SuperFunciones.filrar(listaEnteros, new IPredicado() {
            @Override
            public boolean test(Integer valor) {
                return valor%2==0;
            }
        });
        System.out.println("Números pares " + listaPares);
        List<Integer> listaImpares =  SuperFunciones.filrar(listaEnteros, new IPredicado() {
            @Override
            public boolean test(Integer valor) {
                return valor%2!=0;
            }
        });
        System.out.println("Números impares " + listaImpares);

        //3-Pasar cada número al cuadrado
        List<Integer> listaCuadrados = SuperFunciones.transformar(listaPares, new IFuncion() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor+valor;
            }
        });
        System.out.println("Números al cuadrado " + listaCuadrados);

        List<Integer> listaDobles = SuperFunciones.transformar(listaPares, new IFuncion() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor*2;
            }
        });
        System.out.println("Números al dobles " + listaDobles);

        //4 a-Mostrar cada cuadrado por pantalla y retornar lista
        //List<Integer> mostrados = SuperFunciones.actuar(listaCuadrados, new Impresor());

        //4 b-mostrar cada cuadrado por pantalla y no retornar nada

        Consumidor consumidor = new Consumidor() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }};

        SuperFunciones.consumir(listaCuadrados,  consumidor);

    }
        private static List<Integer> crearLista() {
            return List.of(1,2,3,4,5,6,7,8,9,10,11);
        }
    }



