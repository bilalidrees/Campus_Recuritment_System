package com.example.bilalidrees.crs;

public class Student_Data {

    public String student_name;
    public String student_fathername;
    public String student_qualification;
    public String student_email;
    public String student_skill;

    public Student_Data() {
    }

    public Student_Data( String student_name, String student_fathername, String student_qualification, String student_email, String student_skill) {
        this.student_name = student_name;
        this.student_fathername = student_fathername;
        this.student_qualification = student_qualification;
        this.student_email = student_email;
        this.student_skill = student_skill;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_fathername() {
        return student_fathername;
    }

    public String getStudent_qualification() {
        return student_qualification;
    }

    public String getStudent_email() {
        return student_email;
    }

    public String getStudent_skill() {
        return student_skill;
    }
}
