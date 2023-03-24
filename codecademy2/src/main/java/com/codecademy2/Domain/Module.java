package com.codecademy2.Domain;

import java.time.LocalDate;

public class Module extends Content{
    private int moduleVersion, followNumber;
    private String contactName, contactEmail;

    public Module(int contentItemId, String contentTitle, String contentDesc, LocalDate publicationDate, Status status, int moduleVersion, int followNumber, String contactName, String contactEmail) {
        super(contentItemId, contentTitle, contentDesc, publicationDate, status);
        this.moduleVersion = moduleVersion;
        this.followNumber = followNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    
}
