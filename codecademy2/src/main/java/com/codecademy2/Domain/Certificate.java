package com.codecademy2.Domain;

public class Certificate{

private String certificateID;
private int grade;
private String employee;

    public Certificate(String certificateID, int grade, String employee) {
        this.certificateID = certificateID;
        this.grade = grade;
        this.employee = employee;
    }

    public String getCertificateID() {
        return certificateID;
    }
    
}