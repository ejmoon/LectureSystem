package com.company.education.enrollment.mapper;

import com.company.education.common.mapper.GenericMapper;
import com.company.education.enrollment.Enrollment;
import com.company.education.web.enrollment.dto.EnrollmentDTO;
import com.company.education.web.enrollment.dto.EnrollmentListDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentListMapper extends GenericMapper<EnrollmentListDTO, Enrollment> {
}