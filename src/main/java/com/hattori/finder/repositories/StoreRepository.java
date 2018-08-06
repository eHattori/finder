package com.hattori.finder.repositories;

import java.util.Optional;
import java.util.UUID;

import com.hattori.finder.entities.Store;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StoreRepository
 */
public interface StoreRepository extends JpaRepository<Store, UUID> {

    public Optional<Store> findByBranch(int branch);

}