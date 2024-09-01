package com.Job_app.Job_Service.client;

import com.Job_app.Job_Service.vo.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {

    @GetMapping("/company/{id}")
    Company getCompany(@PathVariable("id") Long id);
}
