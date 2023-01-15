package com.codecademy2;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Enrollment {
    private LocalDateTime enrollmentDateTime;
    private String studentEmail;
    private String courseName;
    private int progress;
    private ArrayList<Certificate> certificates;

    public Enrollment(String studentEmail, String courseName, LocalDateTime date) {
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.enrollmentDateTime = date;
        this.progress = 0;
    }

    public void addCertificate(Certificate certificate) {
        this.certificates.add(certificate);
    }

    public LocalDateTime getEnrollmentDateTime() {
        return enrollmentDateTime;
    }

    public void setEnrollmentDateTime(LocalDateTime enrollmentDateTime) {
        this.enrollmentDateTime = enrollmentDateTime;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public ArrayList<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<Certificate> certificates) {
        this.certificates = certificates;
    }

    
}
