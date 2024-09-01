package com.Job_Service.service;

import com.Job_Service.model.Job;
import com.Job_Service.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJob() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
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
