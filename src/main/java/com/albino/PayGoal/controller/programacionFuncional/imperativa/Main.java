package com.albino.PayGoal.controller.programacionFuncional.imperativa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Tareas
        //1-Crear una lista de enteros
        List<Integer> listaEnteros = crearLista();
        System.out.println(listaEnteros);
        //2-Obtener solo los pares
        List<Integer> listaPares =  filtrarPares(listaEnteros);
        System.out.println(listaPares);
        //3-Pasar cada número al cuadrado
        List<Integer> listaCuadrados = elevarCuadrado(listaPares);
        System.out.println(listaCuadrados);
        //4-Mostrar cada cuadrado por pantalla
        List<Integer> mostrados = mostrarLista(listaCuadrados);
        //5-Obtener la suma de los cuadrados
        int total = sumarLista(mostrados);
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



