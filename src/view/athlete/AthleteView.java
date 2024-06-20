package view.athlete;

import java.util.ArrayList;
import java.util.List;

import entity.Athlete;
import entity.WorkoutSession;
import exception.DAOException;
import service.AthleteService;
import service.PersonalService;
import view.View;
import view.error.ErrorView;
import view.workout.CreateWorkoutSession;
import view.workout.WorkoutSessionView;

public class AthleteView implements View {
    Athlete athlete;

    public AthleteView(Athlete athlete) {
        this.athlete = athlete;
    }

    AthleteService athleteService = new AthleteService();
    PersonalService personalService = new PersonalService();

    List<Integer> validIds = new ArrayList<>();

    @Override
    public void startView() {
        if (state.isPersonal()) {
            System.out.println("============ Atleta: " + athlete.getName() + " ============");
        } else {
            System.out.println("============ Bem vindo: " + athlete.getName() + " ============");
        }
        System.out.println("----------------------------------");
        for (WorkoutSession session : getSessions()) {
            System.out.println("[" + session.getId() + "] - " + session.getName());
            System.out.println("----------------------------------");
            validIds.add(session.getId());
        }

        if (getSessions().isEmpty()) {
            System.out.println("Esse atleta não possui nenhuma seção de treino, registre uma!");
        }

        System.out.println("\n=========Menu=========");

        if (state.isPersonal()) {
            System.out.println("Digite 'A' para adicionar uma nova seção de treino.");
            System.out.println("Digite 'X' para deletar o atleta.");
        }

        System.out.println("Digite o ID de uma seção para acessar a sua tela de detalhes.");

        if (state.isPersonal()) {
            System.out.println("Digite 0 para voltar para a tela anterior.");
        } else {
            System.out.println("Digite 0 para voltar para deslogar.");
        }

        System.out.println("\n======================");

        while (true) {
            String option = scanner.nextLine();

            try {
                int optionInteger = Integer.parseInt(option);

                if (validIds.contains(optionInteger)) {
                    viewWorkoutSessionById(optionInteger);
                }

                if (optionInteger == 0) {
                    navigator.pop();
                    return;
                }
            } catch (NumberFormatException e) {
                if (state.isPersonal()) {
                    if (option.equalsIgnoreCase("X")) {
                        deleteAthlete();
                    }

                    if (option.equalsIgnoreCase("A")) {
                        navigator.push(new CreateWorkoutSession(athlete));
                        return;
                    }
                }
            }
        }
    }

    public List<WorkoutSession> getSessions() {
        try {
            return athleteService.getWorkouts(athlete.getId());
        } catch (DAOException e) {
            navigator.push(
                    new ErrorView(
                            "Não foi possível carregar as sessões do atleta: " + athlete.getName() + "\n\nError:" + e));
        }
        return null;
    }

    private void viewWorkoutSessionById(int id) {
        try {
            WorkoutSession session = athleteService.getWorkoutById(id);

            navigator.push(new WorkoutSessionView(session));
        } catch (DAOException e) {
            navigator.push(new ErrorView(e.getMessage()));
        }
    }

    private void deleteAthlete() {
        personalService.deleteAthlete(athlete.getId());
        navigator.pop();
        return;
    }
}
