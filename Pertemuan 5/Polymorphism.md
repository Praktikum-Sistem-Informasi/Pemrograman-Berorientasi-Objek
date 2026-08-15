# 5️⃣ Polymorphism

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep dasar Polimorfisme (*"Satu Nama, Banyak Bentuk"*) dan perannya dalam PBO.
2. ✅ Membedakan antara *Static Polymorphism* (*Method Overloading*) dan *Dynamic Polymorphism* (*Method Overriding*).
3. ✅ Mengimplementasikan anotasi `@Override` untuk mendefinisikan ulang perilaku method induk.
4. ✅ Memahami fungsi operator `instanceof` dan mekanisme *Downcasting* pada koleksi polimorfik.
5. ✅ Membuat *Polymorphic Collection* (*Heterogeneous List*) untuk mengelola berbagai objek turunan dalam satu `ArrayList`.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat 3 kata kunci/anotasi utama yang wajib Anda pahami fungsi dan dampaknya:

* **`Overloading`** : *Static Polymorphism*. Pembuatan beberapa method dengan nama yang sama di dalam satu kelas, tetapi memiliki parameter yang berbeda (jumlah atau tipe data).
* **`@Override`**   : *Dynamic Polymorphism*. Penandaan khusus untuk mendefinisikan ulang perilaku method milik *Superclass* di dalam *Subclass*.
* **`instanceof`**  : Operator untuk mengecek wujud/tipe asli suatu objek sebelum melakukan *downcasting* pada koleksi polimorfik.

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `contoh_kode/pertemuan_5`**

| File | Deskripsi |
| :--- | :--- |
| `src/model/Koleksi.java` | *Superclass* dengan contoh *Method Overloading* & method yang siap di-*override* |
| `src/model/Buku.java` | *Subclass 1* yang meng-override method `tampilkanInfo()` |
| `src/model/Majalah.java` | *Subclass 2* yang meng-override method `tampilkanInfo()` |
| `src/main/MainApp.java` | Kelas utama untuk pengujian *Heterogeneous List* & eksekusi *Overloading/Overriding* |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Inheritance* (Pewarisan) dari Pertemuan 4.

---

## 🚀 PART 1: Pemahaman Konsep


```
                  ┌──────────────────────────────┐
                  │   ArrayList<Koleksi> list    │
                  └──────────────┬───────────────┘
                                 │
         ┌───────────────────────┴───────────────────────┐
         │                                               │
┌────────┴────────┐                             ┌────────┴────────┐
│  Objek Buku     │                             │  Objek Majalah  │
│(tampilkanInfo())│                             │(tampilkanInfo())│
└─────────────────┘                             └─────────────────┘

```

> 📌 **ANALOGI DUNIA NYATA:**
> - Tombol **"Play"** pada *Remote Control*. 
> - Jika diarahkan ke DVD Player, ia memutar DVD. Jika diarahkan ke Spotify, ia memutar musik. Perintahnya sama-sama **"Play"**, namun >**perilaku eksekusinya menyesuaikan objek yang diraih**.

---

### 1. Apa itu Polymorphism (Polimorfisme)?
*Polymorphism* berasal dari bahasa Yunani yang berarti *"banyak bentuk"*. Dalam PBO, polimorfisme adalah kemampuan suatu objek atau method untuk memiliki banyak bentuk implementasi tergantung pada bagaimana method tersebut dipanggil atau jenis objek yang menjalankannya.

* **Overloading vs Overriding:**

| Karakteristik | Static Polymorphism (*Overloading*) | Dynamic Polymorphism (*Overriding*) |
| :--- | :--- | :--- |
| **Lokasi** | Dalam **satu kelas** yang sama. | Pada kelas induk dan kelas anak (**beda kelas**). |
| **Nama Method** | **Sama**. | **Sama**. |
| **Parameter** | **Wajib Beda** (Jumlah / Tipe Data). | **Wajib Sama Persis**. |
| **Waktu Eksekusi** | *Compile-time* (Ditentukan saat kompilasi). | *Runtime* (Ditentukan saat program berjalan). |

---

### 2. Mengapa Polymorphism Penting?

* **Fleksibilitas Kode Tinggi:** Memungkinkan kita memperlakukan berbagai kelas anak yang berbeda seolah-olah mereka adalah kelas induk yang sama.
* **Pengelolaan Koleksi Efisien:** Menghilangkan kebutuhan membuat `ArrayList` terpisah untuk setiap kelas anak. Cukup satu `ArrayList<Induk>` (*Heterogeneous List*) untuk menampung seluruh objek turunannya.
* **Penerapan *Clean Code*:** Mengurangi penggunaan percabangan `if-else` atau `switch-case` yang berlebihan saat menangani berbagai tipe objek.

---

### 3. Pendalaman Dynamic Polymorphism (`@Override`)
*Method Overriding* terjadi ketika kelas anak (*Subclass*) menyediakan implementasi khusus untuk method yang sudah didefinisikan di kelas induknya (*Superclass*).

1. **Anotasi `@Override` — Penjaga Validasi Kompiler:**
   * Anotasi ini memberi tahu kompiler bahwa method tersebut berniat menggantikan method milik induk. Jika ada kesalahan nama atau perbedaan parameter, kompilasi akan langsung gagal (garis merah).
2. **Eksekusi Sesuai Wujud Asli di Memori:**
   * Saat method dipanggil melalui tipe referensi induk, Java secara otomatis mengeksekusi method versi kelas anak sesuai tipe objek yang sebenarnya berada di memori saat *runtime*.

---

### 4. Pendalaman Static Polymorphism (Overloading)
*Method Overloading* terjadi ketika dua atau lebih method dalam satu kelas memiliki nama yang persis sama, tetapi menerima deretan parameter yang berbeda.

* Kompiler membedakan method yang dipanggil berdasarkan **jumlah parameter**, **tipe data parameter**, atau **urutan tipe data parameter**.
* Tipe kembalian (*return type*) saja **tidak cukup** untuk membedakan method yang di-overload.

---

### 5. Pendalaman Operator `instanceof` dan Konsep Downcasting

Saat mengelola *Polymorphic Collection* (`ArrayList<Koleksi>`), semua elemen tersimpan dengan tipe referensi kelas induk (`Koleksi`). Namun, terkadang kita perlu mengakses method khusus yang **hanya ada di kelas anak tertentu** (misal: method `getStok()` pada `Buku` atau `getEdisi()` pada `Majalah`).

#### A. Upcasting vs Downcasting
* **Upcasting (Aman & Otomatis):** Mengkonversi tipe objek anak ke tipe referensi induknya.
```java
  Koleksi k = new Buku("B001", "Java", 2023, "Gosling", 5); // Otomatis (Upcasting)

```

* **Downcasting (Berisiko & Manual):** Mengembalikan tipe referensi induk ke tipe wujud asli kelas anaknya untuk mengakses method/atribut spesifik.

```java
Buku b = (Buku) k; // Konversi manual (Downcasting)
System.out.println(b.getStok()); // Sekarang bisa mengakses method khusus Buku!

```

#### B. Mengapa Butuh Operator `instanceof`?

Jika kita melakukan *Downcasting* secara sembarangan tanpa mengecek wujud aslinya, Java akan melemparkan kesalahan *runtime* berupa **`ClassCastException`** (misal: mencoba mengkonversi objek `Majalah` secara paksa menjadi `Buku`).

Operator **`instanceof`** digunakan sebagai **pemeriksa keamanan** untuk mengecek apakah objek referensi induk benar-benar merupakan instansiasi dari kelas anak tertentu sebelum dikonversi.

#### C. Penggunaan `instanceof` dan Downcasting

```java
// Melakukan perulangan pada Heterogeneous List
for (Koleksi k : daftarKoleksi) {
    k.tampilkanInfo(); // Polimorfisme biasa

    // Menggunakan instanceof sebelum Downcasting
    if (k instanceof Buku) {
        Buku b = (Buku) k; // Aman melakukan Downcasting
        System.out.println("   -> Stok Buku ini: " + b.getStok());
    } else if (k instanceof Majalah) {
        Majalah m = (Majalah) k; // Aman melakukan Downcasting
        System.out.println("   -> Edisi Majalah ini: Vol. " + m.getEdisi());
    }
}

```

> 💡 **Pola Modern (Java 16+ Pattern Matching for instanceof):**
> Pada Java versi baru, *checking* dan *downcasting* bisa digabung dalam 1 baris singkat:
> ```java
> if (k instanceof Buku b) {
>     System.out.println("   -> Stok Buku ini: " + b.getStok());
> }
> 
> ```
> 
> 

---

## 💻 PART 2: Live Coding

### Step 1: Modifikasi Superclass (`src/model/Koleksi.java`)

```java
package model;

public class Koleksi {
    protected String idKoleksi;
    protected String judul;
    protected int tahunTerbit;

    public Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Method yang akan di-OVERRIDE oleh kelas anak
    public void tampilkanInfo() {
        System.out.printf("ID: %-5s | Judul: %-22s | Tahun: %-4d ", 
                idKoleksi, judul, tahunTerbit);
    }

    // =========================================================================
    // CONTOH METHOD OVERLOADING (Nama sama, parameter berbeda dalam 1 kelas)
    // =========================================================================
    
    // Overload 1: Cari berdasarkan kata kunci judul (String)
    public boolean cocokData(String kataKunci) {
        return this.judul.toLowerCase().contains(kataKunci.toLowerCase());
    }

    // Overload 2: Cari berdasarkan tahun terbit persis (int)
    public boolean cocokData(int tahun) {
        return this.tahunTerbit == tahun;
    }

    // Getter
    public String getIdKoleksi() { return idKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
}

```

---

### Step 2: Implementasi Overriding di Subclass 1 (`src/model/Buku.java`)

```java
package model;

public class Buku extends Koleksi {
    private String penulis;
    private int stok;

    public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
        super(idKoleksi, judul, tahunTerbit);
        this.penulis = penulis;
        this.stok = stok;
    }

    // DYNAMIC POLYMORPHISM: METHOD OVERRIDING
    // Mengubah perilaku method milik Superclass agar sesuai dengan Buku
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil tampilan dasar Koleksi
        System.out.printf("| Penulis: %-15s | Stok: %-3d [JENIS: BUKU]\n", penulis, stok);
    }

    public String getPenulis() { return penulis; }
    public int getStok() { return stok; }
}

```

---

### Step 3: Implementasi Overriding di Subclass 2 (`src/model/Majalah.java`)

```java
package model;

public class Majalah extends Koleksi {
    private int edisi;

    public Majalah(String idKoleksi, String judul, int tahunTerbit, int edisi) {
        super(idKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
    }

    // DYNAMIC POLYMORPHISM: METHOD OVERRIDING
    // Mengubah perilaku method milik Superclass agar sesuai dengan Majalah
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil tampilan dasar Koleksi
        System.out.printf("| Edisi: Vol. %-11d [JENIS: MAJALAH]\n", edisi);
    }

    public int getEdisi() { return edisi; }
}

```

---

### Step 4: Menjalankan Kelas Utama (`src/main/MainApp.java`)

```java
package main;

import model.Koleksi;
import model.Buku;
import model.Majalah;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        PERTEMUAN 5: POLYMORPHISM (PBO)          ");
        System.out.println("=================================================\n");

        // 1. POLYMORPHIC COLLECTION (Satu List menampung berbagai tipe turunan Koleksi)
        ArrayList<Koleksi> daftarKoleksi = new ArrayList<>();

        // Memasukkan objek Buku dan Majalah ke dalam tipe referensi Koleksi
        daftarKoleksi.add(new Buku("B001", "Pemrograman Java", 2023, "James Gosling", 5));
        daftarKoleksi.add(new Majalah("M001", "National Geographic", 2024, 142));
        daftarKoleksi.add(new Buku("B002", "Struktur Data", 2022, "Ada Lovelace", 3));
        daftarKoleksi.add(new Majalah("M002", "Info Komputer", 2023, 88));

        // 2. DEMO DYNAMIC POLYMORPHISM (METHOD OVERRIDING)
        System.out.println("--- DAFTAR SELURUH KOLEKSI PERPUSTAKAAN ---");
        for (Koleksi k : daftarKoleksi) {
            // Java secara otomatis memanggil tampilkanInfo() sesuai wujud ASLI objeknya
            k.tampilkanInfo(); 
        }

        // 3. DEMO STATIC POLYMORPHISM (METHOD OVERLOADING)
        System.out.println("\n--- DEMO METHOD OVERLOADING (PENCARIAN) ---");
        
        // Pencarian 1: Berdasarkan String (Judul)
        String cariJudul = "Java";
        System.out.println("-> Hasil Pencarian Judul '" + cariJudul + "':");
        for (Koleksi k : daftarKoleksi) {
            if (k.cocokData(cariJudul)) { // Memanggil Overload 1 (String)
                k.tampilkanInfo();
            }
        }

        // Pencarian 2: Berdasarkan int (Tahun Terbit)
        int cariTahun = 2024;
        System.out.println("\n-> Hasil Pencarian Tahun Terbit persis '" + cariTahun + "':");
        for (Koleksi k : daftarKoleksi) {
            if (k.cocokData(cariTahun)) { // Memanggil Overload 2 (int)
                k.tampilkanInfo();
            }
        }

        // 4. DEMO INSTANCEOF & DOWNCASTING
        System.out.println("\n--- DEMO INSTANCEOF & DOWNCASTING (PEMERIKSAAN FITUR SPESIFIK) ---");
        for (Koleksi k : daftarKoleksi) {
            if (k instanceof Buku) {
                Buku b = (Buku) k; // Safe Downcasting
                System.out.println("[BUKU] Judul: " + b.getJudul() + " | Sisa Stok: " + b.getStok());
            } else if (k instanceof Majalah) {
                Majalah m = (Majalah) k; // Safe Downcasting
                System.out.println("[MAJALAH] Judul: " + m.getJudul() + " | Edisi: Vol. " + m.getEdisi());
            }
        }
    }
}

```

---

## ⚡ PART 3: EKSPERIMEN ERROR

### 🎯 Eksperimen 1: Mismatched Parameter pada Overriding

**Tindakan:** Ubah method `tampilkanInfo()` di `Buku.java` dengan menambahkan parameter baru: `public void tampilkanInfo(String c)`.

```java
@Override
public void tampilkanInfo(String c) {
    // ...
}

```

* **Hasil:** Error Kompilasi (`method does not override or implement a method from a supertype`).
* **Pelajaran:** Anotasi `@Override` bertindak sebagai penjaga (*guard*). Jika nama/parameter tidak persis sama dengan induk, Java menganggapnya *Overloading*, bukan *Overriding*.

---

### 🎯 Eksperimen 2: Downcasting Tanpa Pemeriksaan `instanceof`

**Tindakan:** Pada `MainApp.java`, coba secara paksa mengkonversi objek `Koleksi` dari list langsung menjadi `Buku`.

```java
Koleksi k = daftarKoleksi.get(1); // Indeks 1 berisi objek Majalah
Buku b = (Buku) k; // Memaksa downcasting tanpa cek instanceof

```

* **Hasil:** Runtime Error (`ClassCastException: model.Majalah cannot be cast to model.Buku`).
* **Pelajaran:** Selalu gunakan operator `instanceof` untuk memastikan tipe objek asli sebelum melakukan *downcasting*.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `method does not override or implement...` | Parameter/nama method bertanda `@Override` tidak cocok dengan method di kelas induk. | Disamakan nama method, tipe kembalian (*return type*), serta jumlah & tipe parameter dengan kelas induk. |
| `ClassCastException: ... cannot be cast to ...` | Memaksa *downcasting* tipe objek ke kelas turunan yang tidak sesuai wujud aslinya. | Gunakan operator `instanceof` untuk mengecek tipe wujud asli objek sebelum melakukan *downcasting*. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Mengapa kita sangat disarankan memakai anotasi `@Override`? Bukankah tanpa anotasi program tetap bisa jalan?**

> **A:** Anotasi `@Override` berfungsi sebagai alat pemicu peringatan untuk kompiler Java. Jika Anda salah ketik nama method atau beda tipe parameter sedikit saja dari method induk, kompiler akan langsung memberi garis merah error. Tanpa `@Override`, Java akan menganggap method salah ketik itu sebagai method baru biasa, sehingga fitur Polimorfisme gagal berjalan tanpa ada peringatan error.

**Q: Apa keuntungan utama menggunakan Heterogeneous List seperti `ArrayList<Koleksi>`?**

> **A:** Efisiensi dan fleksibilitas kode. Tanpa Polimorfisme, Anda harus membuat `ArrayList<Buku>` dan `ArrayList<Majalah>` secara terpisah, serta membuat dua *looping* terpisah untuk mencetak datanya. Dengan Polimorfisme, cukup satu `ArrayList<Koleksi>` untuk menampung ratusan jenis turunan koleksi yang berbeda.

**Q: Kapan saya harus memilih *Overloading* dibanding *Overriding*?**

> **A:** Gunakan **Overloading** jika Anda ingin membuat satu method yang memiliki kegunaan sama dalam satu kelas tetapi bisa menerima input/parameter yang bervariasi (misal: method pencarian data berdasarkan nama `String` atau berdasarkan ID `int`). Gunakan **Overriding** jika Anda ingin kelas anak mengubah/memodifikasi total perilaku method yang diwariskan oleh kelas induknya.

---

## 🔗 Daftar Referensi

[1] Dicoding Blog, "Pengertian Polimorfisme dalam Pemrograman Java". Tersedia di: [tautan](https://www.dicoding.com/blog/pengertian-polimorfisme-dalam-pemrograman-java/)

[2] CodePolitan, "Apa itu Polymorphism adalah Pengertian Metode Keunggulannya". Tersedia di: [tautan](https://www.codepolitan.com/blog/apa-itu-polymorphism-adalah-pengertian-metode-keunggulannya/)

[3] W3Schools, "Java Polymorphism". Tersedia di: [tautan](https://www.w3schools.com/java/java_polymorphism.asp)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Buat program sesuai instruksi berikut:

   a) Buat class **`Hewan`** berisi method `bersuara()` yang mencetak suara umum hewan.

   b) Buat class **`Kucing`** dan **`Anjing`** yang mewarisi class `Hewan`.

   c) Lakukan **override** pada method `bersuara()` di masing-masing subclass dengan suara khasnya.

   d) Buat objek **`Kucing`** dan **`Anjing`** pada `main()`, lalu jalankan method `bersuara()`.
   
2. Buat program sesuai instruksi berikut:

   a) Buat class **`Kalkulator`** yang mendemonstrasikan **method overloading**.

   b) Buat method `tambah(int a, int b)` dan `tambah(double a, double b)`.

   c) Panggil kedua method tersebut pada `main()` dan tampilkan hasilnya.

3. Buat program sesuai instruksi berikut:

   a) Gunakan class **`Hewan`**, **`Kucing`**, dan **`Anjing`** dari soal nomor 1.

   b) Buat `ArrayList<Hewan>` di `main()` dan tambahkan objek **`Kucing`** serta **`Anjing`** ke dalamnya.

   c) Lakukan perulangan `for` untuk memanggil method `bersuara()` dari tiap elemen di dalam `ArrayList` tersebut.

---
