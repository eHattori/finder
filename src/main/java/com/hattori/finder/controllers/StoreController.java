package com.hattori.finder.controllers;

import java.util.List;

import com.hattori.finder.entities.Store;
import com.hattori.finder.exceptions.StoreNotFoundException;
import com.hattori.finder.services.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StoreController
 */
@RestController
@RequestMapping("finder/store")
@CrossOrigin("*")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping("/")
    public ResponseEntity<List<Store>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/branch/{branch}")
    public ResponseEntity<Store> findByBranch(@PathVariable int branch) {
        try {
            return new ResponseEntity<Store>(service.findByBranch(branch), HttpStatus.OK);
        } catch (StoreNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Store> create(
            @Validated({ Store.New.class, Store.Existing.class }) @RequestBody Store store) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOne(store));
    }

}