package com.codecademy2.Domain;

public class Webcast {
    private String titel, description, hostName, organisationName, url;

    public Webcast(String titel, String description, String hostName, String organisationName, String url) {
        this.titel = titel;
        this.description = description;
        this.hostName = hostName;
        this.organisationName = organisationName;
        this.url = url;
    }
}
