package view;

import java.util.Scanner;

import state.AuthState;

public interface View {
    AuthState state = AuthState.getInstance();

    Navigator navigator = Navigator.getInstance();

    Scanner scanner = new Scanner(System.in);

    void startView();
}
