package com.codecademy2.Domain;

import java.time.LocalDate;

public class Content {
    protected int contentItemId;
    protected String contentTitle, contentDesc;
    protected LocalDate publicationDate;
    protected Status status;
    
    public Content(int contentItemId, String contentTitle, String contentDesc, LocalDate publicationDate, Status status) {
        this.contentItemId = contentItemId;
        this.contentTitle = contentTitle;
        this.contentDesc = contentDesc;
        this.publicationDate = publicationDate;
        this.status = status;
    }
    
}
