package com.feng.music.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author linqf
 * @description
 * @date 2024-07-11
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = -3915972475094394588L;

    public static final String SUCCESS = "200";
    public static final String DEFAULT_ERROR = "5000";
    public static final String DEFAULT_ERROR_MESSAGE = "错误!";
    private String errorCode;
    private String errorMessage;

    public static ErrorMessage success() {
        return new ErrorMessage("200", null);
    }

    public static ErrorMessage defaultError() {
        return new ErrorMessage("5000", "错误!");
    }

    public static ErrorMessage errorOfMessage(String errorMessage) {
        return new ErrorMessage("5000", errorMessage);
    }
}
