package com.cairone.poc.graphql.ctrl;

import com.cairone.poc.data.domain.CityEntity;
import com.cairone.poc.data.domain.EmployeeEntity;
import com.cairone.poc.data.repository.CityRepository;
import com.cairone.poc.data.repository.EmployeeRepository;
import com.cairone.poc.graphql.AppNotFoundException;
import com.cairone.poc.graphql.request.EmployeeRequest;
import com.cairone.poc.graphql.type.EmployeeType;
import graphql.GraphQLContext;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeCtrl {

    private final CityRepository cityRepository;
    private final EmployeeRepository employeeRepository;

    @QueryMapping("findEmployeeById")
    public EmployeeType findById(@Argument Long id, GraphQLContext context) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new AppNotFoundException("Employee not found"));

        return EmployeeType.builder()
                .withId(id)
                .withNames(employeeEntity.getNames())
                .build();
    }

    @MutationMapping("createEmployee")
    public EmployeeType createEmployee(@Argument("input") @Valid EmployeeRequest employeeRequest) {

        CityEntity cityEntity = cityRepository.findById(employeeRequest.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeRepository.getMaxId().orElse(0L) + 1);
        employeeEntity.setNames(employeeRequest.getNames());
        employeeEntity.setCity(cityEntity);
        employeeRepository.save(employeeEntity);

        return EmployeeType.builder()
                .withId(employeeEntity.getId())
                .withNames(employeeEntity.getNames())
                .build();
    }
}
