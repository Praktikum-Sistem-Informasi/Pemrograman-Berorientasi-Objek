// ===========================================================
// Topik: Access Modifier & Encapsulation
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {
    // 1. ATRIBUT DIUBAH MENJADI PRIVATE (ENKAPSULASI)
    // Pihak luar kelas tidak bisa langsung mengakses atau mengubah variabel ini.
    private String idBuku;
    private String judul;
    private String penulis;
    private int stok;

    // 2. CONSTRUCTOR
    public Buku(String idBuku, String judul, String penulis, int stok) {
        this.idBuku = idBuku;
        setJudul(judul);   // Gunakan setter agar ikut tervalidasi saat objek dibuat
        this.penulis = penulis;
        setStok(stok);     // Gunakan setter agar stok awal tidak boleh minus
    }

    // =========================================================================
    // GETTER AND SETTER (PINTU AKSES TERKONTROL)
    // =========================================================================

    // Getter & Setter untuk ID Buku
    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    // Getter & Setter untuk Judul (Dengan Validasi)
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        // VALIDASI: Judul tidak boleh kosong atau hanya berisi spasi
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        } else {
            System.out.println(">> ERROR VALIDASI: Judul buku tidak boleh kosong! Set ke 'Tanpa Judul'.");
            this.judul = "Tanpa Judul";
        }
    }

    // Getter & Setter untuk Penulis
    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // Getter & Setter untuk Stok (Dengan Validasi Ketat)
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        // VALIDASI: Stok tidak boleh kurang dari 0
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println(">> ERROR VALIDASI: Stok tidak boleh negatif (" + stok + ")! Stok di-set ke 0.");
            this.stok = 0;
        }
    }

    // Method Perilaku Objek
    public void tampilkanInfo() {
        System.out.printf("%-6s | %-25s | %-20s | %-5d\n", 
                idBuku, judul, penulis, stok);
    }
}