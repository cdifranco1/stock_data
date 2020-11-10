package com.cdifranco.investingapp.services;


import com.cdifranco.investingapp.models.ValidationError;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@Service
public class HelperFunctions {

  public List<ValidationError> getConstraintViolations(Throwable cause){

    while ((cause != null) && !(cause instanceof ConstraintViolationException)){
      cause = cause.getCause();
    }

    List<ValidationError> validationErrors = new ArrayList<>();

    if (cause != null){
      ConstraintViolationException ex = (ConstraintViolationException) cause;

      for (ConstraintViolation cv : ex.getConstraintViolations()){
        ValidationError newVE = new ValidationError();

        newVE.setCode(cv.getInvalidValue().toString());
        newVE.setMessage(cv.getMessage());

        validationErrors.add(newVE);
      }
    }

    return validationErrors;
  }

}
