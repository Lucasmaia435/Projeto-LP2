package view;

import java.util.ArrayList;
import java.util.List;

public class Navigator {
    private static Navigator instance;

    private List<View> pages;

    private Navigator() {
        pages = new ArrayList<>();
    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }

        return instance;
    }

    public boolean pop() {
        if (canPop()) {
            pages.removeLast();

            showCurrentView();

            return true;
        }

        return false;
    }

    public void push(View view) {
        pages.add(view);
        showCurrentView();
    }

    private boolean canPop() {
        return pages.size() > 1;
    }

    private View getCurrentView() {
        return pages.getLast();
    }

    private void clearPreviousView() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void showCurrentView() {
        clearPreviousView();
        getCurrentView().startView();
    }
}
