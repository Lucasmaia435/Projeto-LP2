package service;

import java.util.List;

import dao.UserDAO;
import entity.Personal;
import entity.User;
import exception.DAOException;
import state.AuthState;

public class AuthService {
    UserDAO userDAO = new UserDAO();
    AuthState state = AuthState.getInstance();

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
