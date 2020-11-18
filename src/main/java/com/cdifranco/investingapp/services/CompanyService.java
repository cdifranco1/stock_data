package com.cdifranco.investingapp.services;


import com.cdifranco.investingapp.models.Company;

import java.util.List;

public interface CompanyService {

  public Company saveCompany(Company company);

  public Company findById(long id);

  public Company findByName(String companyName);

//  public Company findById(long companyid);

//  public Company findByCompanyName(String companyname);
//
//  public
}
