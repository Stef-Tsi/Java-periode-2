package com.codecademy2.Domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private String email, name, gender, adress, city, country;
    private String birthDate;
    // private ArrayList<Enrollment> enrollments;

    public Student(String email, String name,String birthDate, String gender, String adress, String country, String city) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.adress = adress;
        this.country = country;
        this.city = city;
        // this.enrollments = enrollments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
