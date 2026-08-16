//========================================
// Topik: Dasar Pemrograman Java
//========================================

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // =========================================================================
        // DEKLARASI DATA PERPUSTAKAAN (MENGGUNAKAN ARRAYLIST PARALEL)
        // =========================================================================
        ArrayList<String> listIdBuku = new ArrayList<>();
        ArrayList<String> listJudulBuku = new ArrayList<>();
        ArrayList<String> listPenulisBuku = new ArrayList<>();
        ArrayList<Integer> listStokBuku = new ArrayList<>();

        // -------------------------------------------------------------------------
        // DATA INITIAL (DUMMY DATA) - Memberikan contoh awal isi perpustakaan
        // -------------------------------------------------------------------------
        listIdBuku.add("B001");
        listJudulBuku.add("Pemrograman Java");
        listPenulisBuku.add("James Gosling");
        listStokBuku.add(5);

        listIdBuku.add("B002");
        listJudulBuku.add("Struktur Data");
        listPenulisBuku.add("Ada Lovelace");
        listStokBuku.add(3);

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        // Loop Utama Program
        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM MANAJEMEN PERPUSTAKAAN (P1)     ");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku (Read)");
            System.out.println("2. Tambah Buku Baru (Create)");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Stok Buku (Update)");
            System.out.println("5. Hapus Buku (Delete)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer input

            switch (pilihan) {
                case 1:
                    // -------------------------------------------------------------
                    // 1. READ (TAMPILKAN DATA BUKU)
                    // -------------------------------------------------------------
                    System.out.println("\n--- DAFTAR BUKU PERPUSTAKAAN ---");
                    if (listIdBuku.isEmpty()) {
                        System.out.println("Belum ada data buku yang terdaftar.");
                    } else {
                        System.out.printf("%-6s | %-25s | %-20s | %-5s\n", "ID", "Judul Buku", "Penulis", "Stok");
                        System.out.println("------------------------------------------------------------------");
                        for (int i = 0; i < listIdBuku.size(); i++) {
                            System.out.printf("%-6s | %-25s | %-20s | %-5d\n",
                                    listIdBuku.get(i),
                                    listJudulBuku.get(i),
                                    listPenulisBuku.get(i),
                                    listStokBuku.get(i));
                        }
                    }
                    break;

                case 2:
                    // -------------------------------------------------------------
                    // 2. CREATE (TAMBAH DATA BUKU)
                    // -------------------------------------------------------------
                    System.out.println("\n--- TAMBAH BUKU BARU ---");
                    System.out.print("Masukkan ID Buku (Contoh: B003) : ");
                    String idBaru = scanner.nextLine();
                    
                    System.out.print("Masukkan Judul Buku            : ");
                    String judulBaru = scanner.nextLine();
                    
                    System.out.print("Masukkan Nama Penulis          : ");
                    String penulisBaru = scanner.nextLine();
                    
                    System.out.print("Masukkan Jumlah Stok           : ");
                    int stokBaru = scanner.nextInt();

                    // Menambahkan data ke masing-masing ArrayList
                    listIdBuku.add(idBaru);
                    listJudulBuku.add(judulBaru);
                    listPenulisBuku.add(penulisBaru);
                    listStokBuku.add(stokBaru);

                    System.out.println(">> SUCCESS: Buku '" + judulBaru + "' berhasil ditambahkan!");
                    break;

                case 3:
                    // -------------------------------------------------------------
                    // 3. CARI BUKU (MENGGUNAKAN PERCABANGAN & PERULANGAN)
                    // -------------------------------------------------------------
                    System.out.println("\n--- CARI BUKU ---");
                    System.out.print("Masukkan Kata Kunci Judul: ");
                    String kataKunci = scanner.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < listJudulBuku.size(); i++) {
                        // Cek apakah judul mengandung kata kunci (case-insensitive)
                        if (listJudulBuku.get(i).toLowerCase().contains(kataKunci.toLowerCase())) {
                            System.out.println("Ditemukan -> [" + listIdBuku.get(i) + "] " 
                                    + listJudulBuku.get(i) + " | Penulis: " 
                                    + listPenulisBuku.get(i) + " | Stok: " + listStokBuku.get(i));
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println(">> INFO: Buku dengan kata kunci tersebut tidak ditemukan.");
                    }
                    break;

                case 4:
                    // -------------------------------------------------------------
                    // 4. UPDATE (UBAH STOK BUKU)
                    // -------------------------------------------------------------
                    System.out.println("\n--- UPDATE STOK BUKU ---");
                    System.out.print("Masukkan ID Buku yang ingin diubah stoknya: ");
                    String idUpdate = scanner.nextLine();
                    int indexUpdate = -1;

                    // Cari indeks posisi ID Buku
                    for (int i = 0; i < listIdBuku.size(); i++) {
                        if (listIdBuku.get(i).equalsIgnoreCase(idUpdate)) {
                            indexUpdate = i;
                            break;
                        }
                    }

                    if (indexUpdate != -1) {
                        System.out.println("Buku Ditemukan: " + listJudulBuku.get(indexUpdate));
                        System.out.print("Masukkan Jumlah Stok Baru: ");
                        int stokBaruUpdate = scanner.nextInt();

                        // Memperbarui nilai pada ArrayList stok
                        listStokBuku.set(indexUpdate, stokBaruUpdate);
                        System.out.println(">> SUCCESS: Stok buku berhasil diperbarui!");
                    } else {
                        System.out.println(">> ERROR: ID Buku tidak ditemukan!");
                    }
                    break;

                case 5:
                    // -------------------------------------------------------------
                    // 5. DELETE (HAPUS BUKU)
                    // -------------------------------------------------------------
                    System.out.println("\n--- HAPUS BUKU ---");
                    System.out.print("Masukkan ID Buku yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    int indexHapus = -1;

                    for (int i = 0; i < listIdBuku.size(); i++) {
                        if (listIdBuku.get(i).equalsIgnoreCase(idHapus)) {
                            indexHapus = i;
                            break;
                        }
                    }

                    if (indexHapus != -1) {
                        String judulDihapus = listJudulBuku.get(indexHapus);
                        
                        // Menghapus elemen pada indeks terkait dari SEMUA ArrayList
                        listIdBuku.remove(indexHapus);
                        listJudulBuku.remove(indexHapus);
                        listPenulisBuku.remove(indexHapus);
                        listStokBuku.remove(indexHapus);

                        System.out.println(">> SUCCESS: Buku '" + judulDihapus + "' berhasil dihapus!");
                    } else {
                        System.out.println(">> ERROR: ID Buku tidak ditemukan!");
                    }
                    break;

                case 6:
                    berjalan = false;
                    System.out.println("\nTerima kasih! Sesi praktikum Pertemuan 1 selesai.");
                    break;

                default:
                    System.out.println(">> ERROR: Pilihan menu tidak valid (1-6)!");
            }
        }

        scanner.close();
    }
}