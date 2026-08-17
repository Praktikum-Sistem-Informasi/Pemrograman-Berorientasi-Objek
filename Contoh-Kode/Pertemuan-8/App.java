//========================================
// Topik: GUI
//========================================

// Kamu dapat meletakkan file ini di src/main/App.java
// App.java berfungsi sebagai Entry Point (titik awal utama) jalannya sebuah program.

package main;

import view.MainFrame;

public class App {
    public static void main(String args[]) {
        // Memanggil dan menampilkan form GUI utama menggunakan antrean standar Swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek dari MainFrame lalu menampilkannya ke layar
                new MainFrame().setVisible(true);
            }
        });
    }
}