package main;

import controller.BukuController;
import view.BukuView;

public class MainApp {
    public static void main(String[] args) {
        BukuController controller = new BukuController();
        BukuView view = new BukuView(controller);
        view.renderMenu();
    }
}
