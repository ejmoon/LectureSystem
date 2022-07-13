package com.company.education.web.enrollment;

import com.company.education.common.response.BasicResponse;
import com.company.education.enrollment.EnrollmentService;
import com.company.education.web.enrollment.dto.EnrollmentDTO;
import com.company.education.web.enrollment.dto.EnrollmentListDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Operation(summary = "강연 신청", description = "강연 신청을 한다.")
    @PutMapping("/front/enrollment")
    public ResponseEntity<BasicResponse<EnrollmentResultType>> enrollLecture(@RequestBody EnrollmentDTO enrollmentDTO){

        return BasicResponse.toResponseEntity(enrollmentService.enrollLecture(enrollmentDTO));
    }

    @Operation(summary = "신청 내역 조회", description = "사번으로 신청된 강연을 조회한다.")
    @GetMapping("/back/enrollments")
    public ResponseEntity<BasicResponse<List<EnrollmentListDTO>>> getEnrollmentsByEmployeeId(@RequestParam String employeeId){

        List<EnrollmentListDTO> result = enrollmentService.getEnrollmentsByEmployeeId(employeeId);
        return BasicResponse.toResponseEntity(result, EnrollmentResultType.SUCCESS);
    }

    @Operation(summary = "강연 신청자 목록", description = "강연 별로 신청한 사번 목록을 조회 한다.")
    @GetMapping("/back/enrollment/employeeIds")
    public ResponseEntity<BasicResponse<List<String>>> getEnrolledEmployeeIds(@RequestParam int lectureSeq){

        List<String> result = enrollmentService.getEnrolledEmployeeIds(lectureSeq);
        return BasicResponse.toResponseEntity(result, EnrollmentResultType.SUCCESS);
    }

}
