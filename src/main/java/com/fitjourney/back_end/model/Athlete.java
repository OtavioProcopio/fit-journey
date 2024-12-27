package com.fitjourney.back_end.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Athlete extends User{
    
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    private List<Diet> diets = new ArrayList<>();

    
    private List<Workout> workouts = new ArrayList<>();

    
    private List<Metric> metrics = new ArrayList<>();

    void provideMetrics(Metric metric){
        this.metrics.add(metric);
    }


}
