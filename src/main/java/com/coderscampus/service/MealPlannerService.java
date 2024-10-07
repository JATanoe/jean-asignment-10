package com.coderscampus.service;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MealPlannerService {

    @Value("${spoonacular.apiKey}")
    private String apiKey;

    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String UrlEndpoint;

    private final RestTemplate rt = new RestTemplate();

    public ResponseEntity<WeekResponse> fetchWeekMeals(String numCalories, String diet, String exclusions) {
        URI uri = buildURI("week", numCalories, diet, exclusions);
        return rt.getForEntity(uri, WeekResponse.class);
    }

    public ResponseEntity<DayResponse> fetchDayMeals(String numCalories, String diet, String exclusions) {
        URI uri = buildURI("day", numCalories, diet, exclusions);
        return rt.getForEntity(uri, DayResponse.class);
    }

    public URI buildURI(String timeFrame, String numCalories, String diet, String exclusions) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(baseUrl + UrlEndpoint)
                .queryParam("apiKey", apiKey)
                .queryParam("timeFrame", timeFrame);

        if (numCalories != null && !numCalories.isEmpty()) {
            uri.queryParam("targetCalories", numCalories);
        }
        if (diet != null && !diet.isEmpty()) {
            uri.queryParam("diet", diet);
        }
        if (exclusions != null && !exclusions.isEmpty()) {
            uri.queryParam("exclude", exclusions);
        }
        System.out.println(uri);
        return uri.build().toUri();
    }

}
