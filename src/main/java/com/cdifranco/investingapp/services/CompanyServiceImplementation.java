package com.cdifranco.investingapp.services;

import com.cdifranco.investingapp.models.Company;
import com.cdifranco.investingapp.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service
public class CompanyServiceImplementation implements CompanyService {

  @Autowired
  private CompanyRepo companyRepo;

  public void saveCompany(Company company){
    companyRepo.save(company);
  }

  @Override
  public Company findById(long companyid) throws EntityNotFoundException{
    return companyRepo
        .findById(companyid)
        .orElseThrow(() -> new EntityNotFoundException("Company " + companyid + " not found"));
  }

  @Override
  public Company findByName(String companyName) throws EntityNotFoundException{
    Company company =  companyRepo.findCompanyByCompanyname(companyName);

    if (company == null){
      throw new EntityNotFoundException(companyName + "not found");
    }

    return company;
  }



}
