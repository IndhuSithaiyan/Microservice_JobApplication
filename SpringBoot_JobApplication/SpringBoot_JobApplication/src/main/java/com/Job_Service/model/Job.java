package com.Job_Service.model;

import com.Company_Service.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobName;
    private String jobDesignation;
    private Long jobSalary;
    private String jobLocation;

    @ManyToOne  //many jos linked to one company
    private Company company;
}
