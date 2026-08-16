//========================================
// Topik: Java Collection
//========================================

import java.util.ArrayList;

public class ContohArrayList {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("        CONTOH 2: JAVA ARRAYLIST          ");
        System.out.println("==========================================");

        // 1. Deklarasi ArrayList String (Ukuran FLEKSIBEL/DINAMIS)
        ArrayList<String> daftarBuku = new ArrayList<>();

        // 2. Mengisi data menggunakan method .add()
        // Bebas menambah berapa pun tanpa takut kehabisan slot!
        daftarBuku.add("Pemrograman Java");
        daftarBuku.add("Struktur Data");
        daftarBuku.add("Basis Data");
        daftarBuku.add("Jaringan Komputer"); // Tambah data ke-4 dengan aman!

        // 3. Menampilkan jumlah elemen yang tersimpan (.size())
        System.out.println("Jumlah Elemen Terisi   : " + daftarBuku.size());
        System.out.println("------------------------------------------");

        // 4. Menampilkan semua isi ArrayList menggunakan Perulangan (For Loop)
        System.out.println("Daftar Buku di ArrayList:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            // Mengambil elemen menggunakan method .get(indeks)
            System.out.println("Indeks ke-" + i + " : " + daftarBuku.get(i));
        }
    }
}