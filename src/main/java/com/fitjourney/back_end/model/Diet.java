package com.fitjourney.back_end.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Diet {

    private String description;

    private DietType dietType;

    private LocalDateTime createdAt = LocalDateTime.now();
    
    private List<Meal> meals = new ArrayList<>(); ;

    public void addMeal(Meal meal){
        meals.add(meal);

    }

}
