package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import database.Database;
import entity.User;
import exception.DAOException;
import exception.DatabaseException;

public class UserDAO implements DAO<User> {
    private Database database = Database.getInstance();

    @Override
    public void delete(int id) throws DAOException {
        try {
            database.delete(User.class, id);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() throws DAOException {
        try {
            return (List<User>) database.findAll(User.class);
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll(Predicate<User> filter) throws DAOException {
        try {
            return ((List<User>) database.findAll(User.class)).stream().filter(filter).toList();
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll(Comparator<User> comparator) throws DAOException {
        try {
            return ((List<User>) database.findAll(User.class)).stream().sorted(comparator).toList();
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<User> findById(int id) throws DAOException {
        try {
            return (Optional<User>) database.findById(User.class, id);
        } catch (DatabaseException e) {
            e.printStackTrace();

            return null;

        }
    }

    @Override
    public void save(User entity) throws DAOException {
        try {
            database.save(User.class, entity);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, User entity) throws DAOException {
        try {
            database.update(User.class, id, entity);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
