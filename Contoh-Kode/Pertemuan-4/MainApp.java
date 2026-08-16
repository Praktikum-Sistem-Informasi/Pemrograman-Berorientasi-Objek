// ===========================================================
// Topik: Inheritance
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

import model.Buku;
import model.Majalah;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        PERTEMUAN 4: INHERITANCE (PEWARISAN)     ");
        System.out.println("=================================================\n");

        // 1. Instansiasi Objek Buku (Subclass 1)
        Buku buku1 = new Buku("B001", "Pemrograman Java", 2023, "James Gosling", 5);

        // 2. Instansiasi Objek Majalah (Subclass 2)
        Majalah majalah1 = new Majalah("M001", "National Geographic", 2024, 142);

        System.out.println("--- DAFTAR KOLEKSI PERPUSTAKAAN ---");
        
        // Menampilkan Info Buku
        buku1.tampilkanInfoBuku();

        // Menampilkan Info Majalah
        majalah1.tampilkanInfoMajalah();

        // Pembuktian Hubungan IS-A (Mencoba method getter bawaan dari Superclass)
        System.out.println("\n--- PEMBUKTIAN REUSABILITAS KODE (SUPERCLASS) ---");
        System.out.println("Judul Buku (via getJudul Superclass)    : " + buku1.getJudul());
        System.out.println("Judul Majalah (via getJudul Superclass) : " + majalah1.getJudul());
    }
}