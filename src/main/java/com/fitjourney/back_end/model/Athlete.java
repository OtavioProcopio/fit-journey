package com.fitjourney.back_end.model;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Athlete extends User{
    
    @OneToMany
    private List<Diet> diets;

    @OneToMany
    private List<Workout> workouts;

    @OneToMany
    private List<Metric> metrics;

    void provideMetrics(Metric metric){
        this.metrics.add(metric);
    }


}
