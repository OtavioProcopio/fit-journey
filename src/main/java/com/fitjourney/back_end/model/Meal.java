package com.fitjourney.back_end.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    private String name;

    private List<Nutrient> nutrients;

    public Double calcCalorias(Nutrient nutrient){
        double calorias = 0.0;
        switch(nutrient.getNutrientType()){
            case PROTEIN:
                calorias = nutrient.getAmount()*4; // cada g de proteina tem 4 calorias 
                break;

            case CARBS:
                calorias = nutrient.getAmount()*4; // cada g de carboidrato tem 4 calorias
                break;
            
            case FATS:
                calorias = nutrient.getAmount()*9; // cada g de gordura tem 9 calorias
                break;
            default:
                throw new IllegalArgumentException("Tipo de nutriente desconhecido: " + nutrient.getNutrientType());
        }
        return calorias;
    }

    public Double calcTotalCalories() {
        double totalCalories = 0.0;
    
        for (Nutrient nutrient : nutrients) {
            double calories = calcCalorias(nutrient); 
            totalCalories += calories; 
        }
    
        return totalCalories;
    }

}
