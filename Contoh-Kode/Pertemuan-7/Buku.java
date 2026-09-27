// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {

    protected String idBuku;
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;
    protected int stok;

    public Buku() {
    }

    public Buku(String idBuku, String judul, String penulis, int tahunTerbit, int stok) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    public String getIdBuku(){
       return idBuku;
    }

    public void setIdBuku(String idBuku){
        this.idBuku = idBuku;
    }

    public String getJudul(){
        return judul;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }

    public String getPenulis(){
        return penulis;
    }

    public void setPenulis(String penulis){
        this.penulis = penulis;
    }

    public int getTahunTerbit(){
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit){
        this.tahunTerbit = tahunTerbit;
    }

    public int getStok(){
        return stok;
    }

    public void setStok(int stok){
        this.stok = stok;
    }
}
