package service;

import dao.UserDAO;
import entity.Athlete;
import entity.Personal;
import entity.User;
import exception.DAOException;

import java.util.List;
import java.util.Optional;

import state.AuthState;

public class PersonalService {
    User personal = AuthState.getInstance().getCurrentUser();
    UserDAO userDAO = new UserDAO();

    public List<User> getAthletes() throws DAOException {
        try {
            List<User> athletes = userDAO.findAll(
                    user -> user.getClass() == Athlete.class && ((Athlete) user).getPersonalId() == personal.getId());

            return athletes;
        } catch (DAOException e) {
            throw e;
        }
    }

    public User getAthleteById(int id) throws DAOException {
        try {
            Optional<User> athlete = userDAO.findById(id);

            if (athlete.isPresent()) {
                return athlete.get();
            }

            return null;
        } catch (DAOException e) {
            throw e;
        }
    }

    public void deleteAthlete(int id) {
        try {
            userDAO.delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
