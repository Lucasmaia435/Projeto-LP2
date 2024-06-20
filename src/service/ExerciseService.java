package service;

import java.util.List;
import java.util.Optional;

import dao.ExerciseDAO;
import entity.Exercise;
import exception.DAOException;

public class ExerciseService {
    ExerciseDAO exerciseDAO = new ExerciseDAO();

    public List<Exercise> getExercises() {
        try {
            return exerciseDAO.findAll();
        } catch (DAOException e) {
            return List.of();
        }
    }

    public Exercise getExerciseById(int id) {
        try {
            Optional<Exercise> exercise = exerciseDAO.findById(id);

            if (exercise.isPresent()) {
                return exercise.get();
            }
            return null;
        } catch (DAOException e) {
            return null;
        }
    }
}
