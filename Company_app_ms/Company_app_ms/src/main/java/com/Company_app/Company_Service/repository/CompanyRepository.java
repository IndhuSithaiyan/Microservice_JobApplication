package com.Company_app.Company_Service.repository;

import com.Company_app.Company_Service.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
