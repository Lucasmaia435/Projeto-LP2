package view.athlete;

import exception.DAOException;
import service.AuthService;
import state.AuthState;
import view.View;
import view.auth.LoginView;
import view.error.ErrorView;

public class CreateAthleteView implements View {
    AuthService authService = new AuthService();
    AuthState state = AuthState.getInstance();

    @Override
    public void startView() {
        scanner.nextLine();
        System.out.println("Bem vindo!");
        System.out.println("\n\n");
        System.out.println("Qual o nome do/da seu/sua atleta?");
        String nome = scanner.nextLine();

        System.out.println("Para finalizar, qual e-mail do(a) atleta?");
        String email = scanner.nextLine();

        while (!validateEmail(email)) {
            System.out.println("!!! Digite um e-mail válido !!!");

            email = scanner.nextLine();
        }

        try {
            authService.registerAthlete(nome, email, state.getCurrentUser().getId());

            navigator.push(new LoginView());
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
        }

    }

    Boolean validateEmail(String email) {
        return email.contains("@");
    }

}
