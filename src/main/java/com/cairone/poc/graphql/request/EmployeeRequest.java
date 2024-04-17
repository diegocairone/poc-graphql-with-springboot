package com.cairone.poc.graphql.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {

    @NotBlank
    private String names;

    @NotNull
    private Long cityId;
}
