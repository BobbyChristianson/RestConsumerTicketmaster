package com.springstuff.TicketmasterAssessment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist extends Object{

    String name;
    int id;
    String imgSrc;
    String url;
    int rank;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getUrl() {
        return url;
    }

    public int getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "\"Artist\":{" +
                "\n \"name\":\"" + name + "\"," +
                "\n \"rank\":" + rank + "\"," +
                "\n \"imgSrc\":\"" + imgSrc + "\"," +
                "\n \"url\":\"" + url + "\n}";
    }
}
