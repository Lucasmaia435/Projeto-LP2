package entity;

import java.util.List;

public class WorkoutSession extends Entity {
    List<WorkoutExercise> exercises;
    String name;

    public WorkoutSession(List<WorkoutExercise> exercises, String name) {
        this.exercises = exercises;
        this.name = name;
    }
}
