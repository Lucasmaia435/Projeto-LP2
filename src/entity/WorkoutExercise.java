package entity;

public class WorkoutExercise extends Entity {
    Exercise exercise;
    int sets;
    int reps;

    public WorkoutExercise(Exercise exercise, int sets, int reps) {
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
    }

}
