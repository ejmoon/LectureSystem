package com.company.education.lecture;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
interface LectureDAO {

    List<Lecture> selectAllLectures();

    int insertLecture(Lecture lecture);

    List<Lecture> selectLectures();

}
