package com.csab.daggermvpstarter.mvp.model;

public class Note {

    private Integer _id;
    private String contents;
    private String createdDate;

    public Note(String contents, String createdDate) {
        this.contents = contents;
        this.createdDate = createdDate;
    }

    public Note(Integer _id, String contents, String createdDate) {
        this._id = _id;
        this.contents = contents;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
