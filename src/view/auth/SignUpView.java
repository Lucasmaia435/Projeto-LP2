package view.auth;

import exception.DAOException;
import service.AuthService;
import view.View;
import view.error.ErrorView;

public class SignUpView implements View {
    AuthService authService = new AuthService();

    @Override
    public void startView() {
        scanner.nextLine();
        System.out.println("=================== Bem vindo ao Cadastro! ===================");
        System.out.println("Para voltar para tela inicial digite '0'.");
        System.out.println("================================================================");
        System.out.println("\n");

        System.out.println("Qual o seu nome?");
        String nome = scanner.nextLine();

        if (nome.equals("0")) {
            navigator.pop();
            return;
        }

        System.out.println("Para finalizar, qual o seu e-mail?");
        String email = scanner.nextLine();

        if (email.equals("0")) {
            navigator.pop();
            return;
        }

        while (!validateEmail(email)) {
            System.out.println("!!! Digite um e-mail válido !!!");

            email = scanner.nextLine();
        }

        try {
            authService.register(nome, email);

            navigator.push(new LoginView());
            return;
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
            return;
        }

    }

    Boolean validateEmail(String email) {
        return email.contains("@");
    }

}
