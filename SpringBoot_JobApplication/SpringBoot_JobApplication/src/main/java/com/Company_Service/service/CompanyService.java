package com.Company_Service.service;

import com.Company_Service.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();
    void createCompany(Company company);
    Company getCompanyById(Long companyId);
    boolean deleteCompanyById(Long companyId);
    boolean updateCompany(Long companyId, Company updatedCompany);

}
