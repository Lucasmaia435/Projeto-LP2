package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import database.Database;
import entity.Exercise;
import exception.DAOException;
import exception.DatabaseException;

//TODO: Mostrar unchecked para o professor

public class ExerciseDAO implements DAO<Exercise> {
    private Database database = Database.getInstance();

    @Override
    public void delete(int id) throws DAOException {
        try {
            database.delete(Exercise.class, id);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Exercise> findAll() throws DAOException {
        try {
            return (List<Exercise>) database.findAll(Exercise.class);
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Exercise> findAll(Predicate<Exercise> filter) throws DAOException {
        try {
            return ((List<Exercise>) database.findAll(Exercise.class)).stream().filter(filter).toList();
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Exercise> findAll(Comparator<Exercise> comparator) throws DAOException {
        try {
            return ((List<Exercise>) database.findAll(Exercise.class)).stream().sorted(comparator).toList();
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Exercise> findById(int id) throws DAOException {
        try {
            return (Optional<Exercise>) database.findById(Exercise.class, id);
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;

        }
    }

    @Override
    public void save(Exercise entity) throws DAOException {
        try {
            database.save(Exercise.class, entity);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, Exercise entity) throws DAOException {
        try {
            database.update(Exercise.class, id, entity);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
