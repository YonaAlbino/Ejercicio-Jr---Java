package com.albino.PayGoal.service;

import com.albino.PayGoal.excepciones.RegistroNullException;
import com.albino.PayGoal.model.Producto;
import com.albino.PayGoal.repository.IProdcutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoServiceTest {
    @InjectMocks
    ProductoService productoService;
    @Mock
    IProdcutoRepository prodcutoRepository;

    List<Producto> listaProductos = new ArrayList<>();
    Producto producto;
    @BeforeEach
    public void  init(){
        MockitoAnnotations.openMocks(this);
        this.cargarLista();
        this.asignarProducto();
    }

    @Test
    @DisplayName("prueba metodo getProductos")
    public void getProductosTest(){
        when(prodcutoRepository.findAll()).thenReturn(listaProductos);
        List<Producto> listaProductos = productoService.getProductos();

        assertNotEquals(0, listaProductos.size());
        assertTrue(recorrerLista());

        verify(prodcutoRepository, times(1)).findAll();
    }

    @Test
    @DisplayName(("Prueba metodo findProducto"))
    public void findProductoTest(){
        when(prodcutoRepository.findById(1L)).thenReturn(Optional.ofNullable(producto));
        Producto producto1 = productoService.findProducto(1L);

        assertTrue(producto1.getId() == 1L);
        verify(prodcutoRepository, times(1)).findById(1L);
    }


    @Test
    @DisplayName("Prueba para verificar el metodo de ordenado de mayor a menor")
    void ordenarMayorMenorTest() {
        when(prodcutoRepository.findAll()).thenReturn(listaProductos);
        List<Producto> listaProductos = productoService.ordenarMayorMenor();

        assertTrue(comprobarOrdenMayorMenor());

    }

    @Test
    @DisplayName("Prueba metodo de busqueda por nombre")
    void findProductoPorNombreTest() {

        when(prodcutoRepository.findAll()).thenReturn(listaProductos);
        Producto producto = productoService.findProductoPorNombre("carne");

        assertTrue(producto.getNombre().equals("carne"));
        assertFalse(producto.getNombre().equals("pan"));
        assertNotNull(producto);
    }


    public void cargarLista(){
        listaProductos.add(new Producto(1L,"carne","rica",2000.0, 10));
        listaProductos.add(new Producto(2L,"leche","descremada",2500.0, 50));
        listaProductos.add(new Producto(3L,"pan","sin gluten",1000.0, 2));
    }

    public boolean recorrerLista() {
        for (Producto producto : listaProductos) {
            if (producto.getPrecio() == - 0.0)
                return false;
        }
        return true;
    }

    public void asignarProducto(){
        producto  = new Producto(1L,"carne","rica",2000.0, 10);
    }

    public  boolean comprobarOrdenMayorMenor(){
      if(listaProductos.get(0).getPrecio() < listaProductos.get(listaProductos.size()-1).getPrecio())
          return false;
      return  true;
    }

    List<Producto> lista = new ArrayList<>();


    @Test
    void ordenarMayorMenor() {
        when(prodcutoRepository.findAll()).thenReturn(lista);

        assertThrows(RuntimeException.class, () -> {
            productoService.ordenarMayorMenor();
        });
    }
}
