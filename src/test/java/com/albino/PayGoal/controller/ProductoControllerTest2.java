package com.albino.PayGoal.controller;

import com.albino.PayGoal.model.Producto;
import com.albino.PayGoal.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    Producto producto;
    @BeforeEach
    void setUp(){
         producto = Producto.builder()
                .id(1L)
                .nombre("pan")
                .descripcion("sin harina")
                .precio(2000.0)
                .cantidad(10)
                .build();
    }
    @Test
    void saveProductoTest() throws Exception{

        Producto Postproducto = Producto.builder()
                .nombre("pan")
                .descripcion("sin harina")
                .precio(2000.0)
                .cantidad(10)
                .build();

        Mockito.when(productoService.saveProducto(Postproducto)).thenReturn(producto);
        mockMvc.perform(post("/producto/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"nombre\": \"Pan\",\n" +
                        "\"descripcion\": \"Pan sin gluten\",\n" +
                        "\"precio\": 800.0,\n" +
                        "\"cantidad\": 5\n" +
                        "}"))
                .andExpect(status().isOk());



    }

}
