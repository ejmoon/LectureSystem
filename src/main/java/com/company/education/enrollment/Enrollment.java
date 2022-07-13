package com.company.education.enrollment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Enrollment {

    private Long enrollmentSeq;
    private Long employeeSeq;
    private String employeeId;
    private Integer status;
    private Long lectureSeq;
    private String summary;
    private LocalDateTime schedule;

}
