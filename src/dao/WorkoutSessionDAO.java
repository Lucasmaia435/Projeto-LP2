package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import database.Database;
import entity.WorkoutSession;
import exception.DAOException;
import exception.DatabaseException;
import exception.EntityNotFoundDAOException;

public class WorkoutSessionDAO implements DAO<WorkoutSession> {
    private Database database = Database.getInstance();

    @Override
    public void delete(int id) throws DAOException {
        try {
            database.delete(WorkoutSession.class, id);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WorkoutSession> findAll() throws DAOException {
        try {
            return (List<WorkoutSession>) database.findAll(WorkoutSession.class);
        } catch (DatabaseException e) {
            throw new EntityNotFoundDAOException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WorkoutSession> findAll(Predicate<WorkoutSession> filter) throws DAOException {
        try {
            return ((List<WorkoutSession>) database.findAll(WorkoutSession.class)).stream().filter(filter).toList();
        } catch (DatabaseException e) {
            throw new EntityNotFoundDAOException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WorkoutSession> findAll(Comparator<WorkoutSession> comparator) throws DAOException {
        try {
            return ((List<WorkoutSession>) database.findAll(WorkoutSession.class)).stream().sorted(comparator).toList();
        } catch (DatabaseException e) {
            throw new EntityNotFoundDAOException(e.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<WorkoutSession> findById(int id) throws DAOException {
        try {
            return (Optional<WorkoutSession>) database.findById(WorkoutSession.class, id);
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;

        }
    }

    @Override
    public void save(WorkoutSession entity) throws DAOException {
        try {
            database.save(WorkoutSession.class, entity);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, WorkoutSession entity) throws DAOException {
        try {
            database.update(WorkoutSession.class, id, entity);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
