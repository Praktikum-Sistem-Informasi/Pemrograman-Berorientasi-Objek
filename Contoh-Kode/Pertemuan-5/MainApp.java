// ===========================================================
// Topik: Polimorphism
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

import model.Koleksi;
import model.Buku;
import model.Majalah;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        PERTEMUAN 5: POLYMORPHISM (PBO)          ");
        System.out.println("=================================================\n");

        // 1. POLYMORPHIC COLLECTION (Satu List menampung berbagai tipe turunan Koleksi)
        ArrayList<Koleksi> daftarKoleksi = new ArrayList<>();

        // Memasukkan objek Buku dan Majalah ke dalam tipe referensi Koleksi
        daftarKoleksi.add(new Buku("B001", "Pemrograman Java", 2023, "James Gosling", 5));
        daftarKoleksi.add(new Majalah("M001", "National Geographic", 2024, 142));
        daftarKoleksi.add(new Buku("B002", "Struktur Data", 2022, "Ada Lovelace", 3));
        daftarKoleksi.add(new Majalah("M002", "Info Komputer", 2023, 88));

        // 2. DEMO DYNAMIC POLYMORPHISM (METHOD OVERRIDING)
        System.out.println("--- DAFTAR SELURUH KOLEKSI PERPUSTAKAAN ---");
        for (Koleksi k : daftarKoleksi) {
            // Java secara otomatis memanggil tampilkanInfo() sesuai wujud ASLI objeknya
            k.tampilkanInfo(); 
        }

        // 3. DEMO STATIC POLYMORPHISM (METHOD OVERLOADING)
        System.out.println("\n--- DEMO METHOD OVERLOADING (PENCARIAN) ---");
        
        // Pencarian 1: Berdasarkan String (Judul)
        String cariJudul = "Java";
        System.out.println("-> Hasil Pencarian Judul '" + cariJudul + "':");
        for (Koleksi k : daftarKoleksi) {
            if (k.cocokData(cariJudul)) { // Memanggil Overload 1 (String)
                k.tampilkanInfo();
            }
        }

        // Pencarian 2: Berdasarkan int (Tahun Terbit)
        int cariTahun = 2024;
        System.out.println("\n-> Hasil Pencarian Tahun Terbit persis '" + cariTahun + "':");
        for (Koleksi k : daftarKoleksi) {
            if (k.cocokData(cariTahun)) { // Memanggil Overload 2 (int)
                k.tampilkanInfo();
            }
        }
    }
}