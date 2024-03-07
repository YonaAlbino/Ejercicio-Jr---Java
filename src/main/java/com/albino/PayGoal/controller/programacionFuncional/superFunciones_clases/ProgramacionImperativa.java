package com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases;

import com.albino.PayGoal.controller.programacionFuncional.superFunciones_clases.clases.*;

import java.util.ArrayList;
import java.util.List;

public class ProgramacionImperativa {

    public static void main(String[] args) {
        //Tareas
        //1-Crear una lista de enteros
        List<Integer> listaEnteros = SuperFunciones.proveer(10, new Aleatorio());
        System.out.println("Lista de números aleatorios " + listaEnteros);

        List<Integer> listaNaturales = SuperFunciones.proveer(10, new Naturales());
        System.out.println("Lista de números naturales " + listaNaturales);

        List<Integer> listaNegativos = SuperFunciones.proveer(10, new Negativos());
        System.out.println("Lista de números negativos " + listaNegativos);


        //2-Obtener solo los pares
        List<Integer> listaPares =  SuperFunciones.filrar(listaEnteros,new SoloPares());
        List<Integer> listaImpares =  SuperFunciones.filrar(listaEnteros,new SoloImpares());
        System.out.println("Números pares " + listaPares);
        System.out.println("Números impares " + listaImpares);

        //3-Pasar cada número al cuadrado
        List<Integer> listaCuadrados = SuperFunciones.transformar(listaPares, new Cuadrado());
        System.out.println("Números al cuadrado " + listaCuadrados);

        List<Integer> listaDobles = SuperFunciones.transformar(listaPares, new Doble());
        System.out.println("Números al dobles " + listaDobles);

        //4 a-Mostrar cada cuadrado por pantalla y retornar lista
        //List<Integer> mostrados = SuperFunciones.actuar(listaCuadrados, new Impresor());

        //4 b-mostrar cada cuadrado por pantalla y no mostrar nada
        SuperFunciones.consumir(listaCuadrados, new Impresor());

        //5-Obtener la suma de los cuadrados

        int total = sumarLista(listaDobles);
        System.out.println(total);
    }

    private static int sumarLista(List<Integer> mostrados) {
        int total = 0;
        for (int numero:mostrados){
            total += numero;
        }
        return total;
    }

    private static List<Integer> mostrarLista(List<Integer> listaEnteros) {
        for (Integer numero:listaEnteros){
            System.out.println(numero);
        }
        return listaEnteros;
    }

    private static List<Integer> elevarCuadrado(List<Integer> listaPares) {
        List<Integer> listaCuadrados = new ArrayList<>();
        for (Integer numero:listaPares){
            listaCuadrados.add(numero*numero);
        }
        return listaCuadrados;
    }

    private static List<Integer> filtrarPares(List<Integer> ListaEnteros) {
            List<Integer> listaPares = new ArrayList<>();

            for (Integer numero:ListaEnteros){
                if (numero%2 == 0)
                    listaPares.add(numero);
            }
            return listaPares;
        }
        private static List<Integer> crearLista() {
            return List.of(1,2,3,4,5,6,7,8,9,10,11);
        }
    }



