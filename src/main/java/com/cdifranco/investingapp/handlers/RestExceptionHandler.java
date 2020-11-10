package com.cdifranco.investingapp.handlers;


import com.cdifranco.investingapp.exceptions.ResourceNotFoundException;
import com.cdifranco.investingapp.models.ErrorDetail;
import com.cdifranco.investingapp.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @Autowired
  HelperFunctions helperFunctions;

  public RestExceptionHandler(){
    super();
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException resourceNotFoundException){
    ErrorDetail errorDetail = new ErrorDetail();

    errorDetail.setTimestamp(new Date());
    errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
    errorDetail.setTitle("Resource not found");
    errorDetail.setDetails(resourceNotFoundException.getMessage());
    errorDetail.setDevelopermessage(resourceNotFoundException.getClass().getName());
    errorDetail.setErrors(helperFunctions.getConstraintViolations(resourceNotFoundException));

    return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                           Object body,
                                                           HttpHeaders headers,
                                                           HttpStatus status,
                                                           WebRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();

    errorDetail.setTimestamp(new Date());
    errorDetail.setStatus(status.value());
    errorDetail.setTitle("Generic Internal Error");
    errorDetail.setDetails(ex.getMessage());
    errorDetail.setDevelopermessage(request.getDescription(false));
    errorDetail.setErrors(helperFunctions.getConstraintViolations(ex));

    return new ResponseEntity<>(errorDetail, null, HttpStatus.BAD_REQUEST);

  }
}
