package view;

import java.util.Scanner;

import entity.User;
import exception.DAOException;
import service.AuthService;
import state.AuthState;

public class AuthView implements View {
    AuthState state = AuthState.getInstance();
    AuthService authService = new AuthService();

    @Override
    public void startView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo!");

        System.out.println("\nDigite o seu email:");

        // String email = scanner.next(); TODO: Uncomment at presentation
        String email = "lucas.maiarc435@gmail.com";
        login(email);

        scanner.close();
    }

    private void login(String email) {
        try {
            User user = authService.login(email);

            if (user == null) {
                navigator.push(new ErrorView("Não foi encontrado um usuário com e-mail: " + email));
            }

            navigator.push(new MainView());
        } catch (DAOException e) {
            navigator.push(new ErrorView("Não foi encontrado um usuário com e-mail: " + e));

        }
    }
}
