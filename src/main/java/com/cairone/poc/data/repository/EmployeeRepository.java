package com.cairone.poc.data.repository;

import com.cairone.poc.data.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("SELECT MAX(e.id) FROM EmployeeEntity e")
    Optional<Long> getMaxId();
}
