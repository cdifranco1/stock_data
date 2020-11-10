package com.cdifranco.investingapp.repos;

import com.cdifranco.investingapp.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company, Long> {

  public Company findCompanyByCompanyname(String companyName);
}
