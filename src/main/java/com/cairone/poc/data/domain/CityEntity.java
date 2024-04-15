package com.cairone.poc.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class CityEntity {

    @Id
    @Column(name = "city_id")
    private Long id;

    @Column(name = "name", length = 300, nullable = false)
    private String name;

    public CityEntity() {
    }

    public CityEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityEntity id(Long id) {
        this.id = id;
        return this;
    }

    public CityEntity name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
