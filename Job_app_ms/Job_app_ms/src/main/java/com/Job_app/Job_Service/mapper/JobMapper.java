package com.Job_app.Job_Service.mapper;

import com.Job_app.Job_Service.model.Job;
import com.Job_app.Job_Service.vo.Company;
import com.Job_app.Job_Service.dto.JobResponseTemplateDTO;
import com.Job_app.Job_Service.vo.Review;

import java.util.List;

public class JobMapper {

    public static JobResponseTemplateDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> reviews){

        JobResponseTemplateDTO jobDTO = new JobResponseTemplateDTO();
        jobDTO.setJobId(job.getJobId());
        jobDTO.setJobName(job.getJobName());
        jobDTO.setJobDesignation(job.getJobDesignation());
        jobDTO.setJobLocation(job.getJobLocation());
        jobDTO.setJobSalary(job.getJobSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);

        return jobDTO;
    }
}
