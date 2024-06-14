package view;

import java.util.Scanner;

public class ErrorView implements View {
    String errorMessage;

    public ErrorView(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void startView() {
        Scanner scanner = new Scanner(System.in);

        System.err.println("-------- Tela de Erro --------");
        System.err.println("\n");
        System.out.println("erro: " + errorMessage);
        System.out.println("Digite 1 para voltar");
        while (scanner.nextInt() != 1) {
            System.out.println("Digite 1 para voltar");
        }

        scanner.close();
        navigator.pop();
    }

}
