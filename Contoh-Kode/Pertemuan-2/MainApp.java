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
        // HANYA BUTUH 1 ARRAYLIST UNTUK MENAMPUNG OBJEK BUKU
        ArrayList<Buku> daftarBuku = new ArrayList<>();

        // Instansiasi Objek menggunakan kata kunci 'new' dan Constructor
        daftarBuku.add(new Buku("B001", "Pemrograman Java", "James Gosling", 5));
        daftarBuku.add(new Buku("B002", "Struktur Data", "Ada Lovelace", 3));

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM PERPUSTAKAAN (P2: CLASS & OBJECT)");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Baru");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Stok Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR BUKU PERPUSTAKAAN ---");
                    if (daftarBuku.isEmpty()) {
                        System.out.println("Belum ada data buku.");
                    } else {
                        System.out.printf("%-6s | %-25s | %-20s | %-5s\n", "ID", "Judul Buku", "Penulis", "Stok");
                        System.out.println("------------------------------------------------------------------");
                        for (Buku b : daftarBuku) {
                            b.tampilkanInfo(); // Memanggil method dari objek Buku
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH BUKU BARU ---");
                    System.out.print("Masukkan ID Buku      : ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku   : ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Nama Penulis : ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan Stok         : ");
                    int stok = scanner.nextInt();

                    // MENGINSTANSIASI OBJEK BARU & MENAMBAHKANNYA KE LIST
                    Buku bukuBaru = new Buku(id, judul, penulis, stok);
                    daftarBuku.add(bukuBaru);

                    System.out.println(">> SUCCESS: Objek Buku berhasil dibuat dan ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n--- CARI BUKU ---");
                    System.out.print("Masukkan Kata Kunci Judul: ");
                    String kataKunci = scanner.nextLine();
                    boolean ditemukan = false;

                    for (Buku b : daftarBuku) {
                        if (b.judul.toLowerCase().contains(kataKunci.toLowerCase())) {
                            b.tampilkanInfo();
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println(">> INFO: Buku tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- UPDATE STOK BUKU ---");
                    System.out.print("Masukkan ID Buku: ");
                    String idUpdate = scanner.nextLine();
                    Buku bukuDitemukan = null;

                    for (Buku b : daftarBuku) {
                        if (b.idBuku.equalsIgnoreCase(idUpdate)) {
                            bukuDitemukan = b;
                            break;
                        }
                    }

                    if (bukuDitemukan != null) {
                        System.out.print("Masukkan Stok Baru: ");
                        bukuDitemukan.stok = scanner.nextInt(); // Mengubah atribut objek secara langsung
                        System.out.println(">> SUCCESS: Stok buku " + bukuDitemukan.judul + " berhasil diubah!");
                    } else {
                        System.out.println(">> ERROR: ID Buku tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("\n--- HAPUS BUKU ---");
                    System.out.print("Masukkan ID Buku yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    Buku bukuHapus = null;

                    for (Buku b : daftarBuku) {
                        if (b.idBuku.equalsIgnoreCase(idHapus)) {
                            bukuHapus = b;
                            break;
                        }
                    }

                    if (bukuHapus != null) {
                        daftarBuku.remove(bukuHapus); // HANYA BUTUH 1 KALI REMOVE OBJEK!
                        System.out.println(">> SUCCESS: Buku '" + bukuHapus.judul + "' berhasil dihapus!");
                    } else {
                        System.out.println(">> ERROR: ID Buku tidak ditemukan!");
                    }
                    break;

                case 6:
                    berjalan = false;
                    System.out.println("\nSesi Pertemuan 2 Selesai. Jangan lupa Commit & Push ke GitHub!");
                    break;

                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}