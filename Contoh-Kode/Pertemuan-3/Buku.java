// ===========================================================
// Topik: Access Modifier & Encapsulation
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {
    private String idBuku;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int stok;

    // Constructor
    public Buku(String idBuku, String judul, String penulis, int tahunTerbit, int stok) {
        this.idBuku = idBuku;
        setJudul(judul);
        setPenulis(penulis);
        setTahunTerbit(tahunTerbit);
        setStok(stok);
    }

    // Getter untuk ID Buku
    public String getIdBuku() {
        return idBuku;
    }

    // Setter untuk ID Buku
    public void setIdBuku(String idBuku) {
        if (idBuku != null && !idBuku.trim().isEmpty()) {
            this.idBuku = idBuku;
        } else {
            System.out.println("ID buku tidak boleh kosong!");
        }
    }

    // Getter untuk judul
    public String getJudul() {
        return judul;
    }

    // Setter untuk judul
    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        } else {
            System.out.println("Judul tidak boleh kosong!");
        }
    }

    // Getter untuk penulis
    public String getPenulis() {
        return penulis;
    }

    // Setter untuk penulis
    public void setPenulis(String penulis) {
        if (penulis != null && !penulis.trim().isEmpty()) {
            this.penulis = penulis;
        } else {
            System.out.println("Penulis tidak boleh kosong!");
        }
    }

    // Getter untuk tahun terbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Setter untuk tahun terbit
    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit >= 1900 && tahunTerbit <= 2026) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println(
                "Tahun terbit harus berada di antara 1900 dan 2026!"
            );
        }
    }

    // Getter untuk stok
    public int getStok() {
        return stok;
    }

    // Setter untuk stok
    public void setStok(int stok) {
        if (stok >= 20 && stok <= 100) {
            this.stok = stok;
        } else {
            System.out.println(
                "Stok harus berada di antara 20 dan 100!"
            );
        }
    }

    // Method untuk menampilkan data menggunakan Getter
    public void tampilkanData() {
        System.out.println("ID buku       : " + getIdBuku());
        System.out.println("Judul buku    : " + getJudul());
        System.out.println("Penulis       : " + getPenulis());
        System.out.println("Tahun terbit  : " + getTahunTerbit());
        System.out.println("Stok          : " + getStok());
    }

    // Method untuk menampilkan informasi buku
    public void tampilkanInfo() {
        System.out.println("-------------------------------");
        System.out.println("ID Buku      : " + this.idBuku);
        System.out.println("Judul        : " + this.judul);
        System.out.println("Penulis      : " + this.penulis);
        System.out.println("Tahun Terbit : " + this.tahunTerbit);
        System.out.println("Stok         : " + this.stok);
        System.out.println("-------------------------------");
    }
}
}
