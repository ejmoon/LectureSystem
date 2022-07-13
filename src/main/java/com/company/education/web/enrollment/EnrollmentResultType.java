package com.company.education.web.enrollment;

import com.company.education.common.constant.ResultType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnrollmentResultType implements ResultType {

    SUCCESS(1000, "성공하였습니다."),
    NOT_EMPTY_SEAT(1001, "인원 신청이 마감되었습니다."),
    ALREADY_ENROLLMENT(1002, "이미 신청한 강연입니다."),
    NOT_AVAILABLE_LECTURE(1003, "신청 가능한 강연이 아닙니다.");

    private final Integer code;
    private final String message;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
