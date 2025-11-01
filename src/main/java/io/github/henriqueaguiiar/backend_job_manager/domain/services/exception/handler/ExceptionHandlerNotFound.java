package io.github.henriqueaguiiar.backend_job_manager.domain.services.exception.handler;


import io.github.henriqueaguiiar.backend_job_manager.domain.services.exception.dto.ExceptionHandlerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerNotFound {


    private MessageSource messageSource;

    @Autowired
    public ExceptionHandlerNotFound(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionHandlerDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ExceptionHandlerDTO> errosDto= new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach((error) -> {
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ExceptionHandlerDTO exceptionHandlerDTO = new ExceptionHandlerDTO(message, error.getField());
            errosDto.add(exceptionHandlerDTO);
        });
        return new ResponseEntity<>(errosDto, HttpStatus.BAD_REQUEST);
    }




}
