package view.home;

import java.util.ArrayList;

import view.View;
import view.athlete.AthleteListView;
import view.athlete.CreateAthleteView;

public class PersonalHomeView implements View {

    ArrayList<Integer> options = new ArrayList<>() {
        {
            add(0);
            add(1);
            add(2);
        }
    };

    @Override
    public void startView() {
        System.out.println("Bem vindo " + state.getCurrentUser().getName() + " \n\n");
        System.out.println("-----------Menu-----------");
        System.out.println("1 - Listar alunos;");
        System.out.println("2 - Cadastrar aluno;");

        System.out.println("\n0 - Sair");

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
                navigator.push(new CreateAthleteView());
                break;

            case 0:
                navigator.pop();
                break;
            default:
                navigator.pop();
                break;
        }
    }
}
