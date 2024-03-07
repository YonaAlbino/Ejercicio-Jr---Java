package com.albino.PayGoal.controller;

import com.albino.PayGoal.model.Producto;
import com.albino.PayGoal.service.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    @Autowired
    private ProductoController productoController;
    @Mock
    @Autowired
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productoController).build();
        cargarLista();
        producto = new Producto(1L, "pan", "sin sal", 2000.0, 10);
    }

    List<Producto> listaProductos = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();
    Producto producto;
    void cargarLista(){
        listaProductos.add(new Producto(1L, "pan", "sin sal", 2000.0, 10));
        listaProductos.add(new Producto(2L, "carne", "de baca joven", 5000.0, 20));
        listaProductos.add(new Producto(3L, "leche", "para bebes molestos", 1000.0, 15));
    }


    @Test
    @DisplayName("Prueba endpoint getProductos")
    void getProductos() {
        when(productoService.getProductos()).thenReturn(listaProductos);
         ResponseEntity<List<Producto>> respuesta = productoController.getProductos();
         assertTrue(respuesta.getStatusCode().is2xxSuccessful());
         List<Producto> lista = respuesta.getBody();
         assertTrue(lista!=null);
    }

    @Test
    @DisplayName("Prueba endpoint getProductos 2")
    void getProductos2() throws Exception{
        when(productoService.getProductos()).thenReturn(listaProductos);
        ResponseEntity<List<Producto>> respuesta = productoController.getProductos();

        this.mockMvc.perform(get("/producto/traer/todos")
        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[1].nombre").exists())
                .andExpect(jsonPath("$[1].nombre").value("carne"))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test del metodo findProducto")
    void findProducto() throws Exception{
        when(productoService.findProducto(1L)).thenReturn(producto);
        ResponseEntity<Producto> respuesta = productoController.findProducto(1L);

        this.mockMvc.perform(get("/producto/buscar?id=1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").exists())
        .andExpect(jsonPath("$.nombre").value("pan"));
    }

    @Test
    @DisplayName("Prueba metodo guardar producto")
    void saveProducto() throws Exception{

        this.mockMvc.perform((post("/producto/crear"))
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").exists())
                .andExpect(jsonPath("$.nombre").value(producto.getNombre()));
    }

    @Test
    void deleteProducto() throws Exception {

        this.mockMvc.perform((delete("/producto/eliminar/0"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editProducto() throws Exception{
        Producto putProducto = new Producto(null, "pan", "sin sal", 2000.0, 10);

        when(productoService.editProducto(putProducto)).thenReturn(producto);

        this.mockMvc.perform((put("/producto/modificar"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").exists())
                .andExpect(jsonPath("$.nombre").value(producto.getNombre()));
    }


}