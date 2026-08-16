<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

# Topik 2 - Collection

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami pengertian **Collection** dan **Collection Framework** dalam Java.
2. ✅ Memahami konsep dasar **Array** sebagai struktur penyimpanan data dalam Java.
3. ✅ Membuat dan menggunakan **Array** untuk menyimpan sekumpulan data.
4. ✅ Memahami konsep **ArrayList** sebagai salah satu implementasi Collection dalam Java.
5. ✅ Membuat dan menggunakan **ArrayList** untuk menyimpan dan mengelola data.
6. ✅ Memahami perbedaan antara **Array** dan **ArrayList** serta menentukan penggunaannya sesuai kebutuhan program.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat beberapa kata kunci utama yang perlu dipahami fungsi dan penggunaannya:

* **`Collection`** : Sekumpulan *interface* dan *class* yang disediakan Java untuk membantu proses penyimpanan dan pengelolaan data.
* **`Array`** : Struktur data yang digunakan untuk menyimpan beberapa nilai dengan tipe data yang sama dalam satu variabel.
* **`Index`** : Posisi suatu data di dalam Array atau ArrayList yang dimulai dari angka `0`.
* **`ArrayList`** : Salah satu implementasi Collection dalam Java yang digunakan untuk menyimpan dan mengelola sekumpulan data secara dinamis.

---

## 📂 RESOURCES

💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-1/`**

| **File** | **Deskripsi** |
|---|---|
| `Array.java` | Kelas demonstrasi penggunaan Array |
| `ArrayList.java` | Kelas demonstrasi penggunaan ArrayList |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

Sebelum memulai materi ini, pastikan Anda sudah memahami dasar-dasar pemrograman Java dari materi sebelumnya, terutama:

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami dasar-dasar pemrograman Java.
- [ ] Memahami penggunaan variabel, tipe data, operator, percabangan, dan perulangan.
- [ ] Mampu membuat dan menjalankan program Java sederhana.

---

## PART 1: Pengertian Collection
Collection adalah kumpulan objek yang digunakan untuk menyimpan dan mengelola sekumpulan data dalam program Java. Java menyediakan Collection Framework, yaitu sekumpulan interface dan class yang dapat digunakan untuk mempermudah proses penyimpanan dan pengelolaan data.

Collection menyediakan berbagai fitur untuk mengelola data, seperti menambahkan, menghapus, mencari, dan mengakses data sesuai kebutuhan program. Dalam Java, Collection memiliki beberapa bentuk utama, seperti List, Set, dan Map, yang masing-masing memiliki karakteristik dan penggunaan yang berbeda.

## Part 2: Array & ArrayList

### **Array**

Array adalah struktur data yang digunakan untuk menyimpan beberapa data dalam satu variabel. Data yang disimpan dalam Array memiliki tipe data yang sama dan setiap data dapat diakses menggunakan index.

Ukuran Array ditentukan saat Array dibuat dan tidak dapat diubah setelahnya. Index pada Array dimulai dari 0, sehingga elemen pertama berada pada index 0.

**Contoh Kode:**

**Contoh-Kode/Pertemuan-1/Array.java**
```java
public class ContohArray {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("     CONTOH 1: ARRAY KONVENSIONAL         ");
        System.out.println("==========================================");

        // 1. Deklarasi Array String dengan ukuran TETAP (3 slot)
        String[] daftarBuku = new String[3];

        // 2. Mengisi data ke dalam Array berdasarkan Indeks
        daftarBuku[0] = "Pemrograman Java";
        daftarBuku[1] = "Struktur Data";
        daftarBuku[2] = "Basis Data";

        // *CATATAN: Jika kita coba tambah data ke-4 di bawah ini, program akan ERROR
        // (ArrayIndexOutOfBoundsException) karena ukurannya sudah dikunci hanya 3!
        // daftarBuku[3] = "Jaringan Komputer"; 

        // 3. Menampilkan jumlah slot Array (.length)
        System.out.println("Kapasitas/Ukuran Array : " + daftarBuku.length);
        System.out.println("------------------------------------------");

        // 4. Menampilkan semua isi Array menggunakan Perulangan (For Loop)
        System.out.println("Daftar Buku di Array:");
        for (int i = 0; i < daftarBuku.length; i++) {
            System.out.println("Indeks ke-" + i + " : " + daftarBuku[i]);
        }
    }
}
```

* **Membuat Array:**
```java
String[] daftarBuku = new String[3];
```
Membuat Array daftarBuku yang dapat menyimpan 3 data bertipe String.
* **Mengisi Data**
```java
daftarBuku[0] = "Pemrograman Java";
daftarBuku[1] = "Struktur Data";
daftarBuku[2] = "Basis Data";
```
Data dimasukkan berdasarkan index. Index Array dimulai dari 0, sehingga data tersebut berada pada index 0, 1, dan 2.
* **Mengetahui Ukuran Array**
```java
daftarBuku.length
```
length digunakan untuk mengetahui ukuran Array. Pada contoh ini, hasilnya adalah 3.
* **Menampilkan Data**
```java
for (int i = 0; i < daftarBuku.length; i++) {
    System.out.println("Indeks ke-" + i + " : " + daftarBuku[i]);
}
```
Perulangan for digunakan untuk menampilkan seluruh data dalam Array berdasarkan index.

### **ArrayList**

ArrayList adalah salah satu implementasi dari List dalam Collection Framework Java yang digunakan untuk menyimpan dan mengelola sekumpulan data.

Berbeda dengan Array yang memiliki ukuran tetap, ukuran ArrayList dapat bertambah atau berkurang sesuai dengan jumlah data yang disimpan. ArrayList juga menyediakan berbagai method untuk membantu pengelolaan data, seperti add(), remove(), dan get().

**Contoh Kode**


**Contoh-Kode/Pertemuan-1/ArrayList.java**
```java
import java.util.ArrayList;

public class ContohArrayList {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("        CONTOH 2: JAVA ARRAYLIST          ");
        System.out.println("==========================================");

        // 1. Deklarasi ArrayList String (Ukuran FLEKSIBEL/DINAMIS)
        ArrayList<String> daftarBuku = new ArrayList<>();

        // 2. Mengisi data menggunakan method .add()
        // Bebas menambah berapa pun tanpa takut kehabisan slot!
        daftarBuku.add("Pemrograman Java");
        daftarBuku.add("Struktur Data");
        daftarBuku.add("Basis Data");
        daftarBuku.add("Jaringan Komputer"); // Tambah data ke-4 dengan aman!

        // 3. Menampilkan jumlah elemen yang tersimpan (.size())
        System.out.println("Jumlah Elemen Terisi   : " + daftarBuku.size());
        System.out.println("------------------------------------------");

        // 4. Menampilkan semua isi ArrayList menggunakan Perulangan (For Loop)
        System.out.println("Daftar Buku di ArrayList:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            // Mengambil elemen menggunakan method .get(indeks)
            System.out.println("Indeks ke-" + i + " : " + daftarBuku.get(i));
        }
    }
}
```

* **Membuat ArrayList**
```java
ArrayList<String> daftarBuku = new ArrayList<>();
```
Membuat ArrayList bernama daftarBuku yang digunakan untuk menyimpan data bertipe String. Berbeda dengan Array, ArrayList memiliki ukuran yang fleksibel.
* **Menambahkan Data**
```java
daftarBuku.add("Pemrograman Java");
daftarBuku.add("Struktur Data");
daftarBuku.add("Basis Data");
daftarBuku.add("Jaringan Komputer");
```
Method add() digunakan untuk menambahkan data ke dalam ArrayList. Data dapat terus ditambahkan sesuai kebutuhan.
* **Mengetahui Jumlah Data**
```java
daftarBuku.size()
```
Method size() digunakan untuk mengetahui jumlah data yang tersimpan di dalam ArrayList. Pada contoh ini, terdapat 4 data.
* **Menampilkan Data**
```java
for (int i = 0; i < daftarBuku.size(); i++) {
    System.out.println("Indeks ke-" + i + " : " + daftarBuku.get(i));
}
```
Perulangan for digunakan untuk menampilkan seluruh data dalam ArrayList.

Method get(i) digunakan untuk mengambil data berdasarkan index. Sama seperti Array, index ArrayList dimulai dari 0.

### Perbedaan Array & ArrayList
Array dan ArrayList sama-sama digunakan untuk menyimpan sekumpulan data. Namun, keduanya memiliki beberapa perbedaan dalam ukuran, tipe data, dan cara pengelolaan datanya.

| **Aspek** | **Array** | **ArrayList** |
|---|---|---|
| Ukuran | Tetap setelah dibuat | Dapat bertambah atau berkurang |
| Tipe Data | Dapat menyimpan tipe primitif dan objek | Menyimpan objek |
| Akses Data | Menggunakan index | Menggunakan index |
| Menambah Data | Menggunakan index | Menggunakan `add()` |
| Menghapus Data | Tidak memiliki method khusus | Menggunakan `remove()` |
| Jumlah Data | Menggunakan `length` | Menggunakan `size()` |
| Mencari Data | Tidak memiliki method bawaan khusus | Dapat menggunakan `contains()` |

**Contoh Perbandingan:**
- Array
```java
String[] buku = new String[3];

buku[0] = "Java";
buku[1] = "Python";
buku[2] = "C++";

System.out.println(buku.length);
```

- ArrayList
```java
ArrayList<String> buku = new ArrayList<>();

buku.add("Java");
buku.add("Python");
buku.add("C++");

System.out.println(buku.size());
```

Pada kedua contoh tersebut, data dapat diakses berdasarkan index. Perbedaannya, ukuran Array sudah ditentukan sejak awal, sedangkan ArrayList dapat menyesuaikan jumlah data yang ditambahkan.

**Catatan:** ArrayList hanya dapat menyimpan objek. Untuk tipe data primitif seperti int, digunakan wrapper class seperti Integer. Java akan melakukan autoboxing secara otomatis saat nilai tersebut dimasukkan ke dalam ArrayList.

---

## 📚 Referensi

- programiz., "Java Arrays". Tersedia di: [tautan](https://www.programiz.com/java-programming/arrays)
- W3Schools, "Java Arrays". Tersedia di: [tautan](https://www.w3schools.com/java/java_arrays.asp)

---

## 🏆 Challenge Praktikan
1. Buat program menggunakan Array untuk menyimpan 5 nama mahasiswa, kemudian tampilkan seluruh nama tersebut menggunakan perulangan.
2. Buat program menggunakan ArrayList untuk menyimpan beberapa nama buku. Tambahkan minimal 4 buku menggunakan add(), kemudian tampilkan seluruh data dan jumlah buku menggunakan size().
3. Buat program yang menggunakan Array dan ArrayList untuk menyimpan data yang sama. Tampilkan hasilnya dan jelaskan perbedaan cara menambahkan serta mengetahui jumlah data pada keduanya.

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />

<p align="center"><a href="#top">Kembali ke atas</a></p>