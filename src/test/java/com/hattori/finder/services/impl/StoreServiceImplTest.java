package com.hattori.finder.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.hattori.finder.FinderApplicationTests;
import com.hattori.finder.entities.Store;
import com.hattori.finder.exceptions.StoreNotFoundException;
import com.hattori.finder.repositories.StoreRepository;
import com.hattori.finder.services.StoreService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * StoreServiceTest
 */
public class StoreServiceImplTest extends FinderApplicationTests {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private StoreService service;

    @Before
    public void setup() throws Exception {
        repository.deleteAll();
    }

    private Store getStore() {
        return Store.builder().branch(1).description("TEST").postalCode(14400520).build();
    }

    @Test
    public void test_should_find_all_store_records() {
        repository.save(this.getStore());
        assertTrue(service.findAll().size() == 1);
    }

    @Test(expected = StoreNotFoundException.class)
    public void test_should_throw_store_not_found_exception_when_find_by_branch_not_existent() {
        service.findByBranch(1);
    }

    @Test
    public void test_should_find_store_by_branch() {
        repository.save(this.getStore());

        assertTrue(service.findByBranch(1).getBranch() == 1);
    }

    @Test
    public void test_should_create_one_store() {
        Store store = service.createOne(this.getStore());
        assertTrue(repository.findById(store.getId()).isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void test_should_raise_exception_create_with_branch_existing() {
        repository.save(this.getStore());
        service.createOne(this.getStore());
    }

    @Test(expected = StoreNotFoundException.class)
    public void test_should_raise_exception_where_not_found_store_to_update() {
        service.update("28d7186a-9323-11e8-9eb6-529269fb1459", this.getStore());
    }

    @Test
    public void test_should_update_store() {
        Store store = repository.save(this.getStore());
        store.setDescription("UPDATE");

        service.update(store.getId().toString(), store);
        Store upStore = repository.findById(store.getId()).get();

        assertEquals(upStore.getDescription(), "UPDATE");
    }

}