//========================================
// Topik: Java Collection
//========================================

public class ContohArray {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("     CONTOH 1: ARRAY KONVENSIONAL         ");
        System.out.println("==========================================");

        // 1. Deklarasi Array String dengan ukuran TETAP (3 slot)
        String[] daftarBuku = new String[3];

        // 2. Mengisi data ke dalam Array berdasarkan Indeks
        daftarBuku[0] = "Pemrograman Java";
        daftarBuku[1] = "Struktur Data";
        daftarBuku[2] = "Basis Data";

        // *CATATAN: Jika kita coba tambah data ke-4 di bawah ini, program akan ERROR
        // (ArrayIndexOutOfBoundsException) karena ukurannya sudah dikunci hanya 3!
        // daftarBuku[3] = "Jaringan Komputer"; 

        // 3. Menampilkan jumlah slot Array (.length)
        System.out.println("Kapasitas/Ukuran Array : " + daftarBuku.length);
        System.out.println("------------------------------------------");

        // 4. Menampilkan semua isi Array menggunakan Perulangan (For Loop)
        System.out.println("Daftar Buku di Array:");
        for (int i = 0; i < daftarBuku.length; i++) {
            System.out.println("Indeks ke-" + i + " : " + daftarBuku[i]);
        }
    }
}