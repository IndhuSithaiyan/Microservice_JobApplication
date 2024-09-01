package com.Job_app.Job_Service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long companyId;
    private String companyName;
    private String companyDescription;
}
