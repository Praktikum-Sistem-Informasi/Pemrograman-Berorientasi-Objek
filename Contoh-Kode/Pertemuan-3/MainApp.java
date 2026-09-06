// ===========================================================
// Topik: Access Modifier & Encapsulation
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

import Model.Buku;

public class Main {

    public static void main(String[] args) {

        // Membuat object Buku
        Buku buku1 = new Buku(
            "B001",
            "Laskar Pelangi",
            "Andrea Hirata",
            2020,
            30
        );

        Buku buku2 = new Buku(
            "B002",
            "Bumi Manusia",
            "Pramoedya Ananta Toer",
            2023,
            85
        );

        // Menampilkan informasi awal buku
        System.out.println("=== INFORMASI AWAL ===");
        buku1.tampilkanInfo();
        buku2.tampilkanInfo();

        // Mengakses data menggunakan Getter
        System.out.println("\n=== MENGAKSES DATA DENGAN GETTER ===");
        System.out.println("ID Buku      : " + buku1.getIdBuku());
        System.out.println("Judul        : " + buku1.getJudul());
        System.out.println("Penulis      : " + buku1.getPenulis());
        System.out.println("Tahun Terbit : " + buku1.getTahunTerbit());
        System.out.println("Stok         : " + buku1.getStok());

        // Mengubah data menggunakan Setter
        System.out.println("\n=== MENGUBAH DATA DENGAN SETTER ===");

        buku1.setIdBuku("B001-UPDATE");
        buku1.setJudul("Laskar Pelangi - Edisi Baru");
        buku1.setPenulis("Andrea Hirata");
        buku1.setTahunTerbit(2024);
        buku1.setStok(50);

        // Menampilkan data setelah diubah
        System.out.println("\nData setelah diubah:");
        buku1.tampilkanInfo();

        // Mencoba memasukkan data yang tidak valid
        System.out.println("\n=== PENGUJIAN VALIDASI ===");

        System.out.println("\n1. Menguji judul kosong:");
        buku1.setJudul("");

        System.out.println("\n2. Menguji penulis kosong:");
        buku1.setPenulis("");

        System.out.println("\n3. Menguji tahun terbit tidak valid:");
        buku1.setTahunTerbit(-500);

        System.out.println("\n4. Menguji stok terlalu kecil:");
        buku1.setStok(10);

        System.out.println("\n5. Menguji stok terlalu besar:");
        buku1.setStok(150);

        // Menampilkan data setelah validasi
        System.out.println("\n=== DATA SETELAH VALIDASI ===");
        buku1.tampilkanInfo();
    }
}
}
