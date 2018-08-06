package com.hattori.finder.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import com.hattori.finder.entities.Store;
import com.hattori.finder.exceptions.StoreNotFoundException;
import com.hattori.finder.services.StoreService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * StoreControllerTest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StoreController.class)
public class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService service;

    private Store getStore() {
        return Store.builder().branch(1).description("TEST").postalCode(14400520).build();
    }

    @Test
    public void test_should_return_is_ok_find_all_atore() throws Exception {

        when(service.findAll()).thenReturn(Arrays.asList(this.getStore()));
        this.mockMvc.perform(get("/finder/store/")).andExpect(status().isOk());
    }

    @Test
    public void test_should_return_404_when_not_found_stores() throws Exception {

        when(service.findAll()).thenThrow(StoreNotFoundException.class);
        this.mockMvc.perform(get("/finder/store/")).andExpect(status().is(404)).andReturn();

    }

}