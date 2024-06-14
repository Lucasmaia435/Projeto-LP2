package view;

import java.util.Scanner;
import java.util.List;

import dao.UserDAO;
import entity.Personal;
import entity.User;
import exception.DAOException;

public class SecundaryView implements View {
    Navigator navigator = Navigator.getInstance();

    UserDAO UserDAO = new UserDAO();

    @Override
    public void startView() {

        try {
            UserDAO.save(new Personal("Lucas", "Lucas.maiarc435@gmail.com"));
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        List<User> personais;

        try {
            personais = UserDAO.findAll();
            System.out.println("--------- Personais disponiveis -------------");
            for (User personal : personais) {
                System.out.println(personal.getId() + " - " + personal.getName() + " - " + personal.getEmail());
            }
            System.out.println("---------------------------------------------");

        } catch (DAOException e) {
            e.printStackTrace();
        }
        int option = scanner.nextInt();

        if (option == 0) {
            navigator.pop();
        }

        scanner.close();
    }
}
