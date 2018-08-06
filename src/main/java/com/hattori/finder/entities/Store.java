package com.hattori.finder.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StoreEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Store {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("description")
    @NotNull(groups = { New.class }, message = "The Field Description can not be null")
    @Column(nullable = false)
    private String description;

    @JsonProperty("branch")
    @NotNull(groups = { New.class, Existing.class }, message = "The Field Branch can not be null")
    @Column(nullable = false, unique = true)
    private int branch;

    @JsonProperty("postalCode")
    @NotNull(groups = { New.class }, message = "The Field PostaclCode can not be null")
    @Column(nullable = false)
    private int postalCode;

    public interface New {

    }

    public interface Existing {

    }

}