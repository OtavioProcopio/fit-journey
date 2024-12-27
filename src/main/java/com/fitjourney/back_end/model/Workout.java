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
public class Workout {
   
    private String nome;

    private String description;

    private List<Exercise> exercises = new ArrayList<>(); 

    private LocalDateTime createdAt;


    
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }
    
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }
}
