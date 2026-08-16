// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/controller/KoleksiController.java
// ===========================================================

package controller;

import model.Koleksi;
import model.Buku;
import model.Majalah;
import model.Pinjamable;
import java.util.ArrayList;

public class KoleksiController {
    // Data disimpan di dalam Controller
    private ArrayList<Koleksi> listKoleksi = new ArrayList<>();

    public KoleksiController() {
        // Dummy Data Awal
        listKoleksi.add(new Buku("B001", "Pemrograman Java", 2023, "James Gosling", 3));
        listKoleksi.add(new Majalah("M001", "Info Komputer", 2024, 12));
    }

    public ArrayList<Koleksi> getAllKoleksi() {
        return listKoleksi;
    }

    public void tambahKoleksi(Koleksi k) {
        listKoleksi.add(k);
    }

    public Koleksi cariById(String id) {
        for (Koleksi k : listKoleksi) {
            if (k.getIdKoleksi().equalsIgnoreCase(id)) {
                return k;
            }
        }
        return null;
    }

    public void prosesPinjamBuku(String id) {
        Koleksi k = cariById(id);
        if (k == null) {
            System.out.println(">> ERROR: ID Koleksi tidak ditemukan!");
        } else if (k instanceof Pinjamable) {
            // Downcasting & mengeksekusi method dari Interface
            ((Pinjamable) k).pinjam();
        } else {
            System.out.println(">> ERROR: Koleksi jenis ini (" + k.getClass().getSimpleName() + ") TIDAK BISA dipinjam!");
        }
    }
}