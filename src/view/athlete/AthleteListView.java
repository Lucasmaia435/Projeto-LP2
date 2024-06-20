package view.athlete;

import java.util.ArrayList;

import entity.Athlete;
import entity.User;
import java.util.List;
import exception.DAOException;
import service.PersonalService;
import view.View;
import view.error.ErrorView;

public class AthleteListView implements View {
    PersonalService personalService = new PersonalService();

    List<User> athletes = new ArrayList<>();

    List<Integer> validIds = new ArrayList<>();

    @Override
    public void startView() {
        getAthletes();

        System.out.println("\n\nTodos os atletas vinculados a você: \n\n");

        for (User athlete : athletes) {
            System.out.println("[" + athlete.getId() + "] - " + athlete.getName() + " - " + athlete.getEmail());
            validIds.add(athlete.getId());
        }

        if (athletes.isEmpty()) {
            System.out.println("Registre algum atleta para ele aparecer nessa listagem!");
        }

        System.out.println("\n\n-----------Menu-----------");
        System.out.println("Digite o ID de um atleta para acessar a sua tela de detalhes");

        System.out.println("Digite 0 para voltar para a tela anterior");

        while (true) {
            int option = scanner.nextInt();

            if (validIds.contains(option)) {
                viewAthleteById(option);
            }

            if (option == 0) {
                navigator.pop();
            }

        }
    }

    private void getAthletes() {
        try {
            athletes = personalService.getAthletes();
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
        }
    }

    private void viewAthleteById(int id) {
        try {
            Athlete athlete = (Athlete) personalService.getAthleteById(id);

            navigator.push(new AthleteView(athlete));
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
        }
    }

}
