package com.company.education.enrollment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
interface EnrollmentDAO {
    List<Enrollment> selectEnrollmentsByEmployeeId(String employeeNumber);

    List<String> selectEnrolledEmployeeIds(long lectureSeq);

    int insertEnrollment(Enrollment enrollment);

    int selectLectureEmptySeat(Enrollment enrollment);

    int updateLectureEmptySeat(Enrollment enrollment);

    int selectCountEnrollingLecture(Enrollment enrollment);

    int selectCountAvailableLecture(Enrollment enrollment);
}
