package com.coderscampus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class WeekResponse {

    @JsonProperty("week")
    private Map<String, DayResponse> week;

    public Map<String, DayResponse> getWeek() {
        return week;
    }

    public void setWeek(Map<String, DayResponse> week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "WeekResponse [ week=" + week + " ]";
    }
}
