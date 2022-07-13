package com.company.education.enrollment.mapper;

import com.company.education.enrollment.Enrollment;
import com.company.education.web.enrollment.dto.EnrollmentListDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T15:53:48+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class EnrollmentListMapperImpl implements EnrollmentListMapper {

    @Override
    public EnrollmentListDTO toDto(Enrollment e) {
        if ( e == null ) {
            return null;
        }

        EnrollmentListDTO enrollmentListDTO = new EnrollmentListDTO();

        enrollmentListDTO.setLectureSeq( e.getLectureSeq() );
        enrollmentListDTO.setSchedule( e.getSchedule() );
        enrollmentListDTO.setSummary( e.getSummary() );

        return enrollmentListDTO;
    }

    @Override
    public Enrollment toEntity(EnrollmentListDTO d) {
        if ( d == null ) {
            return null;
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setLectureSeq( d.getLectureSeq() );
        enrollment.setSummary( d.getSummary() );
        enrollment.setSchedule( d.getSchedule() );

        return enrollment;
    }
}
