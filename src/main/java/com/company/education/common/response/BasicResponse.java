package com.company.education.common.response;

import com.company.education.common.constant.ResultType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class BasicResponse<T> {

    private Integer code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public static <T> ResponseEntity<BasicResponse<T>> toResponseEntity(T body, ResultType resultType) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BasicResponse.<T>builder()
                        .code(resultType.getCode())
                        .message(resultType.getMessage())
                        .result(body)
                        .build());
    }

    public static <T> ResponseEntity<BasicResponse<T>> toResponseEntity(ResultType resultType) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BasicResponse.<T>builder()
                        .code(resultType.getCode())
                        .message(resultType.getMessage())
                        .build());
    }


}
