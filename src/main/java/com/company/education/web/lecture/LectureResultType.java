package com.company.education.web.lecture;

import com.company.education.common.constant.ResultType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LectureResultType implements ResultType {

    SUCCESS(1000, "성공하였습니다");

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
