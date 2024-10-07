package com.coderscampus.config;

import com.coderscampus.service.MealPlannerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MealPlannerConfiguration {

    @Value("${spoonacular.apiKey}")
    private String apiKey;

    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String urlEndpoint;

    @Bean
    public String apiKey() { return apiKey; }

    @Bean
    public String url() { return baseUrl + urlEndpoint; }

}
