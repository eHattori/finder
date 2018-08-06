package com.hattori.finder.services.impl;

import java.util.List;
import java.util.UUID;

import com.hattori.finder.entities.Store;
import com.hattori.finder.exceptions.StoreNotFoundException;
import com.hattori.finder.repositories.StoreRepository;
import com.hattori.finder.services.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StoreServiceImpl
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository repository;

    @Override
    public List<Store> findAll() {

        List<Store> lsStore = repository.findAll();
        if (lsStore.size() == 0)
            throw new StoreNotFoundException();

        return lsStore;
    }

    @Override
    public Store findByBranch(int branch) throws StoreNotFoundException {
        return repository.findByBranch(branch).orElseThrow(() -> new StoreNotFoundException());
    }

    @Override
    public Store createOne(final Store store) {
        return repository.save(store);
    }

    @Override
    public void update(final String id, final Store store) {

        UUID uuid = UUID.fromString(id);
        Store storeObj = repository.findById(uuid).orElseThrow(() -> new StoreNotFoundException());
        storeObj.setBranch(store.getBranch());
        storeObj.setDescription(store.getDescription());
        storeObj.setPostalCode(store.getPostalCode());

        repository.save(storeObj);
    }

}