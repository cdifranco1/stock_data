package com.cdifranco.investingapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userid;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @OneToMany(
      mappedBy = "user",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @JsonIgnoreProperties("user")
  private List<Company> companies = new ArrayList<>();

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public List<Company> getCompanies() {
    return companies;
  }

  public void setCompanies(
      List<Company> companies) {
    this.companies = companies;
  }
}
