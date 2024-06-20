package entity;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSession extends Entity {
    List<WorkoutExercise> exercises;

    int athleteId;

    String name;

    public WorkoutSession(String name, int athleteId) {
        this.exercises = new ArrayList<>();
        this.name = name;
        this.athleteId = athleteId;
    }

    public WorkoutSession(String name, int athleteId, List<WorkoutExercise> exercises) {
        this.exercises = exercises;
        this.name = name;
        this.athleteId = athleteId;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public String getName() {
        return name;
    }

    public List<WorkoutExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<WorkoutExercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(WorkoutExercise exercise) {
        this.exercises.add(exercise);
    }
}
