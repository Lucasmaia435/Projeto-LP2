import java.util.List;

import dao.ExerciseDAO;
// import dao.UserDAO;
// import dao.WorkoutSessionDAO;
// import entity.Athlete;
import entity.Exercise;
// import entity.Personal;
// import entity.WorkoutSession;
import exception.DAOException;
import view.Navigator;
import view.auth.OnboardView;

public class App {
    public static void main(String[] args) {
        preload();
        Navigator nav = Navigator.getInstance();
        nav.push(new OnboardView());
    }

    private static void preload() {
        // UserDAO userDAO = new UserDAO();

        // WorkoutSessionDAO workoutSessionDAO = new WorkoutSessionDAO();

        ExerciseDAO exerciseDAO = new ExerciseDAO();
        try {
            // userDAO.save(new Personal("Personal 1", "personal@gmail.com"));
            // userDAO.save(new Athlete("Atleta 1", "atleta1@gmail.com", 1));
            // userDAO.save(new Athlete("Atleta 2", "atleta2@gmail.com", 1));

            // workoutSessionDAO.save(new WorkoutSession("Treino de força", 2));

            List<String> exercises = List.of("Supino reto", "Supino inclinado", "Rosca direta", "Rosca inversa",
                    "Rosca francesa",
                    "Triceps na polia", "Legpress 45", "Agachamento", "Levantamento Terra", "Puxada alta",
                    "Remada baixa");

            for (String exercise : exercises) {
                exerciseDAO.save(new Exercise(exercise));
            }

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
