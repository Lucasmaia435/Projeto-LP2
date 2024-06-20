package view.workout;

import entity.Athlete;
import entity.WorkoutSession;
import service.WorkoutSessionService;
import view.View;

public class CreateWorkoutSession implements View {
    Athlete athlete;

    public CreateWorkoutSession(Athlete athlete) {
        this.athlete = athlete;
    }

    WorkoutSessionService workoutSessionService = new WorkoutSessionService();

    @Override
    public void startView() {
        System.out.println("Criando uma nova seção de treino para: " + athlete.getName());
        System.out.println("Caso deseje cancelar a ação, digite 0.");

        System.out.println("\nDigite o nome da seção:");
        String name = scanner.nextLine();

        if (name.equals("0")) {
            navigator.pop();
            return;
        }

        WorkoutSession session = new WorkoutSession(name, athlete.getId());

        workoutSessionService.save(session);

        navigator.pop();
        return;
    }

}
