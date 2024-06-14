package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entity.Entity;
import exception.DatabaseException;
import exception.EntityNotFoundException;

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
    private ArrayList<T> data;

    private int id = -1;

    DatabaseTable() {
        data = new ArrayList<>();
    }

    private int incrementAndGetID() {
        id = id + 1;
        return id;
    }

    @Override
    public void save(T entity) throws DatabaseException {
        entity.setId(incrementAndGetID());

        data.add(entity);
    }

    @Override
    public Optional<T> findById(int id) throws DatabaseException {
        Optional<T> result = data.stream().filter(t -> t.getId() == id).findFirst();

        if (result.isPresent())
            return result;

        throw new EntityNotFoundException("No entities found in this table!");

    }

    @Override
    public List<T> findAll() throws DatabaseException {
        if (!data.isEmpty())
            return data;

        throw new EntityNotFoundException("No entities found in this table!");
    }

    @Override
    public void update(int id, T entity) throws DatabaseException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                entity.setId(i);
                data.set(i, entity);
                break;
            }
        }

        throw new EntityNotFoundException("No entity with the provided ID was found!");
    }

    @Override
    public void delete(int id) throws DatabaseException {
        boolean result = data.removeIf(t -> t.getId() == id);

        if (result == false) {
            throw new EntityNotFoundException("No entity with the provided ID was found!");
        }
    }

}
