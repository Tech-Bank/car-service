package edu.prz.carservice.configuration;

import edu.prz.carservice.foundation.application.ProblemResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    List<String> violations = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getField() + ": " + error.getDefaultMessage())
        .toList();

    ProblemResponse problemResponse = new ProblemResponse();
    problemResponse.setTitle("validationFailed");
    problemResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    problemResponse.setDetail("Request validation failed");
    problemResponse.setViolations(violations);

    return handleExceptionInternal(ex, problemResponse, headers, HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(value = EntityNotFoundException.class)
  public ResponseEntity<Object> handle(EntityNotFoundException e, WebRequest request) {

    ProblemResponse problemResponse = new ProblemResponse();
    problemResponse.setTitle("entityNotFound");
    problemResponse.setStatus(HttpStatus.NOT_FOUND.value());
    problemResponse.setDetail("Entity not found");

    return handleExceptionInternal(e, problemResponse, new HttpHeaders(), HttpStatus.NOT_FOUND,
        request);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Object> handle(Exception e, WebRequest request) {

    ProblemResponse problemResponse = new ProblemResponse();
    problemResponse.setTitle("serverError");
    problemResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    problemResponse.setDetail("Server error");

    return handleExceptionInternal(e, problemResponse, new HttpHeaders(),
        HttpStatus.INTERNAL_SERVER_ERROR, request);
  }
}