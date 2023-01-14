package com.codecademy2.Domain;

public class Webcast {
    private int duration;
    private String hostName, organisationName, url;

    public Webcast(int duration, String hostName, String organisationName, String url) {
        this.duration = duration;
        this.hostName = hostName;
        this.organisationName = organisationName;
        this.url = url;
    }
    
}
