package com.cairone.poc.graphql.ctrl;

import com.cairone.poc.data.domain.EmployeeEntity;
import com.cairone.poc.data.repository.EmployeeRepository;
import com.cairone.poc.graphql.type.EmployeeType;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeCtrl {

    private final EmployeeRepository employeeRepository;

    @QueryMapping("findEmployeeById")
    public EmployeeType findById(@Argument Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

        return EmployeeType.builder()
                .withId(id)
                .withNames(employeeEntity.getNames())
                .build();
    }
}
