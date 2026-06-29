package com.winsoon.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateRequest {

    private String studentName;
    private String email;
    private String course;
}
