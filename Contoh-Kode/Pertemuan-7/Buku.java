// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {
    private String idKoleksi;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int stok;

    public Buku() {
    }

    public Buku(String idKoleksi, String judul, String penulis, int tahunTerbit, int stok) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    public String getIdKoleksi() {
        return idKoleksi;
    }
    public void setIdKoleksi(String idKoleksi) {
        this.idKoleksi = idKoleksi;
    }

    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }
    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d) | Stok: %d",
                idKoleksi, judul, penulis, tahunTerbit, stok);
    }
    
}