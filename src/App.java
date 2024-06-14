import dao.UserDAO;
import entity.Athlete;
import entity.Personal;
import exception.DAOException;
import view.AuthView;
import view.Navigator;

public class App {
    public static void main(String[] args) {
        preload();
        Navigator nav = Navigator.getInstance();
        nav.push(new AuthView());
    }

    private static void preload() {
        UserDAO userDAO = new UserDAO();

        try {
            userDAO.save(new Personal("Lucas Personal", "lucas.maiarc435@gmail.com"));
            userDAO.save(new Athlete("Atleta 1", "atleta1@gmail.com", 0));
            userDAO.save(new Athlete("Atleta 2", "atleta2@gmail.com", 0));
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
