package com.hattori.finder.services;

import java.util.List;

import com.hattori.finder.entities.Store;
import com.hattori.finder.exceptions.StoreNotFoundException;

/**
 * StoreService
 */
public interface StoreService {

    List<Store> findAll();

    Store findByBranch(int branch) throws StoreNotFoundException;

    Store createOne(Store store);

    void update(String id, Store store);

}