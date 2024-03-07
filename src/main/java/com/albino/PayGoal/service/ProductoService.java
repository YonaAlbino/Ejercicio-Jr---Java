/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.albino.PayGoal.service;

import com.albino.PayGoal.excepciones.ListaVaciaException;
import com.albino.PayGoal.excepciones.RegistroNullException;
import com.albino.PayGoal.model.Producto;
import com.albino.PayGoal.repository.IProdcutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * La clase ProductoService implementa toda la logica
 * para manipular los {@link Producto}
 * @author Yonathan
 *
 */
@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProdcutoRepository productoRepo;

    /**
     *@author yonathan
     * @return Retorna toda la lista de productos de la base de datos lista de prodcutos
     * @throws ListaVaciaException lanza una excepcion en caso de que la lista este vacia
     *
     */
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepo.findAll();

        if (listaProductos.isEmpty()) {
            throw new ListaVaciaException("La lista de productos se encuentra vacia");
        } else {
            return listaProductos;
        }
    }

    @Override
    public Producto saveProducto(Producto producto) {
        productoRepo.save(producto);
        return producto;
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto producto = productoRepo.findById(id).orElse(null);
        if (producto == null) {
            throw new RegistroNullException("El producto que estas buscando no existe");
        } else {
            return producto;
        }
    }

    @Override
    public Producto editProducto(Producto producto) {
        this.saveProducto(producto);
        return producto;
    }

    /**
     *
     * @param  nombre
     * @return Un producto encontrado por nombre
     * @throws RegistroNullException
     */
    @Override
    public Producto findProductoPorNombre(String nombre) {
        List<Producto> listaProducto = productoRepo.findAll();

        for (Producto producto : listaProducto) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }

        throw new RegistroNullException("El producto que estas buscando no existe");
    }

    /**
     * Ordena la lista de productos de mayor a menor precio.
     *
     * @author Yona
     * @return Una lista de productos ordenada de mayor a menor precio.
     * @throws ListaVaciaException Si la lista de productos está vacía.
     */
    @Override
    public List<Producto> ordenarMayorMenor() {
        List<Producto> listaProductos = productoRepo.findAll();
        if (listaProductos.isEmpty()) {
            throw new ListaVaciaException("La lista de productos se encuentra vacia");
        } else {
            listaProductos.sort((p2, p1) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
            return listaProductos;
        }

    }

    @Override
    public List<Producto> ordenarMenorMayor() {
        List<Producto> listaProductos = productoRepo.findAll();
        if (listaProductos.isEmpty()) {
            throw new ListaVaciaException("La lista de productos se encuentra vacia");
        } else {
            listaProductos.sort((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
            return listaProductos;
        }
    }

}
