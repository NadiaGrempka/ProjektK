package com.kotki.backend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CatTest {


    @Mock
    private Cat cat;
    private AutoCloseable openMocks;

    @BeforeEach
    public void init(){
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception{
        openMocks.close();
    }

    @Test
    public void mockTest(){
        String name = "Kicia";
        Cat kitty = new Cat(name, 3);
    }

}
