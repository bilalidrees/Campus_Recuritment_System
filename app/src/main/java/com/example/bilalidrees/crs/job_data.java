package com.example.bilalidrees.crs;

public class job_data  {

    public String req_company_name;
    public String req_job_title;
    public String req_qualification;
    public String req_skills;
    public String req_Experience;
    public String req_salary;
    public String req_location;


    public job_data() {
    }


    public job_data(String req_company_name, String req_job_title, String req_qualification, String req_skills, String req_Experience, String req_salary, String req_location) {
        this.req_company_name = req_company_name;
        this.req_job_title = req_job_title;
        this.req_qualification = req_qualification;
        this.req_skills = req_skills;
        this.req_Experience = req_Experience;
        this.req_salary = req_salary;
        this.req_location = req_location;
    }

    public String getReq_company_name() {
        return req_company_name;
    }

    public String getReq_job_title() {
        return req_job_title;
    }

    public String getReq_qualification() {
        return req_qualification;
    }

    public String getReq_skills() {
        return req_skills;
    }

    public String getReq_Experience() {
        return req_Experience;
    }

    public String getReq_salary() {
        return req_salary;
    }

    public String getReq_location() {
        return req_location;
    }
}
