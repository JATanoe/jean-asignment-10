package com.coderscampus.service;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class MealPlannerService {

    private final String apiKey;
    private final String url;

    private final RestTemplate rt = new RestTemplate();

    public MealPlannerService(String apiKey, String url) {
        this.apiKey = apiKey;
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
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apiKey", apiKey)
                .queryParam("timeFrame", timeFrame)
                // Refactored solution
                .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                .queryParamIfPresent("targetDiet", Optional.ofNullable(diet))
                .queryParamIfPresent("targetExclusions", Optional.ofNullable(exclusions));
        // Initial solution
//        if (numCalories != null && !numCalories.isEmpty()) {uri.queryParam("targetCalories", numCalories);}
//        if (diet != null && !diet.isEmpty()) {uri.queryParam("diet", diet);}
//        if (exclusions != null && !exclusions.isEmpty()) {uri.queryParam("exclude", exclusions);}
//        System.out.println("Generated url: " + uri.toUriString());

        return uri.build().toUri();
    }

}
