package com.winsoon.student.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotBlank
    private String studentId;

    @NotBlank
    private String studentName;

    private String email;
    private String course;
}
