package com.csab.daggermvpstarter.mvp.model;

import java.util.Date;

public class Note {

    private String contents;
    private Date createdDate;

    public Note(String contents) {
        this.contents = contents;
        this.createdDate = new Date();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
