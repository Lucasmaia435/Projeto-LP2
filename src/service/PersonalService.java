package service;

import dao.UserDAO;
import entity.Athlete;
import entity.Personal;
import entity.User;
import exception.DAOException;

import java.util.List;

import state.AuthState;

public class PersonalService {
    Personal personal = (Personal) AuthState.getInstance().getCurrentUser();
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
}
