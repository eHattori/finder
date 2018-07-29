package com.hattori.finder.repositories;

import java.util.UUID;

import com.hattori.finder.entities.Store;

import org.springframework.data.repository.CrudRepository;

/**
 * StoreRepository
 */
public interface StoreRepository extends CrudRepository<Store, UUID> {

}