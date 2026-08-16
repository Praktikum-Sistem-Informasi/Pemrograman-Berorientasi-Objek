// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

import controller.KoleksiController;
import view.KoleksiView;

public class MainApp {
    public static void main(String[] args) {
        // Inisialisasi Controller (Logika Bisnis)
        KoleksiController controller = new KoleksiController();

        // Inisialisasi View (Tampilan UI) dan jalankan
        KoleksiView view = new KoleksiView(controller);
        view.renderMenu();
    }
}