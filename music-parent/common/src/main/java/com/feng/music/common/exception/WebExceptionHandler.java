package com.feng.music.common.exception;

import com.feng.music.common.dto.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-11
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {

    @ModelAttribute
    public void setResponse(HttpServletResponse response) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @ExceptionHandler(NullPointerException.class)
    @Order(0)
    public Response<Void> nullPointerExceptionExceptionHandler(NullPointerException ex, HttpServletRequest request) {
        log.warn("请求地址:{}", request.getRequestURI(), ex);
        return Response.error(ErrorMessage.errorOfMessage("缺省参数!"));
    }

    @ExceptionHandler(BusinessException.class)
    @Order(1)
    public Response<Void> bussinessExceptionHandler(BusinessException ex) {
        log.warn("异常拦截", ex);
        return Response.error(new ErrorMessage(ex.getCode(), ex.getMessage()));
    }


    @ExceptionHandler(ClientAbortException.class)
    @Order(3)
    public void clientAbortExceptionHandler() {
        log.debug("异常拦截,请求被放弃->ClientAbortException");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Order(4)
    public Response<Void> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        log.warn("异常拦截", ex);
        return Response.error(ErrorMessage.errorOfMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(BindException.class)
    @Order(5)
    public Response<Void> bindExceptionHandler(BindException ex) {
        log.warn("异常拦截", ex);
        return Response.error(ErrorMessage.errorOfMessage("参数错误"));
    }

    @ExceptionHandler(NestedRuntimeException.class)
    @Order(8)
    public Response<Void> accessNestedRuntimeExceptionHandler(Exception ex) {
        log.error("异常拦截", ex);
        return Response.error(ErrorMessage.errorOfMessage("处理失败!请联系管理员!"));
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @Order(10)
    public Response<Void> maxUploadSizeExceededExceptionHandler(Exception ex, HttpServletRequest request) {
        log.warn("请求地址:{},{}", request.getRequestURI(), "上传文件大小超出限制", ex);
        return Response.error(ErrorMessage.errorOfMessage("上传文件大小超出限制!"));
    }

    @ExceptionHandler(ValidationException.class)
    @Order(11)
    public Response<Void> validationExceptionHandler(ValidationException ex, HttpServletRequest request) {
        log.warn("请求地址:{},{}", request.getRequestURI(), "参数校验异常", ex);
        String message = ex.getMessage();
        String messageTemplate = "messageTemplate='";
        int beginIndex = message.indexOf(messageTemplate) + messageTemplate.length();
        String temp = message.substring(beginIndex);
        String result = temp.substring(0, temp.indexOf("'"));
        return Response.error(ErrorMessage.errorOfMessage(result));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @Order(13)
    public Response<Void> noHandlerFoundExceptionHandler(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.warn("请求地址:{},{}", request.getRequestURI(), "接口不存在!", ex);
        return Response.error(ErrorMessage.errorOfMessage("接口不存在！"));
    }

    @ExceptionHandler(NumberFormatException.class)
    @Order(14)
    public Response<Void> numberFormatExceptionHandler(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.warn("请求地址:{},{}", request.getRequestURI(), "接口不存在!", ex);
        return Response.error(ErrorMessage.errorOfMessage("接口不存在！"));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @Order(15)
    public Response<Void> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex, HttpServletRequest request) {
        log.warn("请求地址:{},DataIntegrityViolationException...", request.getRequestURI(), ex);
        return Response.error(ErrorMessage.errorOfMessage("处理失败！"));
    }

    @ExceptionHandler(FileUploadException.class)
    @Order(17)
    public Response<Void> fileUploadExceptionExceptionHandler(FileUploadException ex, HttpServletRequest request) {
        log.warn("请求地址:{},{}", request.getRequestURI(), "文件为空!", ex);
        return Response.error(ErrorMessage.errorOfMessage("请选择文件！"));
    }

    @ExceptionHandler(Throwable.class)
    @Order(999)
    public Response<Void> throwableHandler(Throwable t) {
        log.error("异常拦截", t);
        return Response.error(ErrorMessage.errorOfMessage("处理失败!"));
    }
}
