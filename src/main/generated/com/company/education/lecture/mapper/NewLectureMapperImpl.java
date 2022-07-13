package com.company.education.lecture.mapper;

import com.company.education.lecture.Lecture;
import com.company.education.web.lecture.dto.NewLectureDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T15:53:48+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class NewLectureMapperImpl implements NewLectureMapper {

    @Override
    public NewLectureDTO toDto(Lecture e) {
        if ( e == null ) {
            return null;
        }

        NewLectureDTO newLectureDTO = new NewLectureDTO();

        return newLectureDTO;
    }

    @Override
    public Lecture toEntity(NewLectureDTO d) {
        if ( d == null ) {
            return null;
        }

        Lecture lecture = new Lecture();

        lecture.setSummary( d.getSummary() );
        lecture.setSchedule( d.getSchedule() );
        lecture.setTalker( d.getTalker() );
        lecture.setPlace( d.getPlace() );
        lecture.setCapacity( d.getCapacity() );

        return lecture;
    }
}
