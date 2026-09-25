package view;

import controller.BukuController;
import model.Buku;
import model.BukuCetak;
import model.EBook;
import java.util.Scanner;

public class BukuView {
    private BukuController controller;
    private Scanner scanner;

    public BukuView(BukuController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void renderMenu() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM PERPUSTAKAAN (P6: MVC & ABSTRAKSI)");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Cetak Baru");
            System.out.println("3. Tambah EBook Baru");
            System.out.println("4. Pinjam Buku (Interface Pinjamable Demo)");
            System.out.println("5. Unduh EBook (Interface Unduhable Demo)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR BUKU PERPUSTAKAAN ---");
                    for (Buku b : controller.getAllBuku()) {
                        b.tampilkanInfo();
                    }
                    break;
                case 2:
                    System.out.println("\n--- TAMBAH BUKU CETAK BARU ---");
                    System.out.print("ID Buku      : "); String id = scanner.nextLine();
                    System.out.print("Judul Buku   : "); String judul = scanner.nextLine();
                    System.out.print("Penulis      : "); String penulis = scanner.nextLine();
                    System.out.print("Tahun Terbit : "); int tahun = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Jml Halaman  : "); int halaman = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Lokasi Rak   : "); String rak = scanner.nextLine();

                    controller.tambahBuku(new BukuCetak(id, judul, penulis, tahun, halaman, rak));
                    System.out.println(">> SUCCESS: Buku cetak berhasil ditambahkan!");
                    break;
                case 3:
                    System.out.println("\n--- TAMBAH EBOOK BARU ---");
                    System.out.print("ID Buku      : "); String idE = scanner.nextLine();
                    System.out.print("Judul Buku   : "); String judulE = scanner.nextLine();
                    System.out.print("Penulis      : "); String penulisE = scanner.nextLine();
                    System.out.print("Tahun Terbit : "); int tahunE = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Ukuran (MB)  : "); double ukuran = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Format File  : "); String format = scanner.nextLine();

                    controller.tambahBuku(new EBook(idE, judulE, penulisE, tahunE, ukuran, format));
                    System.out.println(">> SUCCESS: EBook berhasil ditambahkan!");
                    break;
                case 4:
                    System.out.println("\n--- PINJAM BUKU ---");
                    System.out.print("Masukkan ID Buku: ");
                    String idPinjam = scanner.nextLine();
                    controller.prosesPinjamBuku(idPinjam);
                    break;
                case 5:
                    System.out.println("\n--- UNDUH EBOOK ---");
                    System.out.print("Masukkan ID Buku: ");
                    String idUnduh = scanner.nextLine();
                    controller.prosesUnduhBuku(idUnduh);
                    break;
                case 6:
                    berjalan = false;
                    System.out.println("\nSesi Selesai.");
                    break;
                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
    }
}
