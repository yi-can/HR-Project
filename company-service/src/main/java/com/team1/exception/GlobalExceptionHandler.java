package com.team1.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static com.team1.exception.ErrorType.BAD_REQUEST_ERROR;
import static com.team1.exception.ErrorType.INTERNAL_ERROR;

//Aop
@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException exception){
        ErrorType ErrorType = INTERNAL_ERROR;
        return new ResponseEntity<>(createError(ErrorType,exception), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CompanyException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleSpringMonoException(CompanyException exception){
        return new ResponseEntity<>(createError(exception.getErrorType(),exception),exception.getErrorType().getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorMessage> handleMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        ErrorType ErrorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createError(ErrorType, exception), ErrorType.getHttpStatus());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MethodArgumentTypeMismatchException exception) {
        ErrorType ErrorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createError(ErrorType, exception), ErrorType.getHttpStatus());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MissingPathVariableException exception) {
        ErrorType ErrorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createError(ErrorType, exception), ErrorType.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        ErrorType ErrorType = BAD_REQUEST_ERROR;
        List<String> fields = new ArrayList<>();
        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
        ErrorMessage errorMessage = createError(ErrorType, exception);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(errorMessage, ErrorType.getHttpStatus());
    }
    private ErrorMessage createError(ErrorType ErrorType, Exception exception){
        System.out.println("HATA OLDU...: "+ exception.getMessage());
        return ErrorMessage.builder()
                .code(ErrorType.getCode())
                .message(ErrorType.getMessage())
                .build();
    }
}
