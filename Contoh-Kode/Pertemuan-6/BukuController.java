package controller;

import model.Buku;
import model.BukuCetak;
import model.EBook;
import model.Pinjamable;
import model.Unduhable;
import java.util.ArrayList;

public class BukuController {
    private ArrayList<Buku> listBuku = new ArrayList<>();

    public BukuController() {
        // Dummy Data Awal (constructor sama persis dengan Buku.java/BukuCetak.java/EBook.java)
        listBuku.add(new BukuCetak("BC001", "Pemrograman Java", "James Gosling", 2023, 350, "Rak A-1"));
        listBuku.add(new EBook("EB001", "Belajar Python Otodidak", "Guido van Rossum", 2024, 12.5, "PDF"));
    }

    public ArrayList<Buku> getAllBuku() {
        return listBuku;
    }

    public void tambahBuku(Buku b) {
        listBuku.add(b);
    }

    public Buku cariById(String id) {
        for (Buku b : listBuku) {
            if (b.getIdBuku().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }

    public void prosesPinjamBuku(String id) {
        Buku b = cariById(id);
        if (b == null) {
            System.out.println(">> ERROR: ID Buku tidak ditemukan!");
        } else if (b instanceof Pinjamable) {
            // Downcasting aman untuk mengakses kemampuan dari Interface
            ((Pinjamable) b).pinjam();
        } else {
            System.out.println(">> ERROR: Buku jenis ini (" + b.getClass().getSimpleName() + ") TIDAK BISA dipinjam!");
        }
    }

    public void prosesUnduhBuku(String id) {
        Buku b = cariById(id);
        if (b == null) {
            System.out.println(">> ERROR: ID Buku tidak ditemukan!");
        } else if (b instanceof Unduhable) {
            ((Unduhable) b).unduh();
        } else {
            System.out.println(">> ERROR: Buku jenis ini (" + b.getClass().getSimpleName() + ") TIDAK BISA diunduh!");
        }
    }
}
