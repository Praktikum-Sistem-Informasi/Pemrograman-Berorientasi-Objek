# Topik 10 - Integrasi Database (JDBC dan ORM)

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep dasar JDBC (*Java Database Connectivity*) sebagai jembatan penghubung antara aplikasi Java dan basis data relasional.
2. ✅ Memasang *dependency* driver database pada proyek Java Maven.
3. ✅ Membangun koneksi ke basis data menggunakan `DriverManager` dan `Connection`, serta menguji apakah koneksi berhasil sebelum melangkah lebih jauh.
4. ✅ Mengimplementasikan `PreparedStatement` untuk menjalankan query **CRUD** (*Create, Read, Update, Delete*) secara aman dari serangan *SQL Injection*.
5. ✅ Mengolah hasil query menggunakan `ResultSet` dan memetakannya ke dalam objek `Model`.
7. ✅ Memahami konsep dasar **ORM** (*Object-Relational Mapping*) sebagai pembanding tingkat lanjut dari JDBC murni.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat 5 kata kunci utama yang wajib Anda pahami fungsi dan dampaknya:

* **`Driver`** : *library* penghubung antara Java dengan mesin basis data tertentu (contoh: MySQL Connector/J). Tanpa driver ini, Java tidak mengerti dengan MySQL.
* **`Connection`** : Representasi objek dari sebuah sesi/jalur komunikasi yang sedang aktif antara aplikasi Java dan basis data.
* **`PreparedStatement`** : Objek untuk menjalankan perintah SQL yang parameternya (`?`) diisi secara terpisah, sehingga lebih **aman** dan **efisien** dibanding `Statement` biasa.
* **`ResultSet`** : Objek penampung hasil query `SELECT` berbentuk tabel virtual, dibaca baris demi baris menggunakan `rs.next()`.
* **`ORM (Object-Relational Mapping)`** : Teknik pemetaan otomatis antara objek Java dan baris tabel basis data, sehingga developer tidak perlu menulis query SQL secara manual (contoh: Hibernate, JPA).

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `contoh_kode/topik_10`**
> 💾 **Database yang digunakan: `db_perpustakaan`, tabel `buku`**

| File | Deskripsi |
| :--- | :--- |
| `db_perpustakaan.sql` | Script SQL pembuatan database & tabel `buku` |
| `pom.xml` | Konfigurasi *dependency* Maven (MySQL Connector/J) |
| `src/koneksi/Koneksi.java` | Kelas penghubung ke basis data MySQL |
| `src/model/Buku.java` | *Blueprint* objek `Buku` merepresentasikan satu baris tabel |
| `src/dao/BukuDAO.java` | *Data Access Object* — kumpulan query CRUD murni JDBC |
| `src/controller/BukuController.java` | Jembatan logika antara `view` dan `dao` |
| `src/view/BukuView.java` | Tampilan antarmuka berbasis konsol |
| `src/main/TestKoneksi.java` | Kelas uji coba koneksi awal ke basis data |
| `src/main/MainApp.java` | Kelas utama untuk menjalankan aplikasi CRUD Perpustakaan |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] **Laragon / XAMPP** sudah terinstall dan **service-nya berjalan (Start)**.
- [ ] **Apache NetBeans IDE** / IDE pilihan sudah terbuka.
- [ ] Proyek dibuat sebagai **Java Maven Project**.
- [ ] Tools klien database phpMyAdmin untuk mengecek isi tabel secara visual.
- [ ] Memahami konsep *Encapsulation* (Getter/Setter) dan *Constructor* dari pertemuan-pertemuan sebelumnya.

---

## 🚀 PART 1: Pemahaman Konsep

```
   ┌─────────────┐        JDBC Driver        ┌─────────────────────┐
   │  Aplikasi   │  ───────────────────────▶  │   Basis Data MySQL  │
   │    Java     │  ◀───────────────────────  │  (db_perpustakaan)  │
   └─────────────┘        ResultSet           └─────────────────────┘
        │
        ▼
 Connection → PreparedStatement → executeUpdate()/executeQuery() → ResultSet
```

> 📌 **ANALOGI DUNIA NYATA:**
> - JDBC ibarat **penerjemah** di antara dua orang yang berbeda bahasa.
> - Aplikasi Java "berbicara" dalam bahasa objek (`class`, `object`), sedangkan basis data "berbicara" dalam bahasa tabel (`SQL`). **Driver JDBC** menjembatani keduanya agar saling memahami.

---

### 1. Apa itu JDBC?

*JDBC (Java Database Connectivity)* adalah **API standar** milik Java yang berfungsi menghubungkan aplikasi Java dengan berbagai jenis basis data relasional (MySQL, PostgreSQL, Oracle, dll), tanpa mengubah cara penulisan kode Java secara drastis — cukup mengganti *driver* dan *connection string*-nya saja.

* **Mengapa Data Perlu Disimpan Permanen?**
  Selama ini (Pertemuan 1–9), data yang kita buat hanya tersimpan di `ArrayList` yang berada di **RAM**. Begitu program ditutup, seluruh data **hilang**. JDBC memungkinkan data tersimpan secara **permanen** di *disk* melalui basis data, sehingga tetap ada meskipun program dimatikan dan dijalankan ulang.

---

### 2. Arsitektur & Alur Kerja JDBC

| Komponen | Fungsi |
| :--- | :--- |
| **Driver** | "Penerjemah" khusus untuk satu jenis basis data (contoh: `mysql-connector-j` untuk MySQL). |
| **DriverManager** | Kelas bawaan Java yang mencari driver yang cocok dan membuka koneksi baru. |
| **Connection** | Representasi "jalur telepon" yang sedang tersambung antara Java dan basis data. |
| **PreparedStatement** | "Formulir" query SQL yang parameternya (`?`) diisi secara terpisah dan aman. |
| **ResultSet** | "Keranjang" hasil query `SELECT`, dibaca baris per baris. |

Alur baku penggunaan JDBC selalu mengikuti pola berikut:

```
1. Muat Driver          → (otomatis sejak JDBC 4.0, cukup pasang dependency)
2. Buka Koneksi          → DriverManager.getConnection(URL, USER, PASSWORD)
3. Siapkan Query         → connection.prepareStatement(sql)
4. Eksekusi Query        → executeUpdate() [INSERT/UPDATE/DELETE] atau executeQuery() [SELECT]
5. Olah Hasil (jika ada) → ResultSet.next()
6. Tutup Koneksi         → connection.close()
```

> 💡 **Praktik Terbaik: `try-with-resources`**
> `Connection`, `PreparedStatement`, dan `ResultSet` adalah *resource* yang **wajib ditutup** setelah dipakai. Gunakan blok `try (...) { }` agar Java **menutupnya secara otomatis**, meskipun terjadi error di tengah jalan.

---

### 3. Statement vs PreparedStatement (Mengapa Wajib Pakai PreparedStatement?)

| Karakteristik | `Statement` | `PreparedStatement` |
| :--- | :--- | :--- |
| **Cara Menulis Query** | Digabung manual dengan *string concatenation* (`+`). | Menggunakan parameter placeholder `?`. |
| **Keamanan** | **Rentan SQL Injection**. | **Aman** dari SQL Injection. |
| **Performa** | Query dikompilasi ulang setiap eksekusi. | Query bisa dikompilasi sekali, dieksekusi berkali-kali. |
| **Rekomendasi** | ❌ Hindari untuk input dari pengguna. | ✅ Wajib digunakan sebagai standar. |

**Contoh bahaya SQL Injection dengan `Statement`:**

```java
// ❌ BERBAHAYA — jangan pernah menulis kode seperti ini!
String idInput = "B001' OR '1'='1"; // input jahat dari pengguna
String sql = "SELECT * FROM buku WHERE id_koleksi = '" + idInput + "'";
// Query yang terbentuk: SELECT * FROM buku WHERE id_koleksi = 'B001' OR '1'='1'
// Akibatnya: SELURUH DATA BUKU akan tampil, bukan hanya satu baris!
```

**Solusi aman dengan `PreparedStatement`:**

```java
// ✅ AMAN — input pengguna diperlakukan murni sebagai DATA, bukan perintah SQL
String sql = "SELECT * FROM buku WHERE id_koleksi = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, idInput); // Nilai "B001' OR '1'='1" tetap dianggap satu string biasa
```

---

### 4. Struktur Folder Proyek (Arsitektur Berlapis)

Agar kode rapi, mudah dirawat, dan siap dihubungkan ke GUI, kita memisahkan tanggung jawab tiap kelas ke dalam paket (*folder*) berikut:

```
src/
 ├── main/       → Titik masuk program (MainApp, TestKoneksi)
 ├── koneksi/    → Kelas penghubung ke basis data (Koneksi)
 ├── model/      → Blueprint objek yang merepresentasikan satu baris tabel (Buku)
 ├── dao/        → Data Access Object, berisi query SQL murni (BukuDAO)
 ├── controller/    → Jembatan logika antara view dan dao (BukuController)
 └── view/       → Tampilan antarmuka untuk pengguna (BukuView)
```

| Lapisan | Tugas | Analoginya |
| :--- | :--- | :--- |
| **Model** | Menyimpan data satu entitas (atribut + getter/setter). | "Formulir kosong" data Buku. |
| **DAO** | Satu-satunya lapisan yang **boleh** menulis SQL & bicara ke basis data. | "Petugas gudang" yang tahu cara mengambil/menaruh barang. |
| **Controller** | Mengatur logika, memanggil DAO, meneruskan hasil ke View. | "Manajer" penghubung antara pelanggan dan gudang. |
| **View** | Berinteraksi dengan pengguna (input/output). | "Kasir" yang melayani pelanggan langsung. |

> 📌 Dengan pemisahan ini, kelak saat *view* berbasis konsol diganti menjadi GUI, **lapisan `dao` dan `controller` tidak perlu diubah sama sekali** — cukup ganti `view`-nya saja!

---

### 5. Pengenalan ORM (Object-Relational Mapping) — Sebagai Pembanding

Setelah memahami JDBC murni, penting untuk mengenal **ORM** sebagai pendekatan alternatif tingkat lanjut yang umum dipakai di industri (contoh *framework*: **Hibernate**, **JPA/Jakarta Persistence**, **Spring Data JPA**).

| Aspek | JDBC Murni | ORM (Hibernate/JPA) |
| :--- | :--- | :--- |
| **Penulisan Query** | Manual, SQL ditulis sendiri baris per baris. | Otomatis, cukup panggil method seperti `save()`, `find()`. |
| **Pemetaan Objek ↔ Tabel** | Manual (`rs.getString(...)` satu per satu). | Otomatis via anotasi (`@Entity`, `@Column`, `@Id`). |
| **Kontrol atas Query** | Penuh, sangat fleksibel. | Sebagian tersembunyi (di-*generate* otomatis). |
| **Kurva Belajar** | Lebih mudah dipahami dasarnya. | Perlu memahami konsep tambahan (*Session*, *EntityManager*). |
| **Cocok untuk** | Memahami fondasi cara kerja database, proyek kecil-menengah. | Proyek besar & kompleks, mempercepat pengembangan. |

**Gambaran singkat kode ORM (JPA/Hibernate) untuk tabel `buku` yang sama:**

```java
@Entity
@Table(name = "buku")
public class Buku {
    @Id
    @Column(name = "id_koleksi")
    private String idKoleksi;

    private String judul;
    private String penulis;

    @Column(name = "tahun_terbit")
    private int tahunTerbit;

    private int stok;
    // getter & setter ...
}
```

```java
// Menyimpan data cukup satu baris — tanpa menulis SQL sama sekali
entityManager.persist(bukuBaru);

// Mengambil data cukup satu baris
Buku b = entityManager.find(Buku.class, "B001");
```

> 💡 **Kesimpulan Perbandingan:** JDBC mengajarkan Anda **cara kerja database dari akar**, sedangkan ORM membuat Anda **lebih cepat produktif** setelah fondasinya kuat. Materi ini berfokus pada JDBC agar Anda memahami *apa yang sebenarnya terjadi di balik layar* sebelum nanti menggunakan ORM di proyek yang lebih besar.

---

## 💻 PART 2: Live Coding

### Step 0: Membuat Basis Data & Tabel (`db_perpustakaan.sql`)

Jalankan script berikut di phpMyAdmin / MySQL Workbench / terminal MySQL:

```sql
CREATE DATABASE IF NOT EXISTS db_perpustakaan;
USE db_perpustakaan;

CREATE TABLE buku (
    id_koleksi   VARCHAR(10)  PRIMARY KEY,
    judul        VARCHAR(150) NOT NULL,
    penulis      VARCHAR(100) NOT NULL,
    tahun_terbit INT          NOT NULL,
    stok         INT          NOT NULL DEFAULT 0
);

INSERT INTO buku VALUES
('B001', 'Pemrograman Java Dasar', 'James Gosling', 2023, 5),
('B002', 'Struktur Data & Algoritma', 'Ada Lovelace', 2022, 3);
```

> ✅ **Cek hasil:** Buka tabel `buku` di phpMyAdmin, pastikan 2 baris data contoh sudah muncul.

---

### Step 1: Memasang *Dependency* Driver MySQL (`pom.xml`)

Buka folder `Project Files` lalu Buka file `pom.xml` di NetBeans, tambahkan tag `<dependencies>` berikut sebelum tag penutup `</project>`:

```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>
</dependencies>
```

> 💡 Setelah menambahkan,bisa klik `Ctrl+S` atau klik kanan proyek → **Reload/Reimport Maven Project** agar NetBeans/IntelliJ mengunduh *library*-nya. Tanpa langkah ini, `import java.sql.*` bisa berjalan (bawaan JDK), tetapi Java **tidak akan menemukan driver MySQL yang cocok** saat koneksi dibuka.

---

### Step 2: Membuat Kelas Koneksi (`src/koneksi/Koneksi.java`)

```java
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/db_perpustakaan";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // sesuaikan dengan password MySQL Anda

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Koneksi database GAGAL: " + e.getMessage());
        }
        return conn;
    }
}
```

> 📌 **Bedah `URL`:** `jdbc:mysql://localhost:3306/db_perpustakaan`
> `jdbc:mysql://` (protokol) + `localhost:3306` (alamat & port server MySQL) + `db_perpustakaan` (nama database tujuan).

---

### Step 3: Menguji Koneksi Awal (`src/main/TestKoneksi.java`)

**Sebelum menulis kode CRUD apa pun**, wajib memastikan koneksi ke basis data sudah benar-benar terhubung.

```java
package main;

import java.sql.Connection;
import koneksi.Koneksi;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection conn = Koneksi.getConnection();

        if (conn != null) {
            System.out.println("Koneksi ke database BERHASIL!");
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi database GAGAL. Periksa kembali URL, USER, PASS, dan pastikan service MySQL sudah menyala.");
        }
    }
}
```

> ✅ **Jalankan `TestKoneksi.java` terlebih dahulu** dengan klik kanan pada file lalu pilin `run file`. Jika muncul pesan "GAGAL", **jangan lanjut** ke tahap berikutnya periksa dulu service MySQL, nama database, atau password.

---

### Step 4: Membuat Model (`src/model/Buku.java`)

```java
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
```

---

### Step 5: Membuat DAO — Lapisan CRUD Murni JDBC (`src/dao/BukuDAO.java`)

Ini adalah **inti** dari materi satu-satunya kelas yang boleh berisi query SQL.

```java
package dao;

import koneksi.Koneksi;
import model.Buku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {

    // CREATE
    public boolean tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (id_koleksi, judul, penulis, tahun_terbit, stok) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, buku.getIdKoleksi());
            ps.setString(2, buku.getJudul());
            ps.setString(3, buku.getPenulis());
            ps.setInt(4, buku.getTahunTerbit());
            ps.setInt(5, buku.getStok());

            return ps.executeUpdate() > 0; // true jika ada baris yang berhasil ditambahkan

        } catch (SQLException e) {
            System.out.println("Gagal menambah buku: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Buku> tampilkanSemuaBuku() {
        List<Buku> daftarBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Buku b = new Buku(
                        rs.getString("id_koleksi"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getInt("tahun_terbit"),
                        rs.getInt("stok")
                );
                daftarBuku.add(b);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data buku: " + e.getMessage());
        }
        return daftarBuku;
    }

    //READ ID
    public Buku cariBukuById(String idKoleksi) {
        String sql = "SELECT * FROM buku WHERE id_koleksi = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKoleksi);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Buku(
                            rs.getString("id_koleksi"),
                            rs.getString("judul"),
                            rs.getString("penulis"),
                            rs.getInt("tahun_terbit"),
                            rs.getInt("stok")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Gagal mencari buku: " + e.getMessage());
        }
        return null; // tidak ditemukan
    }

    //UPDATE
    public boolean updateBuku(Buku buku) {
        String sql = "UPDATE buku SET judul = ?, penulis = ?, tahun_terbit = ?, stok = ? WHERE id_koleksi = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPenulis());
            ps.setInt(3, buku.getTahunTerbit());
            ps.setInt(4, buku.getStok());
            ps.setString(5, buku.getIdKoleksi());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal update buku: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean hapusBuku(String idKoleksi) {
        String sql = "DELETE FROM buku WHERE id_koleksi = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKoleksi);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus buku: " + e.getMessage());
            return false;
        }
    }
}
```

> 📌 Perhatikan pola `executeUpdate()` vs `executeQuery()`:
> * `executeUpdate()` → dipakai untuk **INSERT, UPDATE, DELETE** (mengembalikan jumlah baris yang terpengaruh).
> * `executeQuery()` → dipakai khusus untuk **SELECT** (mengembalikan `ResultSet`).

---

### Step 6: Membuat Controller (`src/controller/BukuController.java`)

```java
package controller;

import dao.BukuDAO;
import model.Buku;

import java.util.List;

public class BukuController {

    private BukuDAO bukuDAO = new BukuDAO();

    public boolean tambahBuku(String id, String judul, String penulis, int tahun, int stok) {
        Buku buku = new Buku(id, judul, penulis, tahun, stok);
        return bukuDAO.tambahBuku(buku);
    }

    public List<Buku> getSemuaBuku() {
        return bukuDAO.tampilkanSemuaBuku();
    }

    public Buku cariBuku(String id) {
        return bukuDAO.cariBukuById(id);
    }

    public boolean updateBuku(String id, String judul, String penulis, int tahun, int stok) {
        Buku buku = new Buku(id, judul, penulis, tahun, stok);
        return bukuDAO.updateBuku(buku);
    }

    public boolean hapusBuku(String id) {
        return bukuDAO.hapusBuku(id);
    }
}
```

> 💡 `controller` **tidak tahu-menahu soal SQL**. Ia hanya menerima data mentah dari `view`, membentuknya menjadi objek `Buku`, lalu menitipkannya ke `dao`. Inilah yang membuat `view` nantinya bisa diganti ke GUI **tanpa menyentuh `dao` maupun `controller` sama sekali**.

---

### Step 7: Membuat View (`src/view/BukuView.java`)

```java
package view;

import controller.BukuController;
import model.Buku;

import java.util.List;
import java.util.Scanner;

public class BukuView {

    private BukuController controller = new BukuController();
    private Scanner scanner = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\n=== MENU PERPUSTAKAAN (db_perpustakaan) ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Cari Buku berdasarkan ID");
            System.out.println("4. Update Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1 -> tambahBuku();
                case 2 -> lihatSemuaBuku();
                case 3 -> cariBuku();
                case 4 -> updateBuku();
                case 5 -> hapusBuku();
                case 0 -> System.out.println("Program selesai. Sampai jumpa!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    private void tambahBuku() {
        System.out.print("ID Koleksi   : ");
        String id = scanner.nextLine();
        System.out.print("Judul        : ");
        String judul = scanner.nextLine();
        System.out.print("Penulis      : ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit : ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok         : ");
        int stok = Integer.parseInt(scanner.nextLine());

        boolean berhasil = controller.tambahBuku(id, judul, penulis, tahun, stok);
        System.out.println(berhasil ? "✅ Buku berhasil ditambahkan!" : "❌ Gagal menambahkan buku.");
    }

    private void lihatSemuaBuku() {
        List<Buku> daftarBuku = controller.getSemuaBuku();
        System.out.println("\n--- DAFTAR SELURUH BUKU ---");
        if (daftarBuku.isEmpty()) {
            System.out.println("(Belum ada data buku)");
        }
        for (Buku b : daftarBuku) {
            System.out.println(b);
        }
    }

    private void cariBuku() {
        System.out.print("Masukkan ID Koleksi: ");
        String id = scanner.nextLine();
        Buku b = controller.cariBuku(id);
        System.out.println(b != null ? b : "❌ Buku dengan ID tersebut tidak ditemukan.");
    }

    private void updateBuku() {
        System.out.print("ID Koleksi yang akan diupdate : ");
        String id = scanner.nextLine();
        System.out.print("Judul baru        : ");
        String judul = scanner.nextLine();
        System.out.print("Penulis baru      : ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit baru : ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok baru         : ");
        int stok = Integer.parseInt(scanner.nextLine());

        boolean berhasil = controller.updateBuku(id, judul, penulis, tahun, stok);
        System.out.println(berhasil ? "✅ Buku berhasil diupdate!" : "❌ Gagal update buku (pastikan ID benar).");
    }

    private void hapusBuku() {
        System.out.print("ID Koleksi yang akan dihapus: ");
        String id = scanner.nextLine();
        boolean berhasil = controller.hapusBuku(id);
        System.out.println(berhasil ? "✅ Buku berhasil dihapus!" : "❌ Gagal menghapus buku (pastikan ID benar).");
    }
}
```

---

### Step 8: Menjalankan Aplikasi (`src/main/MainApp.java`)

```java
package main;

import view.BukuView;

public class MainApp {
    public static void main(String[] args) {
        BukuView view = new BukuView();
        view.tampilkanMenu();
    }
}
```

> ✅ **Verifikasi akhir:** Setelah menambah/mengubah/menghapus data lewat program, **buka kembali tabel `buku` di phpMyAdmin** dan pastikan perubahan benar-benar tersimpan **permanen**, inilah bedanya dengan `ArrayList` di RAM pada pertemuan-pertemuan sebelumnya.

---

## ⚡ PART 3: EKSPERIMEN ERROR

### 🎯 Eksperimen 1: Lupa Memasang *Dependency* Driver

**Tindakan:** Hapus sementara blok `<dependency>` MySQL Connector/J dari `pom.xml`, lalu jalankan `TestKoneksi.java`.

* **Hasil:** `SQLException: No suitable driver found for jdbc:mysql://localhost:3306/db_perpustakaan`
* **Pelajaran:** `DriverManager` mencari driver yang sesuai dengan URL koneksi di antara *library* yang terpasang di proyek. Jika *dependency* driver tidak ada / belum di-*reload*, Java tidak akan pernah menemukan "penerjemah" yang tepat.

---

### 🎯 Eksperimen 2: Salah Nama Database / Password / Service Mati

**Tindakan:** Ubah `PASS` di `Koneksi.java` menjadi sembarang teks yang salah, atau matikan service MySQL di Laragon.

* **Hasil:** `SQLException: Access denied for user 'root'@'localhost'` atau `Communications link failure`.
* **Pelajaran:** Selalu cek 3 hal saat koneksi gagal: **(1)** service MySQL sudah menyala, **(2)** nama database sudah benar, **(3)** *username/password* sudah sesuai.

---

### 🎯 Eksperimen 3: SQL Injection dengan `Statement` (Bukan `PreparedStatement`)

**Tindakan:** Ganti sementara method `cariBukuById` menggunakan `Statement` dan *string concatenation*:

```java
String sql = "SELECT * FROM buku WHERE id_koleksi = '" + idKoleksi + "'";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(sql);
```

Lalu jalankan program dan masukkan input berikut saat diminta ID Koleksi:

```
B001' OR '1'='1
```

* **Hasil:** Alih-alih "tidak ditemukan", program justru menampilkan **seluruh isi tabel buku**.
* **Pelajaran:** *String concatenation* memperlakukan input pengguna sebagai bagian dari **perintah SQL**, bukan sekadar data. Selalu gunakan `PreparedStatement` dengan `?` agar input pengguna murni diperlakukan sebagai **nilai**, bukan **perintah**.

---

### 🎯 Eksperimen 4: Lupa Menutup Koneksi (*Connection Leak*)

**Tindakan:** Tulis ulang salah satu method DAO **tanpa** `try-with-resources`, dan sengaja tidak memanggil `conn.close()`.

```java
// ❌ Berbahaya: koneksi tidak pernah ditutup
Connection conn = Koneksi.getConnection();
PreparedStatement ps = conn.prepareStatement(sql);
ps.executeUpdate();
// conn.close() tidak dipanggil!
```

* **Hasil:** Jika method ini dipanggil berulang kali (misalnya lewat *looping*), lama-kelamaan akan muncul error `Too many connections` dari server MySQL.
* **Pelajaran:** Setiap `Connection` yang dibuka **wajib ditutup**, idealnya menggunakan `try-with-resources` agar tertutup otomatis meski terjadi *exception*.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `No suitable driver found` | *Dependency* driver MySQL belum terpasang / belum di-*reload* Maven. | Cek `pom.xml`, lalu klik kanan proyek → *Reload Maven Project*. |
| `Communications link failure` | Service MySQL/Laragon belum dinyalakan, atau port/host salah. | Nyalakan service MySQL di Laragon, cek kembali URL koneksi. |
| `Access denied for user` | *Username* atau *password* pada `Koneksi.java` salah. | Samakan dengan kredensial MySQL yang sebenarnya. |
| `Unknown database 'db_perpustakaan'` | Database belum dibuat / salah ketik nama database. | Jalankan ulang script `db_perpustakaan.sql`. |
| `Too many connections` | Koneksi (`Connection`) tidak pernah ditutup (*connection leak*). | Gunakan `try-with-resources` pada setiap operasi DAO. |
| Data hilang saat program ditutup | Masih memakai `ArrayList` sebagai penyimpanan, bukan tabel database. | Pastikan operasi CRUD memanggil `BukuDAO`, bukan koleksi di RAM. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Mengapa harus membuat `TestKoneksi.java` terpisah, tidak langsung membuat fitur CRUD saja?**

> **A:** Prinsip *"divide and conquer"* dalam debugging. Jika koneksi ke database saja belum berhasil, maka fitur CRUD apa pun **pasti akan gagal** dan pesan error-nya bisa membingungkan karena bercampur dengan logika CRUD. Dengan menguji koneksi terlebih dahulu secara terpisah, kita bisa memastikan "jalur dasar" sudah benar sebelum membangun fitur di atasnya.

**Q: Kenapa `dao` harus dipisah dari `controller`? Bukankah bisa saja query SQL langsung ditulis di `controller`?**

> **A:** Bisa saja secara teknis, tetapi akan menyulitkan perawatan kode. Dengan memisahkan `dao`, seluruh query SQL terkumpul di satu tempat. Jika suatu saat basis data berpindah dari MySQL ke PostgreSQL, atau bahkan berganti ke pendekatan ORM, **cukup ubah isi `dao`** — `controller` dan `view` tidak perlu disentuh sama sekali.

**Q: Apakah `ORM` akan sepenuhnya menggantikan JDBC?**

> **A:** Tidak sepenuhnya. ORM (seperti Hibernate/JPA) sebenarnya **dibangun di atas JDBC** — di balik layar, ORM tetap menggunakan `Connection` dan `PreparedStatement` untuk berkomunikasi dengan basis data, hanya saja prosesnya diotomatisasi. Memahami JDBC terlebih dahulu membuat Anda lebih mudah memahami *apa yang sebenarnya terjadi* saat menggunakan ORM nanti.

**Q: Kapan sebaiknya memilih JDBC murni dibanding ORM?**

> **A:** Gunakan **JDBC murni** untuk proyek kecil-menengah, tugas kuliah, atau saat Anda ingin kontrol penuh atas query yang dijalankan (misalnya query yang kompleks dan perlu dioptimasi manual). Gunakan **ORM** untuk proyek besar dengan banyak tabel yang saling berelasi, di mana kecepatan pengembangan menjadi prioritas.

---

## 🔗 Daftar Referensi

[1] Oracle Docs, "JDBC Basics — The Java Tutorials". Tersedia di: [tautan](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)

[2] Dicoding Blog, "Mengenal JDBC (Java Database Connectivity)". Tersedia di: [tautan](https://www.dicoding.com/blog/)

[3] Baeldung, "Introduction to JPA with Hibernate". Tersedia di: [tautan](https://www.baeldung.com/learn-jpa-hibernate)

[4] W3Schools, "Java MySQL Database". Tersedia di: [tautan](https://www.w3schools.com/java/java_mysql.asp)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Buat program sesuai instruksi berikut (masih memakai basis data `db_perpustakaan`):

   a) Tambahkan kolom baru `jenis` (VARCHAR) pada tabel `buku` menggunakan query `ALTER TABLE`.

   b) Perbarui `Buku.java`, `BukuDAO.java`, `BukuController.java`, dan `BukuView.java` agar mendukung atribut `jenis` di seluruh proses CRUD.

2. Buat program sesuai instruksi berikut:

   a) Buat method baru `cariBerdasarkanJudul(String kataKunci)` pada `BukuDAO.java` yang menggunakan klausa SQL `LIKE` (contoh: `WHERE judul LIKE ?` dengan nilai `"%" + kataKunci + "%"`).

   b) Tambahkan menu baru di `BukuView.java` untuk memanggil fitur pencarian ini.

3. Buat program sesuai instruksi berikut:

   a) Buat method `hitungTotalStok()` pada `BukuDAO.java` yang menghitung total seluruh stok buku menggunakan fungsi agregat SQL `SUM(stok)`.

   b) Tampilkan hasilnya di menu `BukuView.java` sebagai fitur "Lihat Total Stok Perpustakaan".

4. **(Eksplorasi Mandiri)** Cari tahu perbedaan antara `executeUpdate()` dan `executeBatch()`. Kapan `executeBatch()` lebih menguntungkan digunakan?

---
