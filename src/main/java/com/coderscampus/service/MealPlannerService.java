package com.coderscampus.service;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class MealPlannerService {

    @Value("${spoonacular.apiKey}")
    private String apiKey;

    private final RestTemplate rt = new RestTemplate();

    private final String url;

    public MealPlannerService(String url) {
        this.url = url;
    }

    public ResponseEntity<WeekResponse> fetchWeekMeals(String numCalories, String diet, String exclusions) {
        URI uri = buildURI("week", numCalories, diet, exclusions);
        return rt.getForEntity(uri, WeekResponse.class);
    }

    public ResponseEntity<DayResponse> fetchDayMeals(String numCalories, String diet, String exclusions) {
        URI uri = buildURI("day", numCalories, diet, exclusions);
        return rt.getForEntity(uri, DayResponse.class);
    }

    public URI buildURI(String timeFrame, String numCalories, String diet, String exclusions) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apiKey", apiKey)
                .queryParam("timeFrame", timeFrame)
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build().toUri();
    }

}
