package com.Company_Service.service;

import com.Company_Service.model.Company;
import com.Company_Service.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long companyId) {
        if (companyRepository.existsById(companyId)){
            companyRepository.deleteById(companyId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(Long companyId, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setCompanyName(updatedCompany.getCompanyName());
            company.setCompanyDescription(updatedCompany.getCompanyDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
}
