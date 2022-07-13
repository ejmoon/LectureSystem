package com.company.education.lecture.mapper;

import com.company.education.lecture.Lecture;
import com.company.education.web.lecture.dto.LectureDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T15:53:48+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class LectureMapperImpl implements LectureMapper {

    @Override
    public LectureDTO toDto(Lecture e) {
        if ( e == null ) {
            return null;
        }

        Long lectureSeq = null;
        String summary = null;
        LocalDateTime schedule = null;
        String talker = null;
        String place = null;
        Integer capacity = null;

        lectureSeq = e.getLectureSeq();
        summary = e.getSummary();
        schedule = e.getSchedule();
        talker = e.getTalker();
        place = e.getPlace();
        capacity = e.getCapacity();

        LectureDTO lectureDTO = new LectureDTO( lectureSeq, summary, schedule, talker, place, capacity );

        return lectureDTO;
    }

    @Override
    public Lecture toEntity(LectureDTO d) {
        if ( d == null ) {
            return null;
        }

        Lecture lecture = new Lecture();

        lecture.setLectureSeq( d.getLectureSeq() );
        lecture.setSummary( d.getSummary() );
        lecture.setSchedule( d.getSchedule() );
        lecture.setTalker( d.getTalker() );
        lecture.setPlace( d.getPlace() );
        lecture.setCapacity( d.getCapacity() );

        return lecture;
    }
}
