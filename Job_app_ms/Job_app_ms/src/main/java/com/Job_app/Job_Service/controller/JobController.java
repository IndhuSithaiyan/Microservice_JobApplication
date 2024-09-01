package com.Job_app.Job_Service.controller;

import com.Job_app.Job_Service.model.Job;
import com.Job_app.Job_Service.service.JobService;
import com.Job_app.Job_Service.dto.JobResponseTemplateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/allJobs")
    public ResponseEntity<List<JobResponseTemplateDTO>> getAllJobs(){
        return new ResponseEntity<>(jobService.getAllJob(), HttpStatus.OK);
//        return new ResponseEntity.ok(jobService.getAllJob());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobResponseTemplateDTO> getJobById(@PathVariable Long jobId){
        JobResponseTemplateDTO jobResponseTemplateDTO = jobService.getJobById(jobId);
        if (jobResponseTemplateDTO != null)
            return new ResponseEntity(jobResponseTemplateDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobId){
        boolean deleted = jobService.deleteById(jobId);
        if (deleted)
            return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Long jobId,
                                            @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(jobId, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
