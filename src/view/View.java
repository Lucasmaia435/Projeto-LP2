package view;

import java.util.Scanner;

public interface View {
    Navigator navigator = Navigator.getInstance();

    Scanner scanner = new Scanner(System.in);

    void startView();
}
