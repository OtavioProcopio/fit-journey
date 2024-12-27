package com.fitjourney.back_end.model;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Coach extends User {

    @OneToMany(mappedBy = "coach")
    private List<Athlete> athlete ;

    public void manageDiet(Diet diet, Athlete athlete ){
        

    }

    public void manageWorkout(Workout workoutm, Athlete athlete){
        
    }

}
