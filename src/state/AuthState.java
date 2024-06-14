package state;

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

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
