![Header](../assets/Header.png)

# Topik 7 - Polymorphism

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep Polimorfisme ("Satu Nama, Banyak Bentuk") dalam PBO.
2. ✅ Membedakan *Compile-time Polymorphism* (*Method Overloading*) dan *Runtime Polymorphism* (*Method Overriding*).
3. ✅ Mengimplementasikan anotasi `@Override` untuk mengubah perilaku *method* kelas induk pada kelas anak.
4. ✅ Mengatur eksekusi *method* secara dinamis (*Dynamic Method Dispatch*) melalui variabel referensi kelas induk.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat 3 kata kunci utama yang wajib Anda pahami fungsi dan dampaknya:

* **`@Override`**          : Anotasi penanda bahwa *method* di kelas anak mendefinisikan ulang *method* dari kelas induk.
* **Method Overloading** : Beberapa *method* dengan nama sama dalam **satu kelas**, namun memiliki **parameter yang berbeda** (*Compile-time Polymorphism*).
* **Method Overriding**  : *Method* di kelas anak yang memiliki **nama, parameter, dan return type yang persis sama** dengan kelas induk (*Runtime Polymorphism*).

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-5`**

| File | Deskripsi |
| :--- | :--- |
| `Buku.java` | *Superclass* dengan *method* `tampilkanInfo()` dan contoh *Overloading* `pinjamBuku()` |
| `BukuCetak.java` | *Subclass 1* yang melakukan `@Override` pada *method* `tampilkanInfo()` |
| `EBook.java` | *Subclass 2* yang melakukan `@Override` pada *method* `tampilkanInfo()` |
| `MainApp.java` | Kelas utama interaktif menu CRUD yang membuktikan *Dynamic Polymorphism* |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Inheritance* (`extends`, `super`, `protected`) dari Pertemuan 4.

---

## 🚀 PART 1: Pemahaman Konsep

### 1. Perbedaan Overloading vs Overriding

| Pembeda | Method Overloading | Method Overriding |
| :--- | :--- | :--- |
| **Lokasi** | Dalam 1 kelas yang sama | Terjadi antar kelas induk dan kelas anak (*Inheritance*) |
| **Parameter** | WAJIB Berbeda (jumlah / tipe data / urutan) | WAJIB Sama persis |
| **Waktu Eksekusi** | *Compile-time* (*Static Binding*) | *Runtime* (*Dynamic Binding*) |
| **Anotasi** | Tidak ada | Dianjurkan memakai `@Override` |

---

## 💻 PART 2: Live Coding 

### Step 1: Menambahkan Overriding & Overloading (`src/model/Buku.java`)

```java
package model;

public class Buku {
    protected String idBuku;
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    public Buku(String idBuku, String judul, String penulis, int tahunTerbit) {
        this.idBuku = idBuku;
        setJudul(judul);
        setPenulis(penulis);
        setTahunTerbit(tahunTerbit);
    }

    public String getIdBuku() { return idBuku; }
    public void setIdBuku(String idBuku) {
        if (idBuku != null && !idBuku.trim().isEmpty()) {
            this.idBuku = idBuku;
        } else {
            System.out.println(">> ERROR: ID buku tidak boleh kosong!");
        }
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        } else {
            System.out.println(">> ERROR: Judul tidak boleh kosong!");
        }
    }

    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) {
        if (penulis != null && !penulis.trim().isEmpty()) {
            this.penulis = penulis;
        } else {
            System.out.println(">> ERROR: Penulis tidak boleh kosong!");
        }
    }

    public int getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit >= 1900 && tahunTerbit <= 2026) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println(">> ERROR: Tahun terbit harus antara 1900 dan 2026!");
        }
    }

    // Dynamic Polymorphism: Method ini akan di-override oleh Subclass
    public void tampilkanInfo() {
        System.out.println("ID Buku      : " + idBuku);
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }

    // Static Polymorphism (Overloading 1): Tanpa parameter
    public void pinjamBuku() {
        System.out.println(">> Buku '" + judul + "' berhasil dipinjam untuk 7 hari.");
    }

    // Static Polymorphism (Overloading 2): Dengan parameter jumlahHari
    public void pinjamBuku(int jumlahHari) {
        System.out.println(">> Buku '" + judul + "' berhasil dipinjam khusus selama " + jumlahHari + " hari.");
    }

    public final void cetakStatusAset() {
        System.out.println("Status Aset  : Resmi Terdaftar di Perpustakaan");
    }
}

```

---

### Step 2: Implementasi Overriding di Subclass 1 (`src/model/BukuCetak.java`)

```java
package model;

// BukuCetak IS-A Buku
public class BukuCetak extends Buku {
    private int jumlahHalaman;
    private String lokasiRak;

    public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit, int jumlahHalaman, String lokasiRak) {
        super(idBuku, judul, penulis, tahunTerbit);
        setJumlahHalaman(jumlahHalaman);
        setLokasiRak(lokasiRak);
    }

    public int getJumlahHalaman() { return jumlahHalaman; }
    public void setJumlahHalaman(int jumlahHalaman) {
        if (jumlahHalaman > 0) {
            this.jumlahHalaman = jumlahHalaman;
        } else {
            System.out.println(">> ERROR: Jumlah halaman harus lebih dari 0!");
            this.jumlahHalaman = 1;
        }
    }

    public String getLokasiRak() { return lokasiRak; }
    public void setLokasiRak(String lokasiRak) {
        if (lokasiRak != null && !lokasiRak.trim().isEmpty()) {
            this.lokasiRak = lokasiRak;
        } else {
            System.out.println(">> ERROR: Lokasi rak tidak boleh kosong!");
        }
    }

    // Dynamic Polymorphism (Method Overriding)
    @Override
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: BUKU CETAK]");
        super.tampilkanInfo(); // Memanggil method dasar dari Superclass
        System.out.println("Jml Halaman  : " + jumlahHalaman + " hlm");
        System.out.println("Lokasi Rak   : " + lokasiRak);
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }
}

```

---

### Step 3: Implementasi Overriding di Subclass 2 (`src/model/EBook.java`)

```java
package model;

// EBook IS-A Buku
public class EBook extends Buku {
    private double ukuranFileMB;
    private String formatFile;

    public EBook(String idBuku, String judul, String penulis, int tahunTerbit, double ukuranFileMB, String formatFile) {
        super(idBuku, judul, penulis, tahunTerbit);
        setUkuranFileMB(ukuranFileMB);
        setFormatFile(formatFile);
    }

    public double getUkuranFileMB() { return ukuranFileMB; }
    public void setUkuranFileMB(double ukuranFileMB) {
        if (ukuranFileMB > 0) {
            this.ukuranFileMB = ukuranFileMB;
        } else {
            System.out.println(">> ERROR: Ukuran file harus lebih dari 0 MB!");
            this.ukuranFileMB = 1.0;
        }
    }

    public String getFormatFile() { return formatFile; }
    public void setFormatFile(String formatFile) {
        if (formatFile != null && !formatFile.trim().isEmpty()) {
            this.formatFile = formatFile;
        } else {
            System.out.println(">> ERROR: Format file tidak boleh kosong!");
        }
    }

    // Dynamic Polymorphism (Method Overriding)
    @Override
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: E-BOOK]");
        super.tampilkanInfo(); // Memanggil method dasar dari Superclass
        System.out.println("Ukuran File  : " + ukuranFileMB + " MB");
        System.out.println("Format File  : " + formatFile);
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }
}

```

---

### Step 4: Menjalankan Kelas Utama (`src/main/MainApp.java`)

```java
package main;

import model.Buku;
import model.BukuCetak;
import model.EBook;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        // Polymorphic Collection: Tipe referensi Superclass (Buku) menampung berbagai Subclass
        ArrayList<Buku> daftarBuku = new ArrayList<>();

        // Seed Data Awal
        daftarBuku.add(new BukuCetak("BC001", "Pemrograman Java", "James Gosling", 2023, 450, "Rak A1"));
        daftarBuku.add(new EBook("EB001", "Struktur Data Java", "Ada Lovelace", 2024, 12.5, "PDF"));

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {

            System.out.println("\n==========================================");
            System.out.println("    SISTEM PERPUSTAKAAN (POLYMORPHISM)    ");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Baru (Buku Cetak / E-Book)");
            System.out.println("3. Cari Buku");
            System.out.println("4. Simulasi Pinjam Buku (Overloading Demo)");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Keluar");
            System.out.println("==========================================");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                // ==========================================
                // 1. TAMPILKAN SEMUA BUKU (DYNAMIC POLYMORPHISM)
                // ==========================================
                case 1:
                    System.out.println("\n=== DAFTAR KOLEKSI BUKU ===");

                    if (daftarBuku.isEmpty()) {
                        System.out.println("Belum ada data buku.");
                    } else {
                        for (Buku b : daftarBuku) {
                            // PEMBUKTIAN POLYMORPHISM: Pemanggilan method otomatis menyesuaikan bentuk objeknya!
                            b.tampilkanInfo();
                        }
                    }
                    break;

                // ==========================================
                // 2. TAMBAH BUKU
                // ==========================================
                case 2:
                    System.out.println("\n=== TAMBAH BUKU BARU ===");
                    System.out.println("1. Buku Cetak (Fisik)");
                    System.out.println("2. E-Book (Digital)");
                    System.out.print("Pilih jenis buku (1-2): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan ID Buku      : ");
                    String id = scanner.nextLine();

                    System.out.print("Masukkan Judul Buku   : ");
                    String judul = scanner.nextLine();

                    System.out.print("Masukkan Nama Penulis : ");
                    String penulis = scanner.nextLine();

                    System.out.print("Masukkan Tahun Terbit : ");
                    int tahunTerbit = scanner.nextInt();

                    if (jenis == 1) {
                        System.out.print("Masukkan Jml Halaman  : ");
                        int hal = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Lokasi Rak   : ");
                        String rak = scanner.nextLine();

                        daftarBuku.add(new BukuCetak(id, judul, penulis, tahunTerbit, hal, rak));
                        System.out.println(">> Buku Cetak berhasil ditambahkan!");

                    } else if (jenis == 2) {
                        System.out.print("Masukkan Ukuran (MB)  : ");
                        double size = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Masukkan Format File  : ");
                        String format = scanner.nextLine();

                        daftarBuku.add(new EBook(id, judul, penulis, tahunTerbit, size, format));
                        System.out.println(">> E-Book berhasil ditambahkan!");

                    } else {
                        System.out.println(">> Jenis buku tidak valid!");
                    }
                    break;

                // ==========================================
                // 3. CARI BUKU (DYNAMIC POLYMORPHISM)
                // ==========================================
                case 3:
                    System.out.println("\n=== CARI BUKU ===");
                    System.out.print("Masukkan kata kunci judul: ");
                    String kataKunci = scanner.nextLine();

                    boolean ditemukan = false;

                    for (Buku b : daftarBuku) {
                        if (b.getJudul().toLowerCase().contains(kataKunci.toLowerCase())) {
                            // Polimorfisme secara otomatis memanggil override method milik subclass
                            b.tampilkanInfo();
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                // ==========================================
                // 4. SIMULASI PINJAM BUKU (STATIC POLYMORPHISM / OVERLOADING)
                // ==========================================
                case 4:
                    System.out.println("\n=== SIMULASI PINJAM BUKU (DEMO OVERLOADING) ===");
                    System.out.print("Masukkan ID Buku: ");
                    String idPinjam = scanner.nextLine();

                    Buku bukuPinjam = null;
                    for (Buku b : daftarBuku) {
                        if (b.getIdBuku().equalsIgnoreCase(idPinjam)) {
                            bukuPinjam = b;
                            break;
                        }
                    }

                    if (bukuPinjam != null) {
                        System.out.println("1. Pinjam Standar (7 Hari)");
                        System.out.println("2. Pinjam Kustom (Tentukan Hari)");
                        System.out.print("Pilih Opsi (1-2): ");
                        int opsiPinjam = scanner.nextInt();

                        if (opsiPinjam == 1) {
                            // Memanggil Overloading 1 (Tanpa Parameter)
                            bukuPinjam.pinjamBuku();
                        } else if (opsiPinjam == 2) {
                            System.out.print("Masukkan Durasi Pinjam (Hari): ");
                            int durasi = scanner.nextInt();
                            // Memanggil Overloading 2 (Dengan Parameter int)
                            bukuPinjam.pinjamBuku(durasi);
                        } else {
                            System.out.println("Opsi tidak valid.");
                        }
                    } else {
                        System.out.println("ID Buku tidak ditemukan!");
                    }
                    break;

                // ==========================================
                // 5. HAPUS BUKU
                // ==========================================
                case 5:
                    System.out.println("\n=== HAPUS BUKU ===");
                    System.out.print("Masukkan ID Buku yang akan dihapus: ");
                    String idHapus = scanner.nextLine();

                    Buku bukuHapus = null;

                    for (Buku b : daftarBuku) {
                        if (b.getIdBuku().equalsIgnoreCase(idHapus)) {
                            bukuHapus = b;
                            break;
                        }
                    }

                    if (bukuHapus != null) {
                        daftarBuku.remove(bukuHapus);
                        System.out.println("Buku '" + bukuHapus.getJudul() + "' berhasil dihapus!");
                    } else {
                        System.out.println("ID Buku tidak ditemukan!");
                    }
                    break;

                // ==========================================
                // 6. KELUAR
                // ==========================================
                case 6:
                    berjalan = false;
                    System.out.println("\nProgram selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }
}

```

---

## ⚡ PART 3: EKSPERIMEN ERROR

### 🎯 Eksperimen 1: Mengubah Signature Method pada `@Override`

**Tindakan:** Ubah nama method pada `BukuCetak.java` menjadi `public void tampilkanInfo(String judul)` sambil mempertahankan anotasi `@Override`.

```java
@Override
public void tampilkanInfo(String judul) { // Ditambah parameter
    // ...
}

```

* **Hasil:** Error Kompilasi (`method does not override or implement a method from a supertype`).
* **Pelajaran:** Method overriding mensyaratkan nama dan parameter yang **sama persis** dengan method di Superclass.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `method does not override...` | Parameter atau nama method bertanda `@Override` tidak cocok dengan method Superclass. | Pastikan tipe parameter, nama method, dan return type persis sama dengan kelas induk. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Apakah anotasi `@Override` wajib ditulis?**

> **A:** Secara sintaks Java tidak wajib, namun **sangat disarankan**. Anotasi `@Override` berfungsi sebagai pengecek otomatis saat kompilasi untuk memastikan bahwa method tersebut benar-benar meng-override method milik kelas induk.

**Q: Bisakah kita meng-override method bertipe `private` atau `final`?**

> **A:** Tidak bisa. Method `private` tertutup bagi subclass, sedangkan method `final` memang dirancang khusus agar perilakunya tidak boleh diubah oleh subclass mana pun.

---

## Daftar Referensi

[1] W3Schools, "Java Polymorphism". Tersedia di: [tautan](https://www.google.com/search?q=https://www.w3schools.com/java/java_polymorphism.asp)

[2] Petani Kode, "Belajar Java OOP: Memahami Konsep Polimorfisme". Tersedia di: [tautan](https://www.google.com/search?q=https://www.petanikode.com/java-oop-polimorfisme/)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Tambahkan *Method Overloading* ketiga pada class **`Buku`**, yaitu `pinjamBuku(int jumlahHari, String namaPeminjam)`.
2. Buat class turunan ketiga dari **`Buku`**, misal **`BukuAudio`**, lalu *override* method `tampilkanInfo()` untuk menampilkan atribut khasnya (`durasiMenit` dan `narator`).
