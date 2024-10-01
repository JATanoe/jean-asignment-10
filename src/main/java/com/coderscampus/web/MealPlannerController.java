package com.coderscampus.web;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;
import com.coderscampus.service.MealPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MealPlannerController {

    private final RestTemplate rt = new RestTemplate();

    @Autowired
    private MealPlannerService mealPlannerService;

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return mealPlannerService.fetchWeekMeals(numCalories, diet, exclusions);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        return mealPlannerService.fetchDayMeals(numCalories, diet, exclusions);
    }

}
