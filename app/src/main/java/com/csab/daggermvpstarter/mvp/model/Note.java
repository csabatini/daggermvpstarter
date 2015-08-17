package com.csab.daggermvpstarter.mvp.model;

import java.util.Date;

// TODO implement joda time to format/standardize dates
public class Note {

    private String contents;
    private Date createdDate;

    public Note(String contents) {
        this.contents = contents;
        this.createdDate = new Date();
    }

    public Note(String contents, Date createdDate) {
        this.contents = contents;
        this.createdDate = createdDate;
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
