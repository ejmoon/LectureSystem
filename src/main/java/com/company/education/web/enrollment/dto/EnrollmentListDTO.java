package com.company.education.web.enrollment.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class EnrollmentListDTO {

    private Long lectureSeq;
    private LocalDateTime schedule;
    private String summary;

}
