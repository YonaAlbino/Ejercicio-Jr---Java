/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.albino.PayGoal.controller;

import com.albino.PayGoal.model.Producto;
import com.albino.PayGoal.service.IProductoService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Operation(summary = "Trraer todos los prdocutos de la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos encontrados con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = List.class,
                                            subTypes = {Producto.class}))
                    })
    })
    @GetMapping("/traer/todos")
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoService.getProductos();
        return listaProductos;
    }

    @Operation(summary = "Ordena los productos por precio de mayor a menor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos ordenados con exito",
                content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class,
                    subTypes = {Producto.class}))
                })
    })
    @GetMapping("/traer/mayorAmenor")
    public ResponseEntity<List<Producto>> productosPrecioDescendente() {
        List<Producto> listaProductos = productoService.ordenarMayorMenor();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @Operation(summary = "Orena los productos por precio de menor a mayor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos ordenados con exito",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class,
                    subTypes = {Producto.class}))
            }),
            @ApiResponse(responseCode = "404", description = "Sin prodcutos en la base de datos")
    })
    @GetMapping("/traer/menorAmayor")
    public ResponseEntity<List<Producto>> productosPrecioAscendente() {
        List<Producto> listaProductos = productoService.ordenarMenorMayor();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }


    @Operation(summary = "Buscar un producto por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado con exito",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @GetMapping("/buscar")
    public ResponseEntity<Producto> findProducto(@Parameter(description = "id del producto", example = "1") @RequestParam Long id) {
        Producto producto = productoService.findProducto(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }



    @Operation(summary = "Buscar prodcuto por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200", description = "Producto encontrado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Producto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @GetMapping("/BuscarPorNombre")
    public ResponseEntity<Producto> findProductoPorNombre(@Parameter(description = "Nombre del producto", example = "pan") @RequestParam String nombre) {
        Producto producto = productoService.findProductoPorNombre(nombre);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }


    @Operation(summary = "Crar producto en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200", description = "Producto creado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Producto.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content)
    })
    @PostMapping("/crear")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }



    @Operation(summary = "Actualizar un producto en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200", description = "Producto actualizado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Producto.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content)
    })
    @PutMapping("/modificar")
    public ResponseEntity<Producto> editProducto(@RequestBody Producto producto) {
        productoService.editProducto(producto);
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }



    @Operation(summary = "Elimnar un producto en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200", description = "Producto eliminado con exito",
                    content = {
                            @Content(mediaType = "text/plain")
                    })
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteProducto(@Parameter(description = "Id del producto", example = "1") @PathVariable Long id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }


}
