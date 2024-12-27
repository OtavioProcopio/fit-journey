package com.fitjourney.back_end.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
    
    private double weight;
    private double height;
    private double bodyFatPercentage;
    private LocalDateTime recordedAt;

}
