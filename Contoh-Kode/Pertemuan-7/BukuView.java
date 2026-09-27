// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/view/BukuView.java
// ===========================================================

package view;
import java.util.List;
import java.util.Scanner;
import model.Buku;

public class BukuView {

    Scanner input = new Scanner(System.in);

    //Tampilkan Menu
    public int tampilkanMenu() {
        System.out.println("\n== MENU PERPUSTAKAAN ==");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tampil Buku");
        System.out.println("3. Ubah Buku");
        System.out.println("4. Hapus Buku");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");

        int pilihan = input.nextInt();
        input.nextLine();
        return pilihan;
    }

    public void tampilkanData(List<Buku> listBuku) {
        System.out.println("\n--- DATA BUKU ---");
        for (Buku b : listBuku) {
            System.out.println(b.getIdBuku() + " | " + b.getJudul() + " | " + b.getPenulis() + " | " + b.getTahunTerbit() + " | Stok: " + b.getStok());
        }
    }

    public Buku inputDataBuku() {
        System.out.print("ID Buku : ");
        String id = input.nextLine();
        System.out.print("Judul   : ");
        String judul = input.nextLine();
        System.out.print("Penulis : ");
        String penulis = input.nextLine();
        System.out.print("Tahun   : ");
        int tahun = input.nextInt();
        System.out.print("Stok    : ");
        int stok = input.nextInt();
        input.nextLine(); // Bersihkan enter lagi

        return new Buku(id, judul, penulis, tahun, stok);
    }

    public String inputId() {
        System.out.print("Masukkan ID Buku: ");
        return input.nextLine();
    }
}
