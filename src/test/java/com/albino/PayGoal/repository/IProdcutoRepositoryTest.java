package com.albino.PayGoal.repository;

import com.albino.PayGoal.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class IProdcutoRepositoryTest {

    @Autowired
    private IProdcutoRepository prodcutoRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Producto producto =
                Producto.builder()
                        .nombre("sal")
                        .precio(200.0)
                        .cantidad(10)
                        .descripcion("Re salada")
                        .build();
        testEntityManager.persist(producto);
    }

    @Test
    void findIdFound(){
        Optional<Producto> producto = prodcutoRepository.findById(1L);
        assertEquals(1L, producto.get().getId());
    }

    @Test
    void findIdNotFound(){
        Optional<Producto> producto = prodcutoRepository.findById(200L);
        assertTrue(producto.isEmpty());
    }
}