// ===========================================================
// Topik: Inheritance (Pewarisan)
// Letakkan file ini pada src/model/EBook.java
// ===========================================================

package model;

// 'extends' artinya EBook MEWARISI seluruh atribut & method milik Buku. 
// Relasi IS-A: "EBook IS-A Buku".
public class EBook extends Buku {

    // Atribut khusus EBook
    private double ukuranFileMB;
    private String formatFile;

    // Constructor Subclass
    public EBook(String idBuku, String judul, String penulis, int tahunTerbit, double ukuranFileMB, String formatFile) {
        // 'super(...)' mengirim data ke constructor Buku (induk).
        // WAJIB menjadi baris pertama di dalam constructor subclass.
        super(idBuku, judul, penulis, tahunTerbit);

        setUkuranFileMB(ukuranFileMB);
        setFormatFile(formatFile);
    }

    // ----- Getter & Setter khusus EBook -----

    public double getUkuranFileMB() {
        return ukuranFileMB;
    }

    public void setUkuranFileMB(double ukuranFileMB) {
        if (ukuranFileMB > 0) {
            this.ukuranFileMB = ukuranFileMB;
        } else {
            System.out.println(">> ERROR: Ukuran file harus lebih dari 0!");
            this.ukuranFileMB = 0.1;
        }
    }

    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        if (formatFile != null && !formatFile.trim().isEmpty()) {
            this.formatFile = formatFile;
        } else {
            System.out.println(">> ERROR: Format file tidak boleh kosong!");
        }
    }

    // Method khusus EBook (nama berbeda dari method di Buku,
    public void tampilkanInfoEBook() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: E-BOOK]");
        // 'super.tampilkanInfo()' memanggil method milik Superclass
        super.tampilkanInfo();
        System.out.println("Ukuran File  : " + ukuranFileMB + " MB");
        System.out.println("Format File  : " + formatFile);
        // Method final dari Superclass juga tetap bisa dipanggil
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }
}