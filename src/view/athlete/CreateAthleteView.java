package view.athlete;

import exception.DAOException;
import service.AuthService;
import view.View;
import view.error.ErrorView;

public class CreateAthleteView implements View {
    AuthService authService = new AuthService();

    @Override
    public void startView() {
        scanner.nextLine();
        System.out.println("Cadastro de atleta");
        System.out.println("\n");
        System.out.print("Qual o nome do/da seu/sua atleta? ");
        String nome = scanner.nextLine();

        System.out.print("Para finalizar, qual e-mail do(a) atleta? ");
        String email = scanner.nextLine();

        while (!validateEmail(email)) {
            System.out.println("!!! Digite um e-mail válido !!!");

            email = scanner.nextLine();
        }

        try {
            authService.registerAthlete(nome, email, state.getCurrentUser().getId());

            navigator.pop();
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
        }

    }

    Boolean validateEmail(String email) {
        return email.contains("@");
    }

}
