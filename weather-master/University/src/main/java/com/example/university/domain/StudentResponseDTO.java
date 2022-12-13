package com.example.university.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class StudentResponseDTO {

    @JsonProperty("data")
    private List<StudentDTO> studentDTOS;
}




