package service;

import java.util.List;
import java.util.Optional;

import dao.WorkoutSessionDAO;
import entity.WorkoutSession;
import exception.DAOException;
import exception.EntityNotFoundDAOException;

public class AthleteService {
    WorkoutSessionDAO workoutSessionDAO = new WorkoutSessionDAO();

    public List<WorkoutSession> getWorkouts(int athleteId) throws DAOException {

        try {
            List<WorkoutSession> workoutSessions = workoutSessionDAO
                    .findAll(session -> session.getAthleteId() == athleteId);

            return workoutSessions;
        } catch (EntityNotFoundDAOException e) {
            return List.of();
        } catch (DAOException e) {
            throw e;
        }
    }

    public WorkoutSession getWorkoutById(int id) throws DAOException {

        try {
            Optional<WorkoutSession> workoutSession = workoutSessionDAO
                    .findById(id);

            if (workoutSession.isPresent()) {
                return workoutSession.get();
            }

            return null;
        } catch (DAOException e) {
            throw e;
        }
    }
}
