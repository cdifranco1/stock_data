package com.cdifranco.investingapp.controllers;


import com.cdifranco.investingapp.models.Company;
import com.cdifranco.investingapp.models.User;
import com.cdifranco.investingapp.services.CompanyService;
import com.cdifranco.investingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private CompanyService companyService;

  @GetMapping(path = "/user/{userid}")
  public ResponseEntity<?> getUserById(@PathVariable("userid") long userid){
    User user = userService.findById(userid);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  // Get user companies - http://localhost:8090/users/companies/{userid}
  @GetMapping(path = "/companies/{userid}")
  public ResponseEntity<?> getUserCompanies(@PathVariable("userid") long userid){
    User user = userService.findById(userid);
    List<Company> userCompanies = user.getCompanies();

    return new ResponseEntity<>(userCompanies, HttpStatus.OK);
  }

  // Create new users - http://localhost:8090/users/user/{userid}
  @PostMapping(path = "/user", consumes = "application/json")
  public ResponseEntity<?> addUser(@Valid @RequestBody User user) {

    user.setUserid(0);
    User newUser = userService.saveUser(user);

    HttpHeaders responseHeaders = new HttpHeaders();
    URI newUsersURI = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{userid}")
        .buildAndExpand(newUser.getUserid())
        .toUri();

    responseHeaders.setLocation(newUsersURI);

    return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
  }

  @PostMapping(path = "/companies/{userid}", consumes = "application/json")
  public ResponseEntity<?> addCompany(@PathVariable long userid, @Valid @RequestBody Company company){
    User activeUser = userService.findById(userid);

    company.setCompanyid(0);
    company.setUser(activeUser);

    Company newCompany = companyService.saveCompany(company);

    HttpHeaders headers = new HttpHeaders();

    URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
        .build()
        .toUri();

    headers.setLocation(location);

    return new ResponseEntity<>(newCompany, headers, HttpStatus.CREATED);
  }

}
