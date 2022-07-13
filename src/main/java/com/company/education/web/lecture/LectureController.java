package com.company.education.web.lecture;

import com.company.education.common.response.BasicResponse;
import com.company.education.lecture.LectureService;
import com.company.education.web.lecture.dto.LectureDTO;
import com.company.education.web.lecture.dto.NewLectureDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1")
public class LectureController {

    private final LectureService lectureService;

    @Operation(summary = "전체 강연 목록", description = "전체 강연 목록을 조회한다.")
    @GetMapping("/back/lectures")
    public ResponseEntity<BasicResponse<List<LectureDTO>>> getAllLectures (){

        List<LectureDTO> result = lectureService.getAllLectures();
        return BasicResponse.toResponseEntity(result, LectureResultType.SUCCESS);
    }

    @Operation(summary = "신규 강연 등록", description = "신규 강연을 등록한다.")
    @PostMapping("/back/lecture")
    public ResponseEntity<BasicResponse<LectureResultType>> makeNewLecture(@RequestBody NewLectureDTO newLectureDTO){

        lectureService.makeNewLecture(newLectureDTO);
        return BasicResponse.toResponseEntity(LectureResultType.SUCCESS);
    }

    @Operation(summary = "신청 가능한 강연 목록", description = "신청이 가능한 전체 강연 목록을 조회한다.")
    @GetMapping("/front/lectures")
    public ResponseEntity<BasicResponse<List<LectureDTO>>> getLectures(){

        List<LectureDTO> result = lectureService.getLectures();
        return BasicResponse.toResponseEntity(result, LectureResultType.SUCCESS);
    }

}
