package view.workout;

import java.util.ArrayList;
import java.util.List;

import entity.WorkoutExercise;
import entity.WorkoutSession;
import service.WorkoutSessionService;
import view.View;

public class WorkoutSessionView implements View {

    WorkoutSession session;

    public WorkoutSessionView(WorkoutSession session) {
        this.session = session;
    }

    WorkoutSessionService workoutSessionService = new WorkoutSessionService();
    List<Integer> validIds = new ArrayList<>();

    @Override
    public void startView() {
        System.out.println("Seção: " + session.getName());
        System.out.println();

        for (WorkoutExercise exercise : session.getExercises()) {
            System.out.println("[" + exercise.getId() + "] - " + exercise);
            validIds.add(exercise.getId());
        }

        if (session.getExercises().isEmpty()) {
            System.out.println("Essa seção não possui nenhum exercicio, registre algum!");
        }

        System.out.println("\n\n-----------Menu-----------");
        if (state.isPersonal()) {
            System.out.println("Digite 'A' para adicionar um exercicio a seção atual");
            System.out.println("Digite 'X' para deletar o atleta");
        }

        System.out.println("Digite 0 para voltar para a tela anterior");

        while (true) {
            String option = scanner.nextLine();

            if (state.isPersonal()) {
                if (option.equals("X")) {
                    deleteWorkoutSession();
                }

                if (option.equals("A")) {
                    navigator.push(new CreateWorkoutExercise(session));
                }
            }

            if (option.equals("0")) {
                navigator.pop();
            }
        }
    }

    private void deleteWorkoutSession() {
        workoutSessionService.deleteById(session.getId());
        navigator.pop();
    }
}
