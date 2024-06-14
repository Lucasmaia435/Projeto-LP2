package view;

import java.util.ArrayList;

import state.AuthState;

public class MainView implements View {
    AuthState state = AuthState.getInstance();

    ArrayList<Integer> options = new ArrayList<>() {
        {
            add(0);
            add(1);
            add(2);
            add(3);
        }
    };

    @Override
    public void startView() {
        System.out.println("\n\nBem vindo " + state.getCurrentUser().getName() + " \n\n");

        System.out.println("1 - Listar alunos");
        System.out.println("2 - Cadastrar aluno");
        System.out.println("3 - Cadastrar aluno");

        System.out.println("\n\n0 - Sair");

        int option = scanner.nextInt();

        while (!options.contains(option)) {
            System.out.println("Digite uma opção válida.");

            option = scanner.nextInt();
        }

        switch (option) {
            case 1:
                navigator.push(new AthleteListView());
                break;
            case 2:
                navigator.push(null);
                break;
            case 3:
                navigator.push(null);
                break;

            default:
                navigator.pop();
                break;
        }
    }
}
