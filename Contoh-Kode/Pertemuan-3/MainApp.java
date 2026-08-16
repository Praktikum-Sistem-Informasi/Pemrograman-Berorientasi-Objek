// ===========================================================
// Topik: Access Modifier & Encapsulation
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

import model.Buku;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   PERTEMUAN 3: ACCESS MODIFIER & ENCAPSULATION  ");
        System.out.println("=================================================\n");

        // 1. INSTANSIASI OBJEK DENGAN DATA VALID
        System.out.println("--- 1. Membuat Objek Buku Normal ---");
        Buku buku1 = new Buku("B001", "Pemrograman Java", "James Gosling", 5);
        buku1.tampilkanInfo();

        // 2. DEMO AKSES ILEGAL (PEMBUKTIAN ACCESS MODIFIER PRIVATE)
        System.out.println("\n--- 2. Uji Coba Akses Langsung Atribut Private ---");
        // KODE DI BAWAH INI JIKA DI-UNCOMMENT AKAN CAUSE COMPILER ERROR:
        // buku1.stok = -10; // ERROR: stok has private access in model.Buku
        // buku1.judul = ""; // ERROR: judul has private access in model.Buku
        System.out.println("[SISTEM]: Atribut 'stok' & 'judul' bersifat PRIVATE.");
        System.out.println("[SISTEM]: Langsung mengubah buku1.stok = -10 ditolak oleh Java Compiler!");

        // 3. DEMO SETTER DENGAN VALIDASI (PERCOBAAN INPUT INVALID)
        System.out.println("\n--- 3. Mengubah Data Lewat Setter (Input Salah) ---");
        System.out.println("Mencoba set stok menjadi -15...");
        buku1.setStok(-15); // Akan memicu pesan error validasi dari Setter

        System.out.println("Mencoba set judul menjadi string kosong...");
        buku1.setJudul(""); // Akan memicu pesan error validasi dari Setter

        // Tampilkan kondisi data setelah dites dengan input salah
        System.out.println("\nKondisi Objek Setelah Input Invalid:");
        buku1.tampilkanInfo();

        // 4. DEMO SETTER DENGAN INPUT VALID
        System.out.println("\n--- 4. Mengubah Data Lewat Setter (Input Valid) ---");
        System.out.println("Mengubah stok menjadi 12...");
        buku1.setStok(12);

        System.out.println("Mengubah judul menjadi 'Java PBO Lanjut'...");
        buku1.setJudul("Java PBO Lanjut");

        // Tampilkan kondisi data akhir menggunakan Getter
        System.out.println("\nKondisi Objek Akhir (Diakses lewat Getter):");
        System.out.println("ID Buku : " + buku1.getIdBuku());
        System.out.println("Judul   : " + buku1.getJudul());
        System.out.println("Penulis : " + buku1.getPenulis());
        System.out.println("Stok    : " + buku1.getStok());
    }
}