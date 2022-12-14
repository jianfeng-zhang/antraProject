package com.example.employee.domain;

import lombok.Data;

import java.util.List;
@Data
public class PageDTO {
    private String status;
    private List<EmployeeDTO> data;
    private String message;
}
