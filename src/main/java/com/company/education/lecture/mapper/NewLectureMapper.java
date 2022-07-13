package com.company.education.lecture.mapper;

import com.company.education.common.mapper.GenericMapper;
import com.company.education.lecture.Lecture;
import com.company.education.web.lecture.dto.NewLectureDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewLectureMapper extends GenericMapper<NewLectureDTO, Lecture> {
}
