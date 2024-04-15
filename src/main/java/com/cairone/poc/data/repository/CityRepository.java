package com.cairone.poc.data.repository;

import com.cairone.poc.data.domain.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
