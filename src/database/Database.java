package database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import entity.Entity;
import exception.DatabaseException;

public class Database {
    private static Database instance;

    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables;

    private Database() {
        tables = new HashMap<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    private <T extends Entity> void checkTableExistence(Class<T> clazz) {
        if (!tables.containsKey(clazz)) {
            tables.put(clazz, new DatabaseTable<>());
        }
    }

    public <T extends Entity> void save(Class<T> clazz, T entity) throws DatabaseException {
        checkTableExistence(clazz);

        @SuppressWarnings("unchecked")
        DatabaseTableI<T> table = (DatabaseTableI<T>) tables.get(clazz);

        table.save(entity);

        return;
    }

    public <T extends Entity> Optional<? extends Entity> findById(Class<T> clazz, int id) throws DatabaseException {
        checkTableExistence(clazz);

        return tables.get(clazz).findById(id);
    }

    public <T extends Entity> List<? extends Entity> findAll(Class<T> clazz) throws DatabaseException {
        checkTableExistence(clazz);

        return tables.get(clazz).findAll();
    }

    public <T extends Entity> void update(Class<T> clazz, int id, T entity)
            throws DatabaseException {
        checkTableExistence(clazz);

        @SuppressWarnings("unchecked")
        DatabaseTableI<T> table = (DatabaseTableI<T>) tables.get(clazz);

        table.update(id, entity);
    }

    public <T extends Entity> void delete(Class<T> clazz, int id) throws DatabaseException {
        checkTableExistence(clazz);

        tables.get(clazz).delete(id);
    }
}
