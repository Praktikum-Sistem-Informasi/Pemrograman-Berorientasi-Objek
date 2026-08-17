// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/view/BukuView.java
// ===========================================================

package view;

import controller.BukuController;
import model.Buku;

import java.util.List;
import java.util.Scanner;

public class BukuView {

    private BukuController controller = new BukuController();
    private Scanner scanner = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\n=== MENU PERPUSTAKAAN (db_perpustakaan) ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Cari Buku berdasarkan ID");
            System.out.println("4. Update Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1 -> tambahBuku();
                case 2 -> lihatSemuaBuku();
                case 3 -> cariBuku();
                case 4 -> updateBuku();
                case 5 -> hapusBuku();
                case 0 -> System.out.println("Program selesai. Sampai jumpa!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    private void tambahBuku() {
        System.out.print("ID Koleksi   : ");
        String id = scanner.nextLine();
        System.out.print("Judul        : ");
        String judul = scanner.nextLine();
        System.out.print("Penulis      : ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit : ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok         : ");
        int stok = Integer.parseInt(scanner.nextLine());

        boolean berhasil = controller.tambahBuku(id, judul, penulis, tahun, stok);
        System.out.println(berhasil ? "Buku berhasil ditambahkan!" : "Gagal menambahkan buku.");
    }

    private void lihatSemuaBuku() {
        List<Buku> daftarBuku = controller.getSemuaBuku();
        System.out.println("\n--- DAFTAR SELURUH BUKU ---");
        if (daftarBuku.isEmpty()) {
            System.out.println("(Belum ada data buku)");
        }
        for (Buku b : daftarBuku) {
            System.out.println(b);
        }
    }

    private void cariBuku() {
        System.out.print("Masukkan ID Koleksi: ");
        String id = scanner.nextLine();
        Buku b = controller.cariBuku(id);
        System.out.println(b != null ? b : "Buku dengan ID tersebut tidak ditemukan.");
    }

    private void updateBuku() {
        System.out.print("ID Koleksi yang akan diupdate : ");
        String id = scanner.nextLine();
        System.out.print("Judul baru        : ");
        String judul = scanner.nextLine();
        System.out.print("Penulis baru      : ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit baru : ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok baru         : ");
        int stok = Integer.parseInt(scanner.nextLine());

        boolean berhasil = controller.updateBuku(id, judul, penulis, tahun, stok);
        System.out.println(berhasil ? "Buku berhasil diperbarui!" : "Gagal memperbarui buku.");
    }

    private void hapusBuku() {
        System.out.print("ID Koleksi yang akan dihapus: ");
        String id = scanner.nextLine();
        boolean berhasil = controller.hapusBuku(id);
        System.out.println(berhasil ? "Buku berhasil dihapus!" : "Gagal menghapus buku.");
    }
}