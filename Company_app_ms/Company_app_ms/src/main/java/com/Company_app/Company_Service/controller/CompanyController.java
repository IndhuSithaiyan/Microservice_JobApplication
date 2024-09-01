package com.Company_app.Company_Service.controller;

import com.Company_app.Company_Service.model.Company;
import com.Company_app.Company_Service.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/allCompanies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId,
                                                @RequestBody Company updatedCompany){
        boolean updated = companyService.updateCompany(companyId, updatedCompany);
        if (updated)
            return new ResponseEntity<>("Company updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<String> getCompanyById(@PathVariable Long companyId){
        Company company = companyService.getCompanyById(companyId);
        if (company != null)
            return new ResponseEntity(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId){
        boolean deleted = companyService.deleteCompanyById(companyId);
        if (deleted)
            return new ResponseEntity<>("Company deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }


}
