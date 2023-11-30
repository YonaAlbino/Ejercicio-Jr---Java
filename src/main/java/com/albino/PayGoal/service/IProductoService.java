/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.albino.PayGoal.service;

import com.albino.PayGoal.model.Producto;
import java.util.List;


public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);
    
    public Producto findProductoPorNombre(String nombre);

    public void editProducto(Producto producto);
    
    public List<Producto> ordenarMayorMenor();
    
    public List<Producto> ordenarMenorMayor();
}
