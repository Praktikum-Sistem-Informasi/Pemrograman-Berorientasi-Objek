<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

# Topik 5 - Access Modifier dan Encapsulation

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep **Encapsulation** (Pembungkusan Data) dan pentingnya penyembunyian data (*Data Hiding*) dalam PBO.
2. ✅ Memahami dan menerapkan tingkat aksesibilitas menggunakan **Access Modifier** (`private`, `protected`, `public`, dan *default*).
3. ✅ Mengimplementasikan metode **Getter** dan **Setter** sebagai pintu akses terkontrol terhadap atribut kelas.
4. ✅ Menerapkan **Validasi Data** pada metode Setter untuk menjaga integritas data objek.
5. ✅ Memisahkan struktur kelas domain (*Model*) dengan kelas penguji (*Main App*) menggunakan organisasi *Package*.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat 3 kata kunci utama yang wajib Anda pahami fungsi dan dampaknya:

* **`Access Level`** : Batas izin yang diberikan kepada seseorang untuk melihat, mengubah, atau memakai data, sistem, dan area tertentu.
* **Getter (`get...`)** : Metode khusus bertipe kembalian (*return type*) yang berfungsi untuk membaca/mengambil nilai atribut `private`.
* **Setter (`set...`)** : Metode khusus bertipe `void` yang berfungsi untuk mengubah nilai atribut `private` dengan disertai logika validasi.

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-3`**

| File | Deskripsi |
| :--- | :--- |
| `Buku.java` | Kelas *Model* yang menerapkan enkapsulasi atribut `private`, Getter/Setter, dan validasi data |
| `MainApp.java` | Kelas utama penguji keamanan enkapsulasi dan pembuktian kegagalan akses langsung |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami pembuatan *Class*, *Object*, dan *Constructor* dari Pertemuan 2.

---

## 🚀 PART 1: Pemahaman Konsep

```
               +-----------------------------------+
               |             Buku.java             |
               |                                   |
   AKSES       |   private String judul;           |
 DISENTIL!     |   private int stok;               |   AKSES LEWAT
   ----x-----> |                                   |  PINTU RESMI!
 (Akses        |   +---------------------------+   | <------------
  Direct)      |   |   Getter & Setter         |   |  (setStok(10))
               |   |   (Validasi: stok >= 0)   |   |
               |   +---------------------------+   |
               +-----------------------------------+
```

> 📌 ANALOGI DUNIA NYATA:
> - Bayangkan sebuah Mesin ATM. Uang di dalam brankas ATM bersifat private. Nasabah luar tidak boleh langsung merogoh tangan ke dalam brankas untuk mengambil uang.
> - Nasabah harus menggunakan Pintu Akses Terkontrol (Layar ATM & Tombol). Sebelum uang keluar, mesin ATM akan melakukan Validasi (Cek Saldo & PIN).
> - Dalam Java, atribut disembunyikan dengan private, sedangkan tombol/layar ATM adalah metode Getter & Setter!

---

### 1. Apa itu Encapsulation (Enkapsulasi)?
Enkapsulasi adalah teknik membungkus data (field/attribute) dan metode (method) yang mengoperasikan data tersebut ke dalam satu unit tunggal (Class), serta menyembunyikan detail implementasi dari akses luar (Data Hiding).
- Tujuan Utama: Mencegah pihak luar mengubah kondisi internal (state) objek secara tidak sah, tidak tervalidasi, atau tidak konsisten.
- Mekanisme: Menjadikan semua atribut bertipe private, lalu menyediakan metode public Getter & Setter untuk berinteraksi dengan atribut tersebut.

---

### 2. Tingkat Aksesibilitas (Access Modifier)
Java menyediakan 4 tingkat hak akses untuk mengatur pembatasan kode:

| **Modifier**                | **Dalam Class Sama** | **Dalam Package Sama** | **Class Anak (Subclass) Beda Package** | **Luar Package Umum** |
|-----------------------------|:--------------------:|:----------------------:|:--------------------------------------:|:---------------------:|
| **`default`** (No Modifier) | ✅ Ya                | ✅ Ya                  | ❌ Tidak                               | ❌ Tidak              |
| **`public`**                | ✅ Ya                | ✅ Ya                  | ✅ Ya                                  | ✅ Ya                 |
| **`private`**               | ✅ Ya                | ❌ Tidak               | ❌ Tidak                               | ❌ Tidak              |
| **`protected`**             | ✅ Ya                | ✅ Ya                  | ✅ Ya                                  | ❌ Tidak              |

---

### 3. Mengapa Validasi pada Setter Penting?
Tanpa enkapsulasi, variabel seperti stok bisa diisi nilai yang secara logika bisnis salah/mustahil, seperti stok = -500. 
- Dengan Setter, kita menaruh baris penguji (if-else) sebelum data disimpan ke dalam memori:
```
public void setStok(int stok) {
    if (stok >= 0) {
        this.stok = stok; // Data valid diterima
    } else {
        // Data invalid ditolak & diberi nilai aman
        System.out.println("ERROR: Stok tidak boleh negatif!");
        this.stok = 0;
    }
}
```

---

## 💻 PART 2: Live Coding
### Step 1: Membuat Model Terenkapsulasi (src/model/Buku.java)
```
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
        setJudul(judul);   // Gunakan setter agar tervalidasi saat objek dibuat
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
```

---

### Step 2: Menjalankan Kelas Utama (src/main/MainApp.java)
```
package main;

import model.Buku;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   PERTEMUAN 3: ACCESS MODIFIER & ENCAPSULATION  ");
        System.out.println("=================================================\n");

        // 1. INSTANSIASI OBJEK DENGAN DATA VALID
        System.out.println("--- 1. Membuat Objek Buku Normal ---");
        Buku buku1 = new Buku("B001", "Pemrograman Java", "James Gosling", 5);
        buku1.tampilkanInfo();

        // 2. DEMO AKSES ILEGAL (PEMBUKTIAN ACCESS MODIFIER PRIVATE)
        System.out.println("\n--- 2. Uji Coba Akses Langsung Atribut Private ---");
        // KODE DI BAWAH INI JIKA DI-UNCOMMENT AKAN CAUSE COMPILER ERROR:
        // buku1.stok = -10; // ERROR: stok has private access in model.Buku
        // buku1.judul = ""; // ERROR: judul has private access in model.Buku
        System.out.println("[SISTEM]: Atribut 'stok' & 'judul' bersifat PRIVATE.");
        System.out.println("[SISTEM]: Langsung mengubah buku1.stok = -10 ditolak oleh Java Compiler!");

        // 3. DEMO SETTER DENGAN VALIDASI (PERCOBAAN INPUT INVALID)
        System.out.println("\n--- 3. Mengubah Data Lewat Setter (Input Salah) ---");
        System.out.println("Mencoba set stok menjadi -15...");
        buku1.setStok(-15); // Memicu pesan error validasi dari Setter

        System.out.println("Mencoba set judul menjadi string kosong...");
        buku1.setJudul(""); // Memicu pesan error validasi dari Setter

        // Tampilkan kondisi data setelah dites dengan input salah
        System.out.println("\nKondisi Objek Setelah Input Invalid:");
        buku1.tampilkanInfo();

        // 4. DEMO SETTER DENGAN INPUT VALID
        System.out.println("\n--- 4. Mengubah Data Lewat Setter (Input Valid) ---");
        System.out.println("Mengubah stok menjadi 12...");
        buku1.setStok(12);

        System.out.println("Mengubah judul menjadi 'Java PBO Lanjut'...");
        buku1.setJudul("Java PBO Lanjut");

        // Tampilkan kondisi data akhir menggunakan Getter
        System.out.println("\nKondisi Objek Akhir (Diakses lewat Getter):");
        System.out.println("ID Buku : " + buku1.getIdBuku());
        System.out.println("Judul   : " + buku1.getJudul());
        System.out.println("Penulis : " + buku1.getPenulis());
        System.out.println("Stok    : " + buku1.getStok());
    }
}
```

---

## ⚡ PART 3: EKSPERIMEN ERROR
### 🎯 Eksperimen 1: Mengakses Atribut Private Secara Langsung
**Tindakan:** Hapus tanda komentar // pada kode buku1.stok = -10; di dalam MainApp.java.
```
buku1.stok = -10;
```
- Hasil: Error Kompilasi (stok has private access in model.Buku).
- Pelajaran: Kode di luar kelas Buku dilarang keras menyentuh atribut private secara langsung. Akses harus selalu melewati method Setter/Getter.

----

### 🎯 Eksperimen 2: Menghapus Method Setter
**Tindakan:** Pada Buku.java, hapus atau beri komentar pada metode public void setStok(int stok).
- Hasil: Error Kompilasi pada MainApp.java saat memanggil buku1.setStok(...) (cannot find symbol method setStok(int)).
- Pelajaran: Jika kita hanya membuat Getter tanpa Setter, maka atribut tersebut menjadi Read-Only (hanya bisa dibaca, tidak bisa diubah nilainya setelah objek dibuat).

---

## 🚨 TROUBLESHOOTING RINGKAS

| **Pesan Error**                    | **Penyebab**                                                                        | **Solusi**                                                                  |
|------------------------------------|--------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| `... has private access in ...`    | Mencoba membaca/mengubah atribut/method bertipe `private` langsung dari kelas luar. | Gunakan method **Getter** (untuk membaca) atau **Setter** (untuk mengubah). |
| `cannot find symbol method set...` | Metode Setter belum dibuat di kelas model, atau ada salah ketik nama method.        | Buat metode `public void setNamaAtribut(...)` di kelas model target.        |

---

## ❓ Frequently Asked Questions (FAQ)

### Q1. Mengapa kita harus repot-repot membuat Getter dan Setter jika data tetap bisa diubah dari luar?

**A:** Karena **Setter** berfungsi sebagai **filter atau satpam** bagi data. Di dalam Setter, kita dapat menambahkan aturan atau logika **validasi** sebelum data disimpan.

Jika sebuah variabel dibuat `public`, siapa pun dapat memasukkan data yang tidak valid tanpa adanya penyaringan. Contohnya, stok barang dapat diisi dengan nilai negatif atau sebuah teks dapat diisi dengan nilai kosong.

Dengan menggunakan Setter, kita dapat memastikan bahwa data yang masuk sesuai dengan aturan yang telah ditentukan.

---

### Q2. Apakah semua atribut wajib dibuatkan Getter dan Setter?

**A:** **Tidak wajib.** Getter dan Setter dibuat sesuai dengan kebutuhan akses terhadap atribut.

Setter hanya perlu dibuat untuk atribut yang memang **boleh diubah** setelah objek dibuat. Jika suatu nilai bersifat rahasia atau tidak boleh diubah, kita dapat **tidak menyediakan Setter**.

Contohnya, atribut seperti `passwordHash` sebaiknya tidak memiliki Setter agar nilainya tidak dapat diubah sembarangan. Dengan demikian, atribut tersebut dapat bersifat **Immutable / Read-Only** dari luar class.

---

### Q3. Mengapa di dalam Constructor disarankan memanggil `setJudul(judul)` daripada `this.judul = judul`?

**A:** Agar **validasi yang terdapat di dalam Setter juga berlaku sejak awal**, yaitu ketika objek pertama kali dibuat melalui Constructor.

Contohnya:

```java
public Buku(String judul) {
    setJudul(judul);
}
```

---

## 📚 Daftar Referensi

[1] W3Schools, **"Java Encapsulation"**. Tersedia di: [tautan](https://www.w3schools.com/java/java_encapsulation.asp)

[2] Petani Kode, **"Belajar Java OOP: Memahami Enkapsulasi (Penyembunyian Data)"**. Tersedia di: [tautan](https://www.petanikode.com/java-oop-encapsulation/)

---

## 🏆 Challenge Praktikan

### Challenge 1 — Class `Anggota`

Buat program sesuai dengan instruksi berikut:

1. Buat class **`Anggota`** di dalam package `model` dengan atribut:
   - `private String idAnggota`
   - `private String nama`
   - `private int umur`

2. Buat **Getter dan Setter** untuk atribut yang diperlukan.

3. Tambahkan validasi pada method `setUmur(int umur)` dengan ketentuan:
   - Umur anggota **minimal 12 tahun**.
   - Jika umur kurang dari `12`, tampilkan pesan error.
   - Jika umur kurang dari `12`, secara otomatis ubah nilai umur menjadi `12`.

4. Uji coba class `Anggota` melalui `MainApp.java` dengan memasukkan umur **8 tahun**.

---

### Challenge 2 — Class `AkunBank`

Buat program sesuai dengan instruksi berikut:

1. Buat class **`AkunBank`** dengan atribut:
   - `private double saldo`

2. Buat method **`getSaldo()`** untuk melihat atau mengambil nilai saldo.

3. Buat method **`setPenyetoran(double jumlah)`** dengan validasi:
   - Jumlah setoran harus **lebih besar dari `0`**.
   - Jika jumlah setoran tidak valid, tampilkan pesan error.

4. Buat method **`setPenarikan(double jumlah)`** dengan validasi:
   - Saldo **tidak boleh menjadi minus** setelah penarikan.
   - Jika jumlah penarikan melebihi saldo, tampilkan pesan error.
   - Jika jumlah penarikan valid, kurangi saldo sesuai jumlah yang ditarik.

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />

<p align="center"><a href="#top">Kembali ke atas</a></p>