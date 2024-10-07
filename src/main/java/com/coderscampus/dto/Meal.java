package com.coderscampus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meal {

    @JsonProperty("id")
    private String id;

    @JsonProperty("imageType")
    private String imageType;

    @JsonProperty("title")
    private String title;

    @JsonProperty("readyInMinutes")
    private String readyInMinutes;

    @JsonProperty("servings")
    private String servings;

    @JsonProperty("sourceUrl")
    private String sourceUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(String readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

}
