package com.codecademy2.Domain;

import java.time.LocalDate;

public class Webcast extends Content{
    private String titel, description, hostName, organisationName, url;

    public Webcast(int contentItemId, String contentTitle, String contentDesc, LocalDate publicationDate, Status status, String titel, String description, String hostName, String organisationName, String url) {
        super(contentItemId, contentTitle, contentDesc, publicationDate, status);
        this.titel = titel;
        this.description = description;
        this.hostName = hostName;
        this.organisationName = organisationName;
        this.url = url;
    }
}
