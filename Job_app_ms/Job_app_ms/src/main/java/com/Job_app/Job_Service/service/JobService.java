package com.Job_app.Job_Service.service;

import com.Job_app.Job_Service.model.Job;
import com.Job_app.Job_Service.dto.JobResponseTemplateDTO;

import java.util.List;

public interface JobService {

    List<JobResponseTemplateDTO> getAllJob();
    void createJob(Job job);
    JobResponseTemplateDTO getJobById(Long jobId);
    boolean deleteById(Long jobId);
    boolean updateJob(Long jobId, Job updatedJob);

}
