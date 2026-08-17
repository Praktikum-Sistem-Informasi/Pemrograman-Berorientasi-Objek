// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/controller/BukuController.java
// ===========================================================

package controller;

import dao.BukuDAO;
import model.Buku;

import java.util.List;

public class BukuController {

    private BukuDAO bukuDAO = new BukuDAO();

    public boolean tambahBuku(String id, String judul, String penulis, int tahun, int stok) {
        Buku buku = new Buku(id, judul, penulis, tahun, stok);
        return bukuDAO.tambahBuku(buku);
    }

    public List<Buku> getSemuaBuku() {
        return bukuDAO.tampilkanSemuaBuku();
    }

    public Buku cariBuku(String id) {
        return bukuDAO.cariBukuById(id);
    }

    public boolean updateBuku(String id, String judul, String penulis, int tahun, int stok) {
        Buku buku = new Buku(id, judul, penulis, tahun, stok);
        return bukuDAO.updateBuku(buku);
    }

    public boolean hapusBuku(String id) {
        return bukuDAO.hapusBuku(id);
    }
}