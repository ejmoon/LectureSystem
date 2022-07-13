package com.company.education.enrollment.mapper;

import com.company.education.enrollment.Enrollment;
import com.company.education.web.enrollment.dto.EnrollmentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T15:53:48+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

    @Override
    public EnrollmentDTO toDto(Enrollment e) {
        if ( e == null ) {
            return null;
        }

        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();

        enrollmentDTO.setLectureSeq( e.getLectureSeq() );
        enrollmentDTO.setEmployeeSeq( e.getEmployeeSeq() );

        return enrollmentDTO;
    }

    @Override
    public Enrollment toEntity(EnrollmentDTO d) {
        if ( d == null ) {
            return null;
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setEmployeeSeq( d.getEmployeeSeq() );
        enrollment.setLectureSeq( d.getLectureSeq() );

        return enrollment;
    }
}
