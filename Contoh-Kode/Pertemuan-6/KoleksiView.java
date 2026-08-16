// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/view/KoleksiView.java
// ===========================================================

package view;

import controller.KoleksiController;
import model.Koleksi;
import model.Buku;
import java.util.Scanner;

public class KoleksiView {
    private KoleksiController controller;
    private Scanner scanner;

    public KoleksiView(KoleksiController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void renderMenu() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM PERPUSTAKAAN (P6: MVC & ABSTRAKSI)");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Koleksi");
            System.out.println("2. Tambah Buku Baru");
            System.out.println("3. Pinjam Buku (Interface Demo)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR KOLEKSI PERPUSTAKAAN ---");
                    for (Koleksi k : controller.getAllKoleksi()) {
                        k.tampilkanInfo();
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH BUKU BARU ---");
                    System.out.print("ID Buku      : "); String id = scanner.nextLine();
                    System.out.print("Judul Buku   : "); String judul = scanner.nextLine();
                    System.out.print("Tahun Terbit : "); int tahun = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Penulis      : "); String penulis = scanner.nextLine();
                    System.out.print("Stok         : "); int stok = scanner.nextInt();

                    controller.tambahKoleksi(new Buku(id, judul, tahun, penulis, stok));
                    System.out.println(">> SUCCESS: Buku berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n--- PINJAM KOLEKSI ---");
                    System.out.print("Masukkan ID Koleksi: ");
                    String idPinjam = scanner.nextLine();
                    controller.prosesPinjamBuku(idPinjam);
                    break;

                case 4:
                    berjalan = false;
                    System.out.println("\nSesi Pertemuan 6 Selesai.");
                    break;

                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
    }
}