package view.athlete;

import java.util.ArrayList;
import java.util.List;

import entity.Athlete;
import entity.WorkoutSession;
import exception.DAOException;
import service.AthleteService;
import service.PersonalService;
import state.AuthState;
import view.View;
import view.error.ErrorView;
import view.workout.CreateWorkoutSession;
import view.workout.WorkoutSessionView;

public class AthleteView implements View {
    Athlete athlete;

    public AthleteView(Athlete athlete) {
        this.athlete = athlete;
    }

    AuthState state = AuthState.getInstance();

    AthleteService athleteService = new AthleteService();
    PersonalService personalService = new PersonalService();

    List<Integer> validIds = new ArrayList<>();

    @Override
    public void startView() {
        System.out.println("Atleta: " + athlete.getName());

        for (WorkoutSession session : getSessions()) {
            System.out.println("[" + session.getId() + "] - " + session.getName());
            validIds.add(session.getId());
        }

        if (getSessions().isEmpty()) {
            System.out.println("Esse atleta não possui nenhuma seção de treino, registre uma!");
        }

        System.out.println("\n\n-----------Menu-----------");

        if (state.isPersonal()) {
            System.out.println("Digite 'A' para adicionar uma nova seção de treino");
            System.out.println("Digite 'X' para deletar o atleta");
        }

        System.out.println("Digite o ID de uma seção para acessar a sua tela de detalhes");
        System.out.println("Digite 0 para voltar para a tela anterior");

        while (true) {
            String option = scanner.nextLine();

            try {
                int optionInteger = Integer.parseInt(option);

                if (validIds.contains(optionInteger)) {
                    viewWorkoutSessionById(optionInteger);
                }

                if (optionInteger == 0) {
                    navigator.pop();
                }
            } catch (NumberFormatException e) {
                if (state.isPersonal()) {
                    if (option.equals("X")) {
                        deleteAthlete();
                    }

                    if (option.equals("A")) {
                        navigator.push(new CreateWorkoutSession(athlete));
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
    }
}
