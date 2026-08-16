# Abstraction

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. Memahami konsep abstraksi (*Abstraction*) dalam Pemrograman Berorientasi Objek.
2. Membedakan rancangan program (*what to do*) dengan detail implementasi (*how to do*).
3. Menggunakan `abstract class` dan `abstract method` sebagai kerangka identitas umum bagi kelas turunan.
4. Menggunakan `interface` dan kata kunci `implements` sebagai kontrak kemampuan lintas objek.
5. Membuat standar atau kerangka aplikasi (kontrak) yang konsisten sebelum kode dikembangkan lebih lanjut.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

* **`abstract`** : Penanda class atau method sebagai bagian dari rancangan yang belum memiliki implementasi lengkap.
* **`abstract class`** : Kelas induk yang tidak bisa dibuat objeknya (instansiasi) secara langsung; berfungsi sebagai DNA/kerangka dasar.
* **`abstract method`** : Method tanpa isi yang memaksa (*force*) kelas turunannya untuk membuat implementasi spesifik.
* **`interface`** : Murni sebuah kontrak standar fungsionalitas; mewajibkan class yang memakainya untuk memiliki kemampuan tertentu.
* **`implements`** : Kata kunci untuk menyetujui dan menjalankan kontrak dari sebuah antarmuka (*interface*).

---

## 📂 RESOURCES (SUMBER KODE DEMO)

> 💡 **File demo tersedia di `contoh_kode/pertemuan_6/`**

| **File** | **Deskripsi** |
|---|---|
| `src/model/Pinjamable.java` | Interface (Kontrak kemampuan peminjaman) |
| `src/model/Koleksi.java` | Abstract Class (Kerangka identitas dasar bacaan) |
| `src/model/Buku.java` | Subclass dari `Koleksi`, mengimplementasikan `Pinjamable` |
| `src/model/Majalah.java` | Subclass dari `Koleksi` (Tanpa kemampuan peminjaman) |
| `src/controller/KoleksiController.java` | Logika pengelolaan data dan demonstrasi polimorfisme/interface |
| `src/view/KoleksiView.java` | Antarmuka pengguna (I/O CLI) |
| `src/main/MainApp.java` | Entry point program (Penghubung MVC) |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

Sebelum memulai materi ini, pastikan Anda sudah memahami dasar-dasar pemrograman Java dari materi sebelumnya, terutama:

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka dan JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Class*, *Object*, dan *Access Modifier*.
- [ ] Memahami konsep *Inheritance* (Pewarisan) menggunakan kata kunci *extends*.
- [ ] Memahami *Method Overriding*.
- [ ] Memahami dasar *Polymorphism*.
- [ ] Memahami aturan *Package* dan *Import*, karena proyek ini menggunakan struktur multi-folder (MVC).

---

## 🚀 PART 1: Pemahaman Konsep

```
                  ┌──────────────────────────────┐
                  │   Koleksi (Abstract Class)   │
                  └──────────────┬───────────────┘
                                 │ (extends)
         ┌───────────────────────┴───────────────────────┐
         │                                               │
┌────────┴────────┐                             ┌────────┴────────┐
│    Objek Buku   │                             │  Objek Majalah  │
└────────┬────────┘                             └─────────────────┘
         │ (implements)
┌────────┴────────┐
│    Pinjamable   │
│   (Interface)   │
└─────────────────┘

```

> 📌 **ANALOGI DUNIA NYATA:**
> * **Abstract Class** ibarat Identitas Absolut (*"Adalah sebuah..."*). `Buku` *adalah sebuah* Koleksi. `Majalah` *adalah sebuah* Koleksi. Keduanya mewarisi DNA dan atribut dasar yang sama (punya Judul, Tahun Terbit).
> * **Interface** ibarat Kontrak Kemampuan (*"Bisa melakukan..."*). `Buku` *bisa dipinjam*. Di masa depan, perpustakaan bisa saja meminjamkan `Payung`. `Payung` bukan bacaan (beda DNA), tapi sama-sama memiliki kemampuan untuk dipinjam.
> 
> 

---

### 1. Apa itu Abstraction (Abstraksi)?

Abstraksi adalah teknik dalam Pemrograman Berorientasi Objek untuk menyembunyikan detail implementasi yang rumit dan hanya menampilkan fungsionalitas esensial kepada pengguna. Abstraksi memisahkan antara rancangan aturan (**WHAT TO DO**) dengan detail pengerjaannya (**HOW TO DO**).

* **Abstract Class vs Interface:**

| Karakteristik | Abstract Class | Interface |
| --- | --- | --- |
| **Fokus Utama** | Kerangka dasar untuk objek beridentitas sama. | Standar kemampuan untuk lintas objek. |
| **Atribut/Variabel** | Bisa menyimpan *state* (variabel biasa). | Hanya bisa menyimpan konstanta (`public static final`). |
| **Method** | Bisa berisi method biasa & *abstract method*. | Murni berisi *abstract method* (kontrak kosong). |
| **Pewarisan** | Menggunakan `extends` (Maksimal 1 Induk). | Menggunakan `implements` (Bisa banyak antarmuka). |

---

### 2. Mengapa Abstraction Penting?

* **Standardisasi Kode:** Memaksa programmer (khususnya jika bekerja dalam tim) untuk mengikuti rancangan metode yang sudah ditetapkan oleh arsitek perangkat lunak.
* **Mencegah Instansiasi yang Tidak Masuk Akal:** Mencegah pembuatan objek dari kelas yang sifatnya masih terlalu umum (misal: Anda tidak bisa membuat wujud fisik dari sekadar "Koleksi", harus spesifik "Buku" atau "Majalah").
* **Polimorfisme Tingkat Lanjut:** Memungkinkan sistem memproses berbagai objek yang sama sekali tidak memiliki hubungan darah/genetik, asalkan mereka menandatangani kontrak *Interface* yang sama.

---

### 3. Pendalaman Abstract Class & Method

`abstract class` digunakan ketika beberapa kelas memiliki data atau perilaku umum, tetapi kelas tersebut belum sempurna untuk dijadikan sebuah objek utuh.

1. **Aturan Instansiasi:** Kelas abstrak **tidak bisa** dibuat menjadi objek menggunakan keyword `new`.
2. **Kewajiban Subclass:** Jika sebuah `abstract class` memiliki `abstract method` (method tanpa `{ }`), maka kelas anaknya **wajib** mendefinisikan ulang (meng-*override*) method tersebut. Jika menolak, kelas anak harus ikut dijadikan *abstract*.

```java
// Contoh deklarasi
public abstract class Koleksi {
    // Abstract method: memaksa anak membuat isinya
    public abstract void tampilkanInfo(); 
}

```

---

### 4. Pendalaman Interface

`interface` adalah bentuk abstraksi paling murni. Ia bukan sebuah kelas, melainkan sebuah kontrak perjanjian.

1. **Semua Bebas, Semua Wajib:** Kelas yang menandatangani kontrak (`implements`) diwajibkan menyediakan implementasi untuk **seluruh** method yang tercantum pada *Interface* tersebut.
2. **Variabel sebagai Konstanta Mutlak:** Jika Anda mendeklarasikan variabel di dalam *Interface*, Java secara implisit menganggapnya sebagai `public static final`. Nilainya tidak bisa diubah (*immutable*).

```java
// Contoh deklarasi kontrak
public interface Pinjamable {
    void pinjam();
    void kembalikan();
}

```

---

### 5. Memadukan Pewarisan (Extends) dan Kontrak (Implements)

Dalam Java, satu kelas **hanya boleh** memiliki satu *Superclass* (Single Inheritance), namun **boleh** menandatangani banyak kontrak *Interface* sekaligus.

#### A. Sintaks Penggabungan

Kata kunci `extends` selalu ditulis mendahului `implements`.

```java
public class Buku extends Koleksi implements Pinjamable {
    // Mewarisi atribut dari Koleksi
    // Wajib meng-override tampilkanInfo() dari Koleksi
    // Wajib meng-override pinjam() dan kembalikan() dari Pinjamable
}

```

#### B. Mengapa Butuh Operator `instanceof` pada Abstraksi?

Saat program berjalan, Controller seringkali hanya melihat koleksi objek secara umum (misal di dalam `ArrayList<Koleksi>`). Jika kita ingin memanggil fitur `pinjam()` yang berasal dari *Interface* `Pinjamable`, kita wajib memastikan bahwa objek tersebut memang menandatangani kontraknya sebelum memaksakan perintah (*casting*).

```java
Koleksi k = daftarKoleksi.get(0);

// Cek apakah objek ini punya kontrak "Pinjamable"?
if (k instanceof Pinjamable) {
    // Jika ya, ubah sudut pandang ke Pinjamable lalu pinjam
    ((Pinjamable) k).pinjam(); 
} else {
    System.out.println("Benda ini tidak bisa dipinjam!");
}

```

---

## 💻 PART 2: Live Coding

### Step 1: Membuat Kontrak Kemampuan (Interface)

Buat file **`src/model/Pinjamable.java`**. Interface ini akan bertindak sebagai standar fungsionalitas untuk benda apa pun yang bisa dipinjam.

```java
package model;

public interface Pinjamable {
    // Kontrak fungsi murni (WHAT TO DO) yang wajib diimplementasikan oleh kelas turunan
    void pinjam();
    void kembalikan();
}

```

---

### Step 2: Membuat Kerangka Dasar (Abstract Class)

Buat file **`src/model/Koleksi.java`**. Kelas ini bertindak sebagai DNA/Identitas dasar untuk semua jenis bacaan di perpustakaan.

```java
package model;

// Abstract Class: tidak bisa di-instansiasi langsung menggunakan 'new'
public abstract class Koleksi {
    protected String idKoleksi;
    protected String judul;
    protected int tahunTerbit;

    public Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Abstract Method: memaksa semua kelas anak membuat cara tampilkanInfo-nya sendiri
    public abstract void tampilkanInfo();

    // Method konkrit bawaan induk (bisa langsung dipakai oleh kelas anak)
    public String getIdKoleksi() { return idKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
}

```

---

### Step 3: Implementasi ("How to Do") pada Kelas Anak

Buat dua subclass di dalam **`src/model/`**, yaitu `Buku.java` dan `Majalah.java`.

**A. Subclass Buku (Mewarisi Identitas & Menjalankan Kontrak)**

```java
package model;

public class Buku extends Koleksi implements Pinjamable {
    private String penulis;
    private int stok;

    public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
        super(idKoleksi, judul, tahunTerbit);
        this.penulis = penulis;
        this.stok = stok;
    }

    // WAJIB: Mengisi abstract method dari kelas Koleksi
    @Override
    public void tampilkanInfo() {
        System.out.printf("ID: %-5s | Judul: %-20s | Tahun: %-4d | Penulis: %-15s | Stok: %-3d [BUKU]\n", 
                idKoleksi, judul, tahunTerbit, penulis, stok);
    }

    // WAJIB: Menjalankan kontrak dari interface Pinjamable
    @Override
    public void pinjam() {
        if (stok > 0) {
            stok--;
            System.out.println(">> SUCCESS: Buku '" + judul + "' berhasil dipinjam. Sisa stok: " + stok);
        } else {
            System.out.println(">> ERROR: Stok buku '" + judul + "' sedang habis!");
        }
    }

    @Override
    public void kembalikan() {
        stok++;
        System.out.println(">> SUCCESS: Buku '" + judul + "' dikembalikan. Stok sekarang: " + stok);
    }

    public String getPenulis() { return penulis; }
    public int getStok() { return stok; }
}

```

**B. Subclass Majalah (Hanya Mewarisi Identitas)**

```java
package model;

public class Majalah extends Koleksi {
    private int edisi;

    public Majalah(String idKoleksi, String judul, int tahunTerbit, int edisi) {
        super(idKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
    }

    // WAJIB: Mengisi abstract method dari kelas Koleksi
    @Override
    public void tampilkanInfo() {
        System.out.printf("ID: %-5s | Judul: %-20s | Tahun: %-4d | Edisi: Vol. %-9d [MAJALAH]\n", 
                idKoleksi, judul, tahunTerbit, edisi);
    }

    public int getEdisi() { return edisi; }
}

```

---

### Step 4: Menangani Logika Polimorfik (Controller)

Buat file **`src/controller/KoleksiController.java`**. Perhatikan metode `prosesPinjamBuku()` yang mendemonstrasikan kekuatan *Interface* dan `instanceof`.

```java
package controller;

import model.Koleksi;
import model.Buku;
import model.Majalah;
import model.Pinjamable;
import java.util.ArrayList;

public class KoleksiController {
    private ArrayList<Koleksi> listKoleksi = new ArrayList<>();

    public KoleksiController() {
        // Dummy Data Awal
        listKoleksi.add(new Buku("B001", "Pemrograman Java", 2023, "James Gosling", 3));
        listKoleksi.add(new Majalah("M001", "Info Komputer", 2024, 12));
    }

    public ArrayList<Koleksi> getAllKoleksi() {
        return listKoleksi;
    }

    public void tambahKoleksi(Koleksi k) {
        listKoleksi.add(k);
    }

    public Koleksi cariById(String id) {
        for (Koleksi k : listKoleksi) {
            if (k.getIdKoleksi().equalsIgnoreCase(id)) {
                return k;
            }
        }
        return null;
    }

    public void prosesPinjamBuku(String id) {
        Koleksi k = cariById(id);
        if (k == null) {
            System.out.println(">> ERROR: ID Koleksi tidak ditemukan!");
        } else if (k instanceof Pinjamable) {
            // Downcasting aman untuk mengakses kemampuan dari Interface
            ((Pinjamable) k).pinjam();
        } else {
            System.out.println(">> ERROR: Koleksi jenis ini (" + k.getClass().getSimpleName() + ") TIDAK BISA dipinjam!");
        }
    }
}

```

---

### Step 5: Menjalankan Aplikasi (View & Main)

Buat antarmuka dan *entry point* program di *package* masing-masing.

**A. Antarmuka (View) - `src/view/KoleksiView.java**`

```java
package view;

import controller.KoleksiController;
import model.Koleksi;
import model.Buku;
import java.util.Scanner;

public class KoleksiView {
    private KoleksiController controller;
    private Scanner scanner;

    public KoleksiView(KoleksiController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void renderMenu() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM PERPUSTAKAAN (P6: MVC & ABSTRAKSI)");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Koleksi");
            System.out.println("2. Tambah Buku Baru");
            System.out.println("3. Pinjam Buku (Interface Demo)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR KOLEKSI ---");
                    for (Koleksi k : controller.getAllKoleksi()) {
                        k.tampilkanInfo();
                    }
                    break;
                case 2:
                    System.out.println("\n--- TAMBAH BUKU ---");
                    System.out.print("ID Buku      : "); String id = scanner.nextLine();
                    System.out.print("Judul Buku   : "); String judul = scanner.nextLine();
                    System.out.print("Tahun Terbit : "); int tahun = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Penulis      : "); String penulis = scanner.nextLine();
                    System.out.print("Stok         : "); int stok = scanner.nextInt();
                    controller.tambahKoleksi(new Buku(id, judul, tahun, penulis, stok));
                    System.out.println(">> SUCCESS: Buku berhasil ditambahkan!");
                    break;
                case 3:
                    System.out.println("\n--- PINJAM KOLEKSI ---");
                    System.out.print("Masukkan ID Koleksi: ");
                    String idPinjam = scanner.nextLine();
                    controller.prosesPinjamBuku(idPinjam);
                    break;
                case 4:
                    berjalan = false;
                    System.out.println("\nSesi Selesai.");
                    break;
                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
    }
}

```

**B. Entry Point - `src/main/MainApp.java**`

```java
package main;

import controller.KoleksiController;
import view.KoleksiView;

public class MainApp {
    public static void main(String[] args) {
        KoleksiController controller = new KoleksiController();
        KoleksiView view = new KoleksiView(controller);
        view.renderMenu();
    }
}

```

---

## ⚡ PART 3: EKSPERIMEN ERROR

Lakukan pengujian ini secara sengaja untuk melatih kemampuan *debugging* abstraksi.

### 🎯 Eksperimen 1: Instansiasi Paksa Abstract Class

**Tindakan:** Buka `KoleksiController.java`, pada bagian *constructor*, tambahkan data dengan memaksa pembuatan objek `Koleksi`.

```java
listKoleksi.add(new Koleksi("K00", "Buku Polos", 2026));

```

* **Hasil:** Error kompilasi: `Koleksi is abstract; cannot be instantiated`.
* **Pelajaran:** Kelas abstrak (kerangka dasar) tidak bisa menjadi benda nyata di memori. Harus diwujudkan lewat turunan (*concrete class*).

---

### 🎯 Eksperimen 2: Menolak Janji Abstract Method

**Tindakan:** Buka file `Majalah.java`, berikan komentar `//` pada seluruh baris method `@Override public void tampilkanInfo() { ... }`.

* **Hasil:** Error kompilasi di baris nama kelas: `Majalah is not abstract and does not override abstract method...`
* **Pelajaran:** Turunan dari kelas abstrak terikat hukum wajib militer. Mereka **harus** mengimplementasikan semua *abstract method* yang diturunkan.

---

### 🎯 Eksperimen 3: Miskonsepsi Variabel Interface

**Tindakan:**

1. Buka `Pinjamable.java`, tambahkan atribut baru: `int MAKS_HARI = 7;`
2. Buka `Buku.java`, di dalam method `pinjam()`, coba ubah nilainya: `MAKS_HARI = 10;`

* **Hasil:** Error kompilasi: `cannot assign a value to final variable MAKS_HARI`.
* **Pelajaran:** Berbeda dengan kelas abstrak, semua variabel yang dideklarasikan di dalam sebuah *Interface* selalu dimutlakkan sebagai `public static final` (Konstanta) oleh Java.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `cannot be instantiated` | Menggunakan keyword `new` pada *Abstract Class* atau *Interface*. | Pastikan instansiasi hanya dilakukan pada *Concrete Class* (`Buku` / `Majalah`). |
| `class is not abstract and does not override...` | Kelas turunan lupa / belum mengimplementasikan method abstrak yang dijanjikan. | Tulis ulang method tersebut berserta blok kodenya `{ }` di kelas anak, dan gunakan `@Override`. |
| `method does not override or implement a method...` | Terjadi kesalahan penulisan (*typo*), perbedaan tipe parameter, atau kembalian dari method *Superclass*/*Interface*. | Samakan nama, jumlah, dan tipe data parameter persis seperti yang tertulis di rancangan induk. |
| `cannot assign a value to final variable` | Mencoba memodifikasi/menugaskan nilai baru pada variabel yang berasal dari *Interface*. | Pindahkan atribut tersebut ke *Abstract Class* jika nilainya dirancang untuk bisa berubah (*mutable*). |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Kapan saya mutlak harus menggunakan Interface daripada Abstract Class?**

> **A:** Ketika Anda ingin memaksa beberapa objek yang **sama sekali tidak memiliki hubungan logis/genetik** untuk memiliki kemampuan yang sama. Misalnya, Anda membuat sistem peringatan alarm. `JamWeker` (Elektronik), `AnjingPenjaga` (Hewan), dan `SensorAsap` (Perangkat Keamanan) secara klasifikasi sama sekali tidak berhubungan. Namun, ketiganya bisa diberi kemampuan `implements Alarm`.

**Q: Bolehkah sebuah kelas anak melakukan `implements` lebih dari satu Interface?**

> **A:** Sangat diperbolehkan, dan ini adalah salah satu keunggulan utama Java. Meskipun satu kelas hanya boleh menginduk (`extends`) pada SATU *abstract class*, ia boleh menandatangani BANYAK kontrak antarmuka (`implements Pinjamable, DapatDidenda, DapatDifotokopi, dll`).

**Q: Mengapa *Interface* tidak boleh berisi method yang ada isinya (sebelum Java 8)?**

> **A:** Karena peran murni *Interface* hanyalah sebagai spesifikasi dokumen/kontrak (*What to Do*), bukan instruksi logika eksekusi (*How to Do*). Implementasi selalu diserahkan kepada kelas yang menyetujui kontrak tersebut.

---

## 🔗 Daftar Referensi

[1] Oracle Docs, "Abstract Methods and Classes". Tersedia di: [tautan](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

[2] Oracle Docs, "Interfaces in Java". Tersedia di: [tautan](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

[3] W3Schools, "Java Abstraction". Tersedia di: [tautan](https://www.w3schools.com/java/java_abstract.asp)

---

## 🏆 CHALLENGE PRAKTIKAN

**Instruksi:** Jangan menggunakan kerangka proyek di atas. Buatlah proyek Java baru (*Project from scratch*) untuk melatih insting perancangan struktur sistem Anda.

1. **Level Dasar (Membangun Antarmuka)**
Sistem perpustakaan ingin menagih denda, namun yang bisa didenda bukan hanya Buku (bisa jadi Kunci Loker atau Kartu Hilang).
* Buat interface `DapatDidenda` yang memiliki satu *abstract method* `hitungDenda(int hariTerlambat)`.
* Buat kelas konkrit (misal: `KunciLoker`) yang mengimplementasikan interface tersebut.
* Uji hasil perhitungan dendanya di method `main()`.


2. **Level Menengah (Membangun Kerangka Genetik)**
Sistem perpustakaan membutuhkan manajemen pengguna.
* Buat *Abstract Class* `Anggota` yang menyimpan `idAnggota` dan `nama`.
* Tambahkan *abstract method* `int getBatasPinjam()`.
* Buat dua *Subclass*: `Dosen` (batas pinjam 7) dan `Mahasiswa` (batas pinjam 3).
* Instansiasi masing-masing di `main()` dan cetak batas pinjamnya.


3. **Level Lanjut (Arsitektur Polimorfik Ganda)**
Perpustakaan kini berekspansi ke layanan digital.
* Buat interface baru bernama `AksesDigital` dengan method `bacaOnline()`.
* Buat kelas baru bernama `EBook`.
* Kelas `EBook` ini **harus** merupakan turunan (`extends`) dari kelas abstrak `Koleksi` (gunakan class `Koleksi` dari contoh modul).
* Kelas `EBook` ini juga **harus** mengimplementasikan **dua antarmuka sekaligus**, yaitu `Pinjamable` dan `AksesDigital`.
* Demonstrasikan logika `bacaOnline()` dan proses peminjaman *e-book* berjalan dengan baik di method `main()`.
