package service;

import dao.WorkoutSessionDAO;
import entity.WorkoutSession;
import exception.DAOException;

public class WorkoutSessionService {
    WorkoutSessionDAO workoutSessionDAO = new WorkoutSessionDAO();

    public void deleteById(int id) {
        try {
            workoutSessionDAO.delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void save(WorkoutSession workoutSession) {
        try {
            workoutSessionDAO.save(workoutSession);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void update(WorkoutSession workoutSession) {
        try {
            workoutSessionDAO.update(workoutSession.getId(), workoutSession);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
