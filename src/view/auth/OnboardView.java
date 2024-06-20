package view.auth;

import view.View;

public class OnboardView implements View {

    @Override
    public void startView() {
        System.out.println("=================== Bem vindo ao FitManager! ===================");

        System.out.println("\nJá possui uma conta? digite '1'.");
        System.out.println("É personal e quer criar uma conta? digite '2'.");

        System.out.println("\nDeseja finalizar o app? digite '0'.");
        System.out.println("================================================================");
        while (true) {
            int option = scanner.nextInt();

            if (option == 1) {
                navigator.push(new LoginView());
                return;
            }

            if (option == 2) {
                navigator.push(new SignUpView());
                return;
            }

            if (option == 0) {
                break;
            }
        }
    }

}
