package entity;

import java.util.List;

public class Workout extends Entity {
    String name;
    List<WorkoutSession> sessions;
    int athleteId;

    public Workout(String name, List<WorkoutSession> sessions, int athleteId) {
        this.name = name;
        this.sessions = sessions;
        this.athleteId = athleteId;
    }
}
