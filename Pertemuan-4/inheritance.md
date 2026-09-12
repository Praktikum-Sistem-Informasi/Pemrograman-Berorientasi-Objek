![Header](../assets/Header.png)

# Topik 6 - Inheritance

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep pewarisan (*Inheritance*), hirarki kelas, dan hubungan *IS-A* dalam PBO.
2. ✅ Mengimplementasikan kata kunci `extends` untuk membina kelas induk (*Superclass*) dan kelas anak (*Subclass*).
3. ✅ Menggunakan kata kunci `super` untuk memanggil konstruktor, method, dan atribut milik kelas induk.
4. ✅ Memahami fungsi dan dampak kata kunci `final` pada variabel, method, dan kelas.
5. ✅ Menerapkan hak akses `protected` untuk pembagian atribut pada kelas turunan.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat 3 kata kunci utama yang wajib Anda pahami fungsi dan dampaknya:

* **`extends`** : Kata kunci untuk membina hubungan pewarisan antara kelas anak (*Subclass*) dan kelas induk (*Superclass*).
* **`super`**   : Variabel referensi khusus untuk memanggil *constructor* (`super()`) atau mengakses method/atribut milik kelas induk (`super.method()`).
* **`final`**   : Pengunci sifat absolut. Digunakan agar nilai variabel tidak bisa diubah, method tidak bisa di-*override*, atau kelas tidak bisa diwarisi.

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-4`**

| File | Deskripsi |
| :--- | :--- |
| `Buku.java` | *Superclass* (Kelas Induk) penyedia atribut dan method umum |
| `BukuCetak.java` | *Subclass 1* turunan dari `Buku` untuk media fisik |
| `EBook.java` | *Subclass 2* turunan dari `Buku` untuk media digital |
| `MainApp.java` | Kelas utama interaktif dengan menu CRUD berbasis *Inheritance* |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Access Modifier* (`private`, `public`, `protected`) dan *Encapsulation* dari Pertemuan 3.

---

## 🚀 PART 1: Pemahaman Konsep

```text
          ┌─────────────────────────┐
          │     Buku (Superclass)   │  ← Induk (Atribut Umum: idBuku, judul, penulis, tahunTerbit)
          └────────────┬────────────┘
                       │
         ┌─────────────┴─────────────┐
         │ (extends)                 │ (extends)
┌────────┴────────┐         ┌────────┴────────┐
│BukuCetak(Subclass)│         │ EBook(Subclass) │  ← Anak (Atribut Spesifik)
└─────────────────┘         └─────────────────┘

```

> 📌 **ANALOGI DUNIA NYATA:**
> * **Buku** adalah cetakan umum. **BukuCetak** *IS-A* (adalah sebuah) **Buku**. **EBook** *IS-A* (adalah sebuah) **Buku**.
> * BukuCetak dan EBook tidak perlu membuat ulang atribut `idBuku`, `judul`, `penulis`, atau `tahunTerbit` dari nol. Mereka cukup **mewarisi** sifat dari kelas `Buku`.
> 
> 

---

### 1. Apa itu Inheritance (Pewarisan)?

*Inheritance* adalah mekanisme di mana sebuah kelas (*Subclass*) menerima/mewarisi atribut (*field*) dan perilaku (*method*) dari kelas lain (*Superclass*).

* **Hubungan *IS-A*:** Merupakan syarat mutlak pewarisan. Contoh: `BukuCetak` *IS-A* `Buku` (Buku Cetak adalah sebuah Buku) atau `Mobil` *IS-A* `Kendaraan`.
* **Single Inheritance di Java:** Java **tidak mendukung** *Multiple Inheritance* menggunakan kelas biasa (satu kelas anak tidak bisa `extends` ke dua kelas induk sekaligus) untuk menghindari konflik kode (*Diamond Problem*).
* **Hak Akses `protected`:** Atribut bertipe `protected` pada kelas induk dapat diakses langsung oleh semua kelas anak (*subclass*) maupun kelas lain di package yang sama, namun tertutup bagi kelas luar di beda package.

---

### 2. Mengapa Inheritance Penting?

* **Fondasi Utama PBO:** Merupakan salah satu pilar inti PBO yang menjadi syarat wajib untuk memahami `Polymorphism` dan `Abstraction`.
* **Efisiensi Kode:** Mencegah duplikasi kode. Atribut dan method umum cukup ditulis sekali di Superclass dan langsung digunakan oleh seluruh `Subclass`.
* **Kemudahan Perawatan (Maintainability):** Jika ada perubahan logika umum, Anda cukup memperbarui kelas induknya saja tanpa perlu mengubah puluhan kelas anak satu per satu.

---

### 3. Pendalaman Kata Kunci `super`

Kata kunci `super` adalah variabel referensi yang digunakan untuk merujuk langsung ke objek dari **Kelas Induk (*Superclass*)**. Ada dua kegunaan utama `super`:

1. **`super(...)` — Memanggil Constructor Induk:**
* Digunakan di dalam *constructor subclass* untuk meneruskan data ke *constructor superclass*.
* **Aturan Mutlak:** Pemanggilan `super(...)` WAJIB diletakkan di **baris pertama** di dalam *constructor subclass*.


2. **`super.method()` atau `super.atribut` — Mengakses Anggota Induk:**
* Digunakan untuk memanggil *method* atau *atribut* milik induk yang tertutup/berbenturan nama dengan anggota di kelas anak.



---

### 4. Pendalaman Kata Kunci `final`

Kata kunci `final` digunakan untuk membatasi pewarisan dan modifikasi. `final` dapat diterapkan pada 3 tingkatan:

| Penerapan `final` | Fungsi / Dampak |
| --- | --- |
| **`final` Variable** | Nilainya menjadi konstanta (tidak dapat diubah setelah diinisialisasi). |
| **`final` Method** | Method tersebut **tidak dapat di-override** (didefinisikan ulang) oleh kelas anak. |
| **`final` Class** | Kelas tersebut **tidak dapat diwarisi** (`extends`) oleh kelas mana pun. |

```java
// Contoh Final Class (Tidak bisa diturunkan lagi)
public final class PerpustakaanPusat {
    // ...
}

// Error kompilasi jika dicoba:
// public class CabangPerpustakaan extends PerpustakaanPusat {} // ERROR!

```

---

## 💻 PART 2: Live Coding

### Step 1: Membuat Superclass (`src/model/Buku.java`)

```java
package model;

// Superclass mewariskan atribut & method umum ke subclass
public class Buku {
    // Access Modifier ubah ke protected agar bisa diakses oleh subclass
    protected String idBuku;
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    // Constructor Superclass
    public Buku(String idBuku, String judul, String penulis, int tahunTerbit) {
        this.idBuku = idBuku;
        setJudul(judul);
        setPenulis(penulis);
        setTahunTerbit(tahunTerbit);
    }

    // Getter & Setter dengan validasi Enkapsulasi
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

    // Method umum untuk menampilkan info dasar
    public void tampilkanInfo() {
        System.out.println("ID Buku      : " + idBuku);
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }

    // Final method (pembuktian kata kunci final)
    public final void cetakStatusAset() {
        System.out.println("Status Aset  : Resmi Terdaftar di Perpustakaan");
    }
}

```

---

### Step 2: Membuat Subclass 1 (`src/model/BukuCetak.java`)

```java
package model;

// BukuCetak IS-A Buku
public class BukuCetak extends Buku {
    private int jumlahHalaman;
    private String lokasiRak;

    // Constructor Subclass
    public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit, int jumlahHalaman, String lokasiRak) {
        // Pemanggilan super(...) WAJIB di baris pertama
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

    // Method spesifik memanfaatkan super.tampilkanInfo()
    public void tampilkanInfoBukuCetak() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: BUKU CETAK]");
        super.tampilkanInfo(); // Memanggil info umum dari Superclass
        System.out.println("Jml Halaman  : " + jumlahHalaman + " hlm");
        System.out.println("Lokasi Rak   : " + lokasiRak);
        cetakStatusAset();     // Memanggil final method dari Superclass
        System.out.println("------------------------------------------");
    }
}

```

---

### Step 3: Membuat Subclass 2 (`src/model/EBook.java`)

```java
package model;

// EBook IS-A Buku
public class EBook extends Buku {
    private double ukuranFileMB;
    private String formatFile;

    // Constructor Subclass
    public EBook(String idBuku, String judul, String penulis, int tahunTerbit, double ukuranFileMB, String formatFile) {
        // Pemanggilan super(...) WAJIB di baris pertama
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

    // Method spesifik memanfaatkan super.tampilkanInfo()
    public void tampilkanInfoEBook() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: E-BOOK]");
        super.tampilkanInfo(); // Memanggil info umum dari Superclass
        System.out.println("Ukuran File  : " + ukuranFileMB + " MB");
        System.out.println("Format File  : " + formatFile);
        cetakStatusAset();     // Memanggil final method dari Superclass
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

        // Polimorfisme awal: List menyimpan objek tipe superclass Buku
        ArrayList<Buku> daftarBuku = new ArrayList<>();

        // Seed Data Awal (Instansiasi Subclass 1 dan Subclass 2)
        daftarBuku.add(new BukuCetak("BC001", "Pemrograman Java", "James Gosling", 2023, 450, "Rak A1"));
        daftarBuku.add(new EBook("EB001", "Struktur Data Java", "Ada Lovelace", 2024, 12.5, "PDF"));

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {

            System.out.println("\n==========================================");
            System.out.println("     SISTEM PERPUSTAKAAN (INHERITANCE)    ");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Baru (Buku Cetak / E-Book)");
            System.out.println("3. Cari Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            System.out.println("==========================================");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                // ==========================================
                // 1. TAMPILKAN SEMUA BUKU
                // ==========================================
                case 1:
                    System.out.println("\n=== DAFTAR KOLEKSI BUKU ===");

                    if (daftarBuku.isEmpty()) {
                        System.out.println("Belum ada data buku.");
                    } else {
                        for (Buku b : daftarBuku) {
                            // Mengecek tipe spesifik objek menggunakan instanceof
                            if (b instanceof BukuCetak) {
                                ((BukuCetak) b).tampilkanInfoBukuCetak();
                            } else if (b instanceof EBook) {
                                ((EBook) b).tampilkanInfoEBook();
                            }
                        }
                    }
                    break;

                // ==========================================
                // 2. TAMBAH BUKU (BERDASARKAN SUBCLASS)
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
                // 3. CARI BUKU
                // ==========================================
                case 3:
                    System.out.println("\n=== CARI BUKU ===");
                    System.out.print("Masukkan kata kunci judul: ");
                    String kataKunci = scanner.nextLine();

                    boolean ditemukan = false;

                    for (Buku b : daftarBuku) {
                        // Memanfaatkan getJudul() yang diwarisi dari Superclass Buku
                        if (b.getJudul().toLowerCase().contains(kataKunci.toLowerCase())) {
                            if (b instanceof BukuCetak) {
                                ((BukuCetak) b).tampilkanInfoBukuCetak();
                            } else if (b instanceof EBook) {
                                ((EBook) b).tampilkanInfoEBook();
                            }
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Buku dengan kata kunci tersebut tidak ditemukan.");
                    }
                    break;

                // ==========================================
                // 4. HAPUS BUKU
                // ==========================================
                case 4:
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
                // 5. KELUAR
                // ==========================================
                case 5:
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

### 🎯 Eksperimen 1: Memindahkan Posisi `super()`

**Tindakan:** Pada `BukuCetak.java`, pindahkan baris `super(idBuku, judul, penulis, tahunTerbit);` ke bawah setelah `this.jumlahHalaman = jumlahHalaman;`.

```java
public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit, int jumlahHalaman, String lokasiRak) {
    this.jumlahHalaman = jumlahHalaman;
    super(idBuku, judul, penulis, tahunTerbit); // Pindah ke baris kedua
    this.lokasiRak = lokasiRak;
}

```

* **Hasil:** Error Kompilasi (`call to super must be first statement in constructor`).
* **Pelajaran:** Induk harus diinisialisasi terlebih dahulu sebelum kelas anak dikonstruksi.

---

### 🎯 Eksperimen 2: Mencoba Meng-extends Final Class

**Tindakan:** Buat `public final class Ensiklopedia` lalu buat `public class Komik extends Ensiklopedia`.

* **Hasil:** Error Kompilasi (`cannot inherit from final model.Ensiklopedia`).
* **Pelajaran:** Class bertipe `final` bersifat absolut dan tidak bisa memiliki subclass.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `call to super must be first statement...` | Pemanggilan `super()` berada di bawah baris perintah lain pada *constructor*. | Pindahkan `super(...)` ke **baris paling atas** di dalam *constructor subclass*. |
| `cannot inherit from final ...` | Mencoba melakukan `extends` ke kelas bertipe `final`. | Hapus kata kunci `final` dari kelas induk jika kelas tersebut memang dirancang untuk diturunkan. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Kapan sebaiknya saya memakai `protected` dibanding `private` pada kelas induk?**

> **A:** Gunakan `protected` jika Anda ingin variabel/method tersebut bisa langsung dibaca dan diubah oleh *subclass* (kelas anak) di package mana pun, tetapi tetap tertutup untuk kelas umum luar. Jika variabel tersebut sensitif dan butuh validasi ketat, tetap gunakan `private` lalu sediakan method `getter/setter`.

**Q: Mengapa panggilan `super(...)` di konstruktor anak wajib berada di baris pertama?**

> **A:** Karena secara hirarki, wujud cetakan induk (*Superclass*) harus terbentuk utuh di memori komputer terlebih dahulu sebelum kelas anak (*Subclass*) menambahkan spesifikasi atribut/method baru di atasnya.

**Q: Apakah satu kelas anak di Java bisa menggunakan `extends` ke dua kelas induk sekaligus (Multiple Inheritance)?**

> **A:** Tidak bisa. Java tidak mendukung *Multiple Inheritance* menggunakan kelas biasa demi menghindari konflik kode (*Diamond Problem*). Satu kelas anak hanya boleh meng-`extends` tepat **satu** kelas induk.

**Q: Apa akibatnya jika kita menambahkan kata kunci `final` pada suatu method di Superclass?**

> **A:** Method bertipe `final` dapat diwarisi dan dipanggil oleh kelas anak, tetapi **tidak dapat di-override** (didefinisikan ulang) oleh kelas anak tersebut.

---

## Daftar Referensi

[1] W3Schools, "Java Inheritance (Subclass and Superclass)". Tersedia di: [tautan](https://www.w3schools.com/java/java_inheritance.asp)

[2] Petani Kode, "Belajar Java OOP: Memahami Konsep Hak Waris (Inheritance)". Tersedia di: [tautan](https://www.petanikode.com/java-oop-inheritance/)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Buat program sesuai instruksi berikut:
a) Buat class **`Buku`** sebagai superclass yang menyimpan atribut `idBuku`, `judul`, `penulis`, dan `tahunTerbit`.
b) Buat subclass **`BukuAudio`** yang mewarisi **`Buku`**, lalu tambahkan atribut spesifik `durasiMenit` dan `narator`.
c) Buat objek **`BukuAudio`** pada `main()` dan tampilkan seluruh data bukunya.
2. Buat program sesuai instruksi berikut:
a) Buat final class **`JurnalIlmiah`** yang berisi method `tampilkanLisensi()`.
b) Coba buat subclass **`JurnalInternal`** yang mencoba `extends JurnalIlmiah`.
c) Amati dan jelaskan mengapa class **`JurnalIlmiah`** tidak bisa diwarisi.
3. Buat program sesuai instruksi berikut:
a) Buat class **`AnggotaPerpustakaan`** dengan constructor yang menerima `String nama`, serta method `sapaan()` untuk menampilkan nama anggota.
b) Buat subclass **`Mahasiswa`** dengan constructor yang memanggil `super(nama)`, lalu tambahkan atribut `nim` dan method `pinjamBuku()`.
c) Buat objek **`Mahasiswa`** di `main()` dan jalankan semua methodnya.
