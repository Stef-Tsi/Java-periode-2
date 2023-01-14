package com.codecademy2.Domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private String email, name, gender, adress, city, country;
    private LocalDate birthDate;
    private ArrayList<Enrollment> enrollments;

    public Student(String email, String name, String gender, String adress, String city, String country,
            LocalDate birthDate, ArrayList<Enrollment> enrollments) 
    
    {
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.birthDate = birthDate;
        this.enrollments = enrollments;
    }

    

}
