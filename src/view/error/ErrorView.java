package view.error;

import view.View;

public class ErrorView implements View {
    String errorMessage;

    public ErrorView(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void startView() {
        System.err.println("-------- Tela de Erro --------");
        System.err.println("\n");
        System.out.println("erro: " + errorMessage);
        System.err.println("\n");
        System.out.println("Digite 0 para voltar.");

        while (scanner.nextInt() != 0) {
            System.out.println("Digite 0 para voltar.");
        }

        navigator.pop();
        return;
    }

}
