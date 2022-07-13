package com.company.education.lecture;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Lecture {

    private Long lectureSeq;
    private String summary;
    private LocalDateTime schedule;
    private String talker;
    private String place;
    private Integer capacity;
    private Integer emptySeat;

}
