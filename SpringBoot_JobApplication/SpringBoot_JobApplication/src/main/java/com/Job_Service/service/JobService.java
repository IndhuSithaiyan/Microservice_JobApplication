package com.Job_Service.service;

import com.Job_Service.model.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJob();
    void createJob(Job job);
    Job getJobById(Long jobId);
    boolean deleteById(Long jobId);
    boolean updateJob(Long jobId, Job updatedJob);

}
