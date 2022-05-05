package com.codegym.model;

public class Upload {
    private String theSong;
    private String singer;
    private String category;
    private String link;

    public Upload() {
    }

    public Upload(String theSong, String singer, String category, String link) {
        this.theSong = theSong;
        this.singer = singer;
        this.category = category;
        this.link = link;
    }

    public String getTheSong() {
        return theSong;
    }

    public void setTheSong(String theSong) {
        this.theSong = theSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
