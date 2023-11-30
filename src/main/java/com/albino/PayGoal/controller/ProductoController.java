/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.albino.PayGoal.controller;

import com.albino.PayGoal.model.Producto;
import com.albino.PayGoal.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> listaProductos = productoService.getProductos();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Producto> findProducto(@RequestParam Long id) {
        Producto producto = productoService.findProducto(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/BuscarPorNombre")
    public ResponseEntity<Producto> findProductoPorNombre(@RequestParam String nombre) {
        Producto producto = productoService.findProductoPorNombre(nombre);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return new ResponseEntity<>("Producto creado", HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> editProducto(@RequestBody Producto producto) {
        productoService.editProducto(producto);
        return new ResponseEntity<>("Producto modificado", HttpStatus.OK);
    }

    @GetMapping("/traer/mayorAmenor")
    public ResponseEntity<List<Producto>> productosPrecioDescendente() {
        List<Producto> listaProductos = productoService.ordenarMayorMenor();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping("/traer/menorAmayor")
    public ResponseEntity<List<Producto>> productosPrecioAscendente() {
        List<Producto> listaProductos = productoService.ordenarMenorMayor();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

}
