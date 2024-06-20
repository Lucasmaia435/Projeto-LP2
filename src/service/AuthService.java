package service;

import java.util.List;

import dao.UserDAO;
import entity.Athlete;
import entity.Personal;
import entity.User;
import exception.DAOException;
import exception.EntityAlreadyCreatedException;
import state.AuthState;

public class AuthService {
    UserDAO userDAO = new UserDAO();
    AuthState state = AuthState.getInstance();

    public void register(String name, String email) throws DAOException {
        try {
            List<User> users = userDAO.findAll(user -> user.getEmail().equals(email));

            if (users == null || users.isEmpty()) {
                userDAO.save(new Personal(name, email));

                return;
            }

            throw new EntityAlreadyCreatedException("O e-mail " + email + " já foi usado!");
        } catch (DAOException e) {
            throw e;
        }
    }

    public void registerAthlete(String name, String email, int personalId) throws DAOException {
        try {
            List<User> users = userDAO.findAll(user -> user.getEmail().equals(email));

            if (users.isEmpty()) {
                userDAO.save(new Athlete(name, email, personalId));

                return;
            }

            throw new EntityAlreadyCreatedException("O e-mail " + email + " já foi usado!");
        } catch (DAOException e) {
            throw e;
        }
    }

    public User login(String email) throws DAOException {
        try {
            List<User> users = userDAO.findAll(user -> user.getEmail().equals(email));

            User currentUser = users.getFirst();

            if (currentUser != null) {
                state.setCurrentUser(currentUser);
            }

            return currentUser;
        } catch (DAOException e) {
            throw e;
        }
    }

    public void logout() {
        state.setCurrentUser(null);
    }
}
