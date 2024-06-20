package view.auth;

import entity.Athlete;
import entity.User;
import exception.DAOException;
import service.AuthService;
import state.AuthState;
import view.View;
import view.athlete.AthleteView;
import view.error.ErrorView;
import view.home.PersonalHomeView;

public class LoginView implements View {
    AuthState state = AuthState.getInstance();
    AuthService authService = new AuthService();

    @Override
    public void startView() {
        System.out.println("Bem vindo!");

        System.out.println("\nDigite o seu email:");

        String email = scanner.next();

        login(email);
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
}
