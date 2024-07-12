package com.feng.music.common.exception;

import lombok.Getter;

import java.io.Serial;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-11
 */
@Getter
public class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3836077837635372644L;

    private String code;

    public BusinessException(Exception ex) {
        super(ex.getMessage(), ex);
        this.code = "5000";
    }

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
        this.code = errorMessage.getErrorCode();
    }

    public BusinessException(ErrorMessage errorMessage, Exception ex) {
        super(errorMessage.getErrorMessage(), ex);
        this.code = errorMessage.getErrorCode();
    }

    public static BusinessException of(String message) {
        return new BusinessException(ErrorMessage.errorOfMessage(message));
    }

    public static BusinessException of(Exception ex) {
        return new BusinessException(ex);
    }

    public static BusinessException of(ErrorMessage errorMessage) {
        return new BusinessException(errorMessage);
    }

    public static BusinessException of(ErrorMessage errorMessage, Exception ex) {
        return new BusinessException(errorMessage, ex);
    }
}
