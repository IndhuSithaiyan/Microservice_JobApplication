package com.Company_Service.model;

import com.Job_Service.model.Job;
import com.Review_Service.model.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "companyId")
    private Long id;
    private String companyName;
    private String companyDescription;

    //meaning - this particular relationship is exist in JOB is mappedby a field company which is exist in Job
    @JsonIgnore //remove the recursive callback
    @OneToMany(mappedBy = "company")      //one company has many jobs
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")      //one company has many jobs
    private List<Review> reviews;

}
