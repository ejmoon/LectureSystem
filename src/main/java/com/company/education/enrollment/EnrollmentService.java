package com.company.education.enrollment;

import com.company.education.enrollment.mapper.EnrollmentListMapper;
import com.company.education.enrollment.mapper.EnrollmentMapper;
import com.company.education.web.enrollment.EnrollmentResultType;
import com.company.education.web.enrollment.dto.EnrollmentDTO;
import com.company.education.web.enrollment.dto.EnrollmentListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentDAO enrollmentDAO;
    private final EnrollmentMapper enrollmentMapper;
    private final EnrollmentListMapper enrollmentListMapper;

    /**
     * 강연신청을 한다.
     * @param enrollmentDTO
     * @return
     */
    @Transactional
    public EnrollmentResultType enrollLecture(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDTO);

        // 신청 가능한 강연인지 확인한다.
        final int availableLecture = enrollmentDAO.selectCountAvailableLecture(enrollment);
        if(availableLecture == 0) {
            return EnrollmentResultType.NOT_AVAILABLE_LECTURE;
        }

        // 강연의 중복 신청은 불가하다.(1인 1좌석 체크)
        final int overlapCount = enrollmentDAO.selectCountEnrollingLecture(enrollment);
        if(overlapCount > 0) {
            return EnrollmentResultType.ALREADY_ENROLLMENT;
        }

        // 강연의 잔여석이 있는 경우에만 등록이 가능하다.
        final int emptySeat = enrollmentDAO.selectLectureEmptySeat(enrollment);
        if(emptySeat > 0) {
            enrollmentDAO.insertEnrollment(enrollment);
            enrollmentDAO.updateLectureEmptySeat(enrollment);
        } else {
           return EnrollmentResultType.NOT_EMPTY_SEAT;
        }

        return EnrollmentResultType.SUCCESS;
    }

    /**
     * 사번으로 신청한 강연 목록을 조회한다.
     * @param employeeId
     */
    public List<EnrollmentListDTO> getEnrollmentsByEmployeeId(String employeeId) {
        List<Enrollment> enrollments = enrollmentDAO.selectEnrollmentsByEmployeeId(employeeId);
        return enrollments.stream().map(enrollment -> enrollmentListMapper.toDto(enrollment)).collect(Collectors.toList());
    }

    /**
     * 강연을 신청한 사원번호를 조회한다.
     * @param lectureSeq
     */
    public List<String> getEnrolledEmployeeIds(long lectureSeq) {
        return enrollmentDAO.selectEnrolledEmployeeIds(lectureSeq);
    }
}

