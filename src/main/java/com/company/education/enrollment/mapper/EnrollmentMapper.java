package com.company.education.enrollment.mapper;

import com.company.education.common.mapper.GenericMapper;
import com.company.education.enrollment.Enrollment;
import com.company.education.web.enrollment.dto.EnrollmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper extends GenericMapper<EnrollmentDTO, Enrollment> {
}