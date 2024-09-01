package com.Review_Service.model;

import com.Company_Service.model.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String reviewTitle;
    private String reviewDescription;
    private Double reviewRating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}
