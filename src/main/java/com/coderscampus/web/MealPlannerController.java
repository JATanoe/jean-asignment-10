package com.coderscampus.web;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;
import com.coderscampus.service.MealPlannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlannerController {

    private final MealPlannerService mealPlannerService;

    public MealPlannerController(MealPlannerService mealPlannerService) {
        this.mealPlannerService = mealPlannerService;
    }

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return mealPlannerService.fetchWeekMeals(numCalories, diet, exclusions);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return mealPlannerService.fetchDayMeals(numCalories, diet, exclusions);
    }

}
