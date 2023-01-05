package com.codecademy2.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Enrollment {
    private int progress;
    private Student student;
    private Course course;
    private LocalDateTime datetime;
    private ArrayList<Certificate> certificates;

    public Enrollment(Student student, Course course, LocalDateTime datetime) {
        this.student = student;
        this.course = course;
        this.datetime = LocalDateTime.now();
        this.certificates = new ArrayList<Certificate>();
    }
    public void addCertificate(Certificate certificate) {
        this.certificates.add(certificate);
    }

}
