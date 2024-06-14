package view;

import java.util.ArrayList;

import entity.User;
import java.util.List;
import exception.DAOException;
import service.PersonalService;

public class AthleteListView implements View {
    PersonalService personalService = new PersonalService();

    List<User> athletes = new ArrayList<>();

    @Override
    public void startView() {
        getAthletes();

        System.out.println("\n\nTodos os atletas vinculados a você: \n\n");

        for (User athlete : athletes) {
            System.out.println(athlete.getId() + " - " + athlete.getName() + " - " + athlete.getEmail());
        }

        if (athletes.isEmpty()) {
            System.out.println("Registe algum atleta para ele aparecer nessa listagem!");
        }
    }

    private void getAthletes() {
        try {
            athletes = personalService.getAthletes();
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
        }
    }

}
