package state;

import entity.Personal;
import entity.User;

public class AuthState {
    private static AuthState instance;

    public static AuthState getInstance() {
        if (instance == null) {
            instance = new AuthState();
        }
        return instance;
    }

    private User currentUser;

    public Boolean isPersonal() {
        if (currentUser != null) {
            return currentUser.getClass() == Personal.class;
        }

        return false;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
