// ===========================================================
// Topik: Inheritance (Pewarisan)
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

import model.BukuCetak;
import model.EBook;

public class MainApp {
    public static void main(String[] args) {
        // 1. Instansiasi Objek BukuCetak (Subclass 1 dari Buku)
        BukuCetak bukuCetak1 = new BukuCetak(
                "BC001", "Pemrograman Java", "James Gosling", 2023, 350, "Rak A-1");

        // 2. Instansiasi Objek EBook (Subclass 2 dari Buku)
        EBook ebook1 = new EBook(
                "EB001", "Belajar Python Otodidak", "Guido van Rossum", 2024, 12.5, "PDF");

        System.out.println("--- DAFTAR KOLEKSI BUKU PERPUSTAKAAN ---");

        // Menampilkan Info BukuCetak (method khusus, bukan overriding)
        bukuCetak1.tampilkanInfoBukuCetak();

        // Menampilkan Info EBook (method khusus, bukan overriding)
        ebook1.tampilkanInfoEBook();

        // 3. Pembuktian Hubungan IS-A: method & getter milik Buku
        // (Superclass) bisa langsung dipakai oleh objek BukuCetak & EBook
        // tanpa perlu ditulis ulang -> inti manfaat 'extends'.
        System.out.println("\n--- PEMBUKTIAN REUSABILITAS KODE (SUPERCLASS) ---");
        System.out.println("Judul BukuCetak (via getJudul Superclass) : " + bukuCetak1.getJudul());
        System.out.println("Judul EBook (via getJudul Superclass)     : " + ebook1.getJudul());

        // 4. Pembuktian atribut 'final': idBuku hanya bisa dibaca,
        // tidak ada setter yang mengizinkan perubahan setelah objek dibuat.
        System.out.println("ID BukuCetak (final, tidak bisa diubah)   : " + bukuCetak1.getIdBuku());
        System.out.println("ID EBook (final, tidak bisa diubah)       : " + ebook1.getIdBuku());
    }
}