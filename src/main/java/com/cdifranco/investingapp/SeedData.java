package com.cdifranco.investingapp;

import com.cdifranco.investingapp.models.Company;
import com.cdifranco.investingapp.models.User;
import com.cdifranco.investingapp.repos.CompanyRepo;
import com.cdifranco.investingapp.repos.UserRepo;
import com.cdifranco.investingapp.services.CompanyService;
import com.cdifranco.investingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
  @Autowired
  private UserService userService;

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private CompanyService companyService;

  @Autowired
  private CompanyRepo companyRepo;

  public void run(String[] args){
    userRepo.deleteAll();
    companyRepo.deleteAll();

    User user1 = new User("cdifranco", "pass1");
    userService.saveUser(user1);
    User user2 = new User("cdifranco2", "pass2");
    userService.saveUser(user2);
    User user3 = new User("cdifranco3", "pass3");
    userService.saveUser(user3);

    Company comp1 = new Company("twitter", "twtr");
    comp1.setUser(user1);
    companyService.saveCompany(comp1);
    Company comp2 = new Company("twitter", "twtr");
    comp2.setUser(user1);
    companyService.saveCompany(comp2);
    Company comp3 = new Company("twitter", "twtr");
    comp3.setUser(user1);
    companyService.saveCompany(comp3);
    Company comp4 = new Company("twitter", "twtr");
    comp4.setUser(user2);
    companyService.saveCompany(comp4);
  }



}
