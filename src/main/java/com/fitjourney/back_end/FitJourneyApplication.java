package com.fitjourney.back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fitjourney.back_end.model.Exercise;
import com.fitjourney.back_end.model.Workout;

@SpringBootApplication
public class FitJourneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitJourneyApplication.class, args);

		Workout workout = new Workout();
        workout.setNome("Treino de Peito");

        
        Exercise exercise1 = new Exercise();
        exercise1.setName("Supino reto");
        exercise1.setRepetitions(4);
        exercise1.setLoad(60);

        Exercise exercise2 = new Exercise();
        exercise2.setName("Supino inclinado");
        exercise2.setRepetitions(4);
        exercise2.setLoad(50);

        // Adicionando exercícios ao treino
        workout.addExercise(exercise1);
        workout.addExercise(exercise2);

        
        System.out.println("Treino: " + workout.getNome());
        for (Exercise ex : workout.getExercises()) {
            System.out.println("Exercício: " + ex.getName() + " | Repetições: " + ex.getRepetitions() + " | Carga: " + ex.getLoad());
        }

        
        workout.removeExercise(exercise1);

        
        System.out.println("Exercícios após remoção:");
        for (Exercise ex : workout.getExercises()) {
            System.out.println("Exercício: " + ex.getName() + " | Repetições: " + ex.getRepetitions() + " | Carga: " + ex.getLoad());
        }

	}

}
