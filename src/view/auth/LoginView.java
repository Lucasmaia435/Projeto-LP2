package view.auth;

import entity.Athlete;
import entity.User;
import exception.DAOException;
import service.AuthService;
import view.View;
import view.athlete.AthleteView;
import view.error.ErrorView;
import view.home.PersonalHomeView;

public class LoginView implements View {
    AuthService authService = new AuthService();

    @Override
    public void startView() {
        scanner.nextLine();
        System.out.println("Bem vindo!");
        System.out.println("Para voltar para tela inicial digite 0");

        System.out.print("\nDigite o seu email: ");

        String email = scanner.nextLine();

        if (email.equals("0")) {
            navigator.pop();
            return;
        }

        while (!validateEmail(email)) {
            System.out.println("!!! Digite um e-mail válido !!!");

            email = scanner.nextLine();
        }

        login(email);
        return;
    }

    private void login(String email) {
        try {
            User user = authService.login(email);

            if (user == null) {
                navigator.push(new ErrorView("Não foi encontrado um usuário com e-mail: " + email));

            }
            if (state.isPersonal()) {
                navigator.push(new PersonalHomeView());
            } else {
                navigator.push(new AthleteView((Athlete) state.getCurrentUser()));
            }

        } catch (DAOException e) {
            navigator.push(new ErrorView("Não foi encontrado um usuário com e-mail: " + e));

        }
    }

    Boolean validateEmail(String email) {
        return email.contains("@");
    }
}
