package com.codecademy2;

import java.time.LocalDate;

public class Content {
    protected int contentItemId;
    protected String contentTitle, contentDesc;
    protected LocalDate publicationDate;
    
    public Content(int contentItemId, String contentTitle, String contentDesc, LocalDate publicationDate) {
        this.contentItemId = contentItemId;
        this.contentTitle = contentTitle;
        this.contentDesc = contentDesc;
        this.publicationDate = publicationDate;
    }
    
}
