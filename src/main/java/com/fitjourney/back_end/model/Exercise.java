package com.fitjourney.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    private String name;
    private int repetitions;
    private double load;
    private String observacao;
    
}
