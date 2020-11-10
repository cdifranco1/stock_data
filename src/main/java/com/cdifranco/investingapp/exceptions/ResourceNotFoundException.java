package com.cdifranco.investingapp.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String message){
    super(message);
  }

}
