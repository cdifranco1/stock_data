package com.cdifranco.investingapp.controllers;


import com.cdifranco.investingapp.models.Company;
import com.cdifranco.investingapp.models.User;
import com.cdifranco.investingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping(path = "/user/{userid}")
  public ResponseEntity<?> getUserById(@PathVariable("userid") long userid){
    User user = userService.findById(userid);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  // http://localhost:8090/companies/{userid}
  @GetMapping(path = "/companies/{userid}")
  public ResponseEntity<?> getUserCompanies(@PathVariable("userid") long userid){
    User user = userService.findById(userid);
    List<Company> userCompanies = user.getCompanies();

    return new ResponseEntity<>(userCompanies, HttpStatus.OK);
  }

}
