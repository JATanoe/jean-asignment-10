package com.coderscampus.config;

import com.coderscampus.service.MealPlannerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MealPlannerConfiguration {

    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String UrlEndpoint;

//    @Bean
//    public MealPlannerService mealPlanService() {
//        return new MealPlannerService(baseUrl + UrlEndpoint);
//    }

}
