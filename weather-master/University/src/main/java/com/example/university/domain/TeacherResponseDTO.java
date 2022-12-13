package com.example.university.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class TeacherResponseDTO {

    @JsonProperty("data")
    private List<TeacherDTO> teacherDTOs;
}
