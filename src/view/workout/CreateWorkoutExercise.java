package view.workout;

import java.util.ArrayList;
import java.util.List;

import entity.Exercise;
import entity.WorkoutExercise;
import entity.WorkoutSession;
import service.ExerciseService;
import service.WorkoutSessionService;
import view.View;

public class CreateWorkoutExercise implements View {
    WorkoutSession session;

    public CreateWorkoutExercise(WorkoutSession session) {
        this.session = session;
    }

    ExerciseService exerciseService = new ExerciseService();
    WorkoutSessionService workoutSessionService = new WorkoutSessionService();

    List<Integer> validIds = new ArrayList<>();

    @Override
    public void startView() {
        System.out.println("O nosso sistema dá suporte para os seguintes exercicios:");

        for (Exercise exercise : exerciseService.getExercises()) {
            System.out.println("[" + exercise.getId() + "] " + exercise.getName());
            validIds.add(exercise.getId());
        }

        System.out.println("\n=========Menu=========");
        System.out.println("Digite o id do exercicio para adiciona-lo a seção.");
        System.out.println("Digite 0 para cancelar a operação.");
        System.out.println("\n======================");
        while (true) {
            int option = scanner.nextInt();

            if (validIds.contains(option)) {
                System.out.println("Digite a quantidade de séries:");
                int sets = scanner.nextInt();

                System.out.println("Digite a quantidade de repetições por série:");
                int reps = scanner.nextInt();

                WorkoutExercise newExercise = new WorkoutExercise(exerciseService.getExerciseById(option), sets, reps);

                System.out.println("Quer confirmar a inserção de " + newExercise + "? (S/N)");

                while (true) {
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("S")) {
                        session.addExercise(newExercise);

                        workoutSessionService.update(session);
                        navigator.pop();
                        break;
                    }

                    if (confirm.equalsIgnoreCase("N")) {
                        navigator.pop();

                        break;
                    }

                    System.out.println("Digite S ou N para confirmar!");
                }
            }

            if (option == 0) {
                navigator.pop();
                return;
            }
        }
    }

}
