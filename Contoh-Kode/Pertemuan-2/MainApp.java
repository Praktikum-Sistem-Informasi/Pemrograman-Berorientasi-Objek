// ===========================================================
// Topik: Package, Class, Object
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

// Import Class Buku dari package model
import model.Buku;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        // Menyimpan objek Buku ke dalam ArrayList
        ArrayList<Buku> daftarBuku = new ArrayList<>();

        // Membuat objek Buku menggunakan constructor
        daftarBuku.add(new Buku(
            "B001",
            "Pemrograman Java",
            "James Gosling",
            2020,
            5
        ));

        daftarBuku.add(new Buku(
            "B002",
            "Struktur Data",
            "Ada Lovelace",
            2021,
            3
        ));

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {

            System.out.println("\n==========================================");
            System.out.println("       SISTEM PERPUSTAKAAN");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Baru");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Stok Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                // ==========================================
                // 1. TAMPILKAN SEMUA BUKU
                // ==========================================
                case 1:
                    System.out.println("\n=== DAFTAR BUKU ===");

                    if (daftarBuku.isEmpty()) {
                        System.out.println("Belum ada data buku.");
                    } else {
                        for (Buku b : daftarBuku) {
                            b.tampilkanInfo();
                        }
                    }
                    break;

                // ==========================================
                // 2. TAMBAH BUKU
                // ==========================================
                case 2:
                    System.out.println("\n=== TAMBAH BUKU BARU ===");

                    System.out.print("Masukkan ID Buku      : ");
                    String id = scanner.nextLine();

                    System.out.print("Masukkan Judul Buku   : ");
                    String judul = scanner.nextLine();

                    System.out.print("Masukkan Nama Penulis : ");
                    String penulis = scanner.nextLine();

                    System.out.print("Masukkan Tahun Terbit : ");
                    int tahunTerbit = scanner.nextInt();

                    System.out.print("Masukkan Stok         : ");
                    int stok = scanner.nextInt();
                    scanner.nextLine();

                    // Membuat objek Buku baru
                    Buku bukuBaru = new Buku(
                        id,
                        judul,
                        penulis,
                        tahunTerbit,
                        stok
                    );

                    // Menambahkan objek ke ArrayList
                    daftarBuku.add(bukuBaru);

                    System.out.println(
                        "Buku berhasil dibuat dan ditambahkan!"
                    );
                    break;

                // ==========================================
                // 3. CARI BUKU
                // ==========================================
                case 3:
                    System.out.println("\n=== CARI BUKU ===");

                    System.out.print("Masukkan kata kunci judul: ");
                    String kataKunci = scanner.nextLine();

                    boolean ditemukan = false;

                    for (Buku b : daftarBuku) {

                        // Akses atribut secara langsung
                        if (b.judul.toLowerCase()
                                .contains(kataKunci.toLowerCase())) {

                            b.tampilkanInfo();
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                // ==========================================
                // 4. UPDATE STOK
                // ==========================================
                case 4:
                    System.out.println("\n=== UPDATE STOK BUKU ===");

                    System.out.print("Masukkan ID Buku: ");
                    String idUpdate = scanner.nextLine();

                    Buku bukuDitemukan = null;

                    for (Buku b : daftarBuku) {

                        // Akses atribut secara langsung
                        if (b.idBuku.equalsIgnoreCase(idUpdate)) {
                            bukuDitemukan = b;
                            break;
                        }
                    }

                    if (bukuDitemukan != null) {

                        System.out.print("Masukkan Stok Baru: ");
                        bukuDitemukan.stok = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(
                            "Stok buku berhasil diubah!"
                        );

                    } else {
                        System.out.println(
                            "ID Buku tidak ditemukan!"
                        );
                    }
                    break;

                // ==========================================
                // 5. HAPUS BUKU
                // ==========================================
                case 5:
                    System.out.println("\n=== HAPUS BUKU ===");

                    System.out.print(
                        "Masukkan ID Buku yang akan dihapus: "
                    );

                    String idHapus = scanner.nextLine();

                    Buku bukuHapus = null;

                    for (Buku b : daftarBuku) {

                        // Akses atribut secara langsung
                        if (b.idBuku.equalsIgnoreCase(idHapus)) {
                            bukuHapus = b;
                            break;
                        }
                    }

                    if (bukuHapus != null) {

                        daftarBuku.remove(bukuHapus);

                        System.out.println(
                            "Buku '" + bukuHapus.judul
                            + "' berhasil dihapus!"
                        );

                    } else {
                        System.out.println(
                            "ID Buku tidak ditemukan!"
                        );
                    }
                    break;

                // ==========================================
                // 6. KELUAR
                // ==========================================
                case 6:
                    berjalan = false;

                    System.out.println(
                        "\nProgram selesai."
                    );
                    break;

                // ==========================================
                // PILIHAN TIDAK VALID
                // ==========================================
                default:
                    System.out.println(
                        "Pilihan tidak valid!"
                    );
            }
        }

        scanner.close();
    }
}
