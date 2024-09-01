package com.Company_Service.repository;

import com.Company_Service.model.Company;
import com.Job_Service.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
