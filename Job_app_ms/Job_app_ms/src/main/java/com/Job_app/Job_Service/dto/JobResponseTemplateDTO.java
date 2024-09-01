package com.Job_app.Job_Service.dto;

import com.Job_app.Job_Service.model.Job;
import com.Job_app.Job_Service.vo.Company;
import com.Job_app.Job_Service.vo.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobResponseTemplateDTO {

    private Long jobId;
    private String jobName;
    private String jobDesignation;
    private Long jobSalary;
    private String jobLocation;
    private Company company;
    private List<Review> reviews;
}
