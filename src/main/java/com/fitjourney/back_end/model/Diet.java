package com.fitjourney.back_end.model;

import java.time.LocalDateTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Diet {
    
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING) 
    private DietType dietType;

    private LocalDateTime createdAt;

    public void addMeal(){

    }

}
