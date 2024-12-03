package com.shop.SV_TASK;

import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailConflictException(final DataIntegrityViolationException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({EntityNotFoundException.class, ValidationException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundExceptions(final RuntimeException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleThrowable(final Throwable e) {
        return new ErrorResponse("Непредвиденная ошибка: " + e.getMessage());
    }

}
