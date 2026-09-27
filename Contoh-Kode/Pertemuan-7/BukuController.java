// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/controller/BukuController.java
// ===========================================================

package controller;
import model.BukuDAO;
import model.Buku;
import view.BukuView;

public class BukuController {
    BukuView view = new BukuView();
    BukuDAO dao = new BukuDAO();

    public void mulai() {
        int menu;
        do {
            menu = view.tampilkanMenu();

            switch (menu) {
                case 1 -> {
                    Buku bukuBaru = view.inputDataBuku();
                    dao.tambahBuku(bukuBaru);
                }
                case 2 -> view.tampilkanData(dao.getAllBuku());
                case 3 -> {
                    view.tampilkanData(dao.getAllBuku());
                    System.out.println("Ketik ulang ID yang mau diubah, lalu isi data barunya:");
                    Buku bukuUbah = view.inputDataBuku();
                    dao.updateBuku(bukuUbah);
                }
                case 4 -> {
                    view.tampilkanData(dao.getAllBuku());
                    String idHapus = view.inputId();
                    dao.hapusBuku(idHapus);
                }
                case 0 -> System.out.println("Program Selesai.");
                default -> System.out.println("Menu tidak ada!");
            }

        } while (menu != 0);
    }
}
