package org.fanyi.fanyibackend.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseVO<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseVO<T> buildSuccessResponse(String msg, T data) {
        return new ResponseVO<T>(1, msg, data);
    }

    public static <T> ResponseVO<T> buildErrorResponse(String msg, T data) {
        return new ResponseVO<T>(0, msg, data);
    }
}