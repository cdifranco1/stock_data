package com.cdifranco.investingapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long companyid;

  @Column(nullable = false)
  private String companyname;

  @Column(nullable = false)
  private String symbol;

  @ManyToOne
  @JoinColumn(name = "userid", nullable = false)
  @JsonIgnoreProperties(value = "companies", allowSetters = true)
  private User user;

  public Company() {
  }

  public Company(String companyname, String symbol) {
    this.companyname = companyname;
    this.symbol = symbol;
  }

  public long getCompanyid() {
    return companyid;
  }

  public void setCompanyid(long companyId) {
    this.companyid = companyId;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyName) {
    this.companyname = companyName;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
