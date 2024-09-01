package com.Job_app.Job_Service.service;

import com.Job_app.Job_Service.client.CompanyClient;
import com.Job_app.Job_Service.client.ReviewClient;
import com.Job_app.Job_Service.mapper.JobMapper;
import com.Job_app.Job_Service.repository.JobRepository;
import com.Job_app.Job_Service.model.Job;
import com.Job_app.Job_Service.vo.Company;
import com.Job_app.Job_Service.dto.JobResponseTemplateDTO;
import com.Job_app.Job_Service.vo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService{

//    @Autowired
    JobRepository jobRepository;

    CompanyClient companyClient;
    ReviewClient reviewClient;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobResponseTemplateDTO> getAllJob() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    private JobResponseTemplateDTO convertToDTO(Job job){

//        the below implementation is by using RestTemplate
//        Company company = restTemplate.getForObject("http://localhost:8082/company/" + job.getCompanyId(), Company.class);
//        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange("http://localhost:8083/reviews?companyId=" + job.getCompanyId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {
//                });
//        List<Review> reviews = reviewResponse.getBody();

        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getReview(job.getCompanyId());
        JobResponseTemplateDTO jobDTO = JobMapper.mapToJobWithCompanyDTO(job, company, reviews);
        return jobDTO;
    }
    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobResponseTemplateDTO getJobById(Long jobId) {
//        return jobRepository.findById(jobId).orElse(null);
        Job job = jobRepository.findById(jobId).get();
        return  convertToDTO(job);
    }

    @Override
    public boolean deleteById(Long jobId) {
        try {
            jobRepository.deleteById(jobId);
            return true;
        }
         catch (Exception e){
             return false;
         }
    }

    @Override
    public boolean updateJob(Long jobId, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setJobDesignation(updatedJob.getJobDesignation());
            job.setJobLocation(updatedJob.getJobLocation());
            job.setJobName(updatedJob.getJobName());
            job.setJobSalary(updatedJob.getJobSalary());

            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
