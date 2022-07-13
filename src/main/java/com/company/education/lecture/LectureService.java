package com.company.education.lecture;

import com.company.education.lecture.mapper.LectureMapper;
import com.company.education.lecture.mapper.NewLectureMapper;
import com.company.education.web.lecture.dto.LectureDTO;
import com.company.education.web.lecture.dto.NewLectureDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureDAO lectureDAO;
    private final LectureMapper lectureMapper;
    private final NewLectureMapper newLectureMapper;


    /**
     * 전체 강연 목록을 조회한다.
     */
    public List<LectureDTO> getAllLectures() {
        List<Lecture> lectures = lectureDAO.selectAllLectures();
        return lectures.stream().map(lecture -> lectureMapper.toDto(lecture)).collect(Collectors.toList());
    }

    /**
     * 신청 가능한 강연 목록을 가져온다.
     * @return
     */
    public List<LectureDTO> getLectures() {
        List<Lecture> lectures = lectureDAO.selectLectures();
        return lectures.stream().map(lecture -> lectureMapper.toDto(lecture)).collect(Collectors.toList());
    }

    /**
     * 신규 강연을 등록한다.
     * @return
     * @param
     */
    @Transactional
    public void makeNewLecture(NewLectureDTO newLectureDTO) {
        lectureDAO.insertLecture(newLectureMapper.toEntity(newLectureDTO));
    }

}
