package com.cairone.poc.graphql.ctrl;

import com.cairone.poc.data.domain.CityEntity;
import com.cairone.poc.data.repository.EmployeeRepository;
import com.cairone.poc.graphql.type.CityType;
import com.cairone.poc.graphql.type.EmployeeType;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CityCtrl {

    private final EmployeeRepository employeeRepository;

    @SchemaMapping(typeName = "Employee", field = "city")
    public CityType findById(EmployeeType employeeType) {

        CityEntity cityEntity = employeeRepository.findById(employeeType.getId())
                .map(e -> e.getCity())
                .orElse(null);

        return CityType.builder()
                .id(cityEntity.getId())
                .name(cityEntity.getName())
                .build();
    }
}
