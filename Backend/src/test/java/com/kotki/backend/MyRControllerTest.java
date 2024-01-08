package com.kotki.backend;

import com.example.MPR_LAB03.exceptions.CatNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MyRControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MyRestService service;
    private MyRestContoller controller;
    private AutoCloseable openMocks;

    @BeforeEach
    public void init(){
        openMocks = MockitoAnnotations.openMocks(this);
        controller = new MyRestContoller(service);
    }

    @AfterEach
    public void tearDown() throws Exception{
        openMocks.close();
    }

    @Test
    public void findName(){
        String name = "Kicia";
        Cat cat = new Cat(name, 2);
        when(service.getCatByName(name)).thenReturn(cat);
        Cat result = controller.findName(name);
        assertEquals(cat, result);
    }

    @Test
    public void getByIdReturns200WhenCatPresent() throws Exception{
        Cat cat = new Cat("Puszek", 3);
        when(service.getCatId(5L)).thenReturn(cat);

        mockMvc.perform(MockMvcRequestBuilders.get("cat/id/5"))
                .andExpect(jsonPath("$.age").value(3))
                .andExpect(jsonPath("$.name").value("Puszek"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void check404IsReturnedWhenCatNotFound() throws Exception{
//        when(service.addNewCat(any())).thenThrow(new CatAlreadyExists());
//
//        mockMvc.perform(MockMvcRequestBuilders.get("cat/"))
//    }

    @Test
    public void check404IsReturnedWhenCatNotFound() throws Exception{
        when(service.getCatByName(any())).thenThrow(new CatNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("cat/add"))
                .andExpect(status().isNotFound());
    }


    //pozytywny, że wszystko jest okay -> 2 do post i do get
    //negatywny, że exception się wywali -> 2 do post i do get


}
