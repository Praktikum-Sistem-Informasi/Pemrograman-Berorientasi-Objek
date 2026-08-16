<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

# Topik 1 - Dasar Pemrograman Java

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Membuat, mengompilasi, dan menjalankan program Java sederhana menggunakan NetBeans.
2. ✅ Menjelaskan struktur dasar program Java, seperti **class**, method `main()`, dan statement.
3. ✅ Mendeklarasikan dan menggunakan **variabel serta tipe data** dalam Java.
4. ✅ Menggunakan berbagai jenis **operator**, seperti operator aritmatika, relasi, dan logika.
5. ✅ Menerapkan **percabangan** menggunakan `if-else`, `if-else if`, dan `switch`.
6. ✅ Menerapkan **perulangan** menggunakan `for`, `while`, dan `do-while`.
7. ✅ Membuat program sederhana dengan menggabungkan variabel, operator, percabangan, dan perulangan.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat kata kunci utama yang wajib Anda pahami fungsi dan penggunaannya:

* **`JDK & NetBeans`** : JPerangkat yang digunakan untuk mengembangkan, mengompilasi, dan menjalankan program Java, sedangkan NetBeans IDE yang digunakan untuk menulis, mengelola, mengompilasi, dan menjalankan program Java.
* **`Class`** : Struktur dasar dalam Java yang digunakan sebagai tempat mendefinisikan data dan perilaku program.
* **`main()`** : Fungsi/method utama yang menjadi pintu masuk pertama kali saat program Java dijalankan.
* **`Variabel`** : Tempat untuk menyimpan suatu nilai atau data yang dapat digunakan dalam program.
* **`Tipe Data`** : Menentukan jenis data yang dapat disimpan dalam sebuah variabel, seperti `int`, `double`, `char`, `boolean`, dan `String`.
* **`Operator`** : Simbol khusus untuk melakukan kalkulasi data, perbandingan nilai, hingga operasi logika (seperti +, ==, &&).
* **`Percabangan`** : Struktur kontrol yang digunakan untuk menentukan tindakan berdasarkan suatu kondisi.
* **`Perulangan`** : Struktur kontrol yang digunakan untuk menjalankan suatu blok kode secara berulang.

---

## 📂 RESOURCES

💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-1/`**

| **File** | **Deskripsi** |
|---|---|
| `Dasar_Pemrograman_Java.java` | Kelas utama demonstrasi struktur dasar program |
---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Mengetahui lokasi folder penyimpanan untuk menyimpan seluruh file project praktikum.

--- 

## PART 1: Membuat Project di NetBeans
1. Buka aplikasi **Apache NetBeans**.
<img width="1600" height="900" alt="WhatsApp Image 2026-08-12 at 23 34 11" src="https://github.com/user-attachments/assets/7b9e7c9a-9ce9-4170-a93d-0a3e280346e5" />

3. Pilih menu **File → New Project**, atau klik ikon **New Project** (ikon folder berwarna
coklat), atau tekan **Ctrl + Shift + N**. Pada jendela yang muncul, pilih kategori **Java with Ant** dan
jenis project **Java Application**, lalu klik Next.
<img width="1600" height="900" alt="WhatsApp Image 2026-08-12 at 23 38 58" src="https://github.com/user-attachments/assets/c38be79a-19f8-404c-9148-373be5eea18a" />
<img width="1600" height="900" alt="WhatsApp Image 2026-08-12 at 23 39 07" src="https://github.com/user-attachments/assets/1b2ed458-1a0f-4c77-8641-c594b13c926f" />

4. Beri nama project (misal: `Pertemuan1_DasarJava`) dan tentukan lokasi penyimpanannya.
<img width="1600" height="901" alt="WhatsApp Image 2026-08-15 at 09 08 44" src="https://github.com/user-attachments/assets/524ba1a6-0b18-4a9d-b135-937b38d03c65" />

5. Klik **Finish** untuk membuat project baru..

---

## PART 2: Struktur Dasar Program Java

### Struktur Dasar
Struktur dasar dari sebuah program Java terdiri dari sebuah kelas utama (main class) yang di dalamnya terdapat fungsi utama (main()). Fungsi main ini adalah pintu masuk utama (entry point) program. Ketika program dijalankan, semua perintah di dalam fungsi main akan dieksekusi secara berurutan dari atas ke bawah.

```
                 ┌──────────────────────────────┐
                 │    KODE PROGRAM JAVA (.java) │
                 │                              │
                 │  public class NamaClass     │
                 └──────────────┬───────────────┘
                                │
                    Dikompilasi oleh JDK
                                │
                                ▼
                 ┌──────────────────────────────┐
                 │    BYTECODE JAVA (.class)    │
                 └──────────────┬───────────────┘
                                │
                       Menjalankan main()
                                │
                                ▼
                 ┌──────────────────────────────┐
                 │ public static void main(...) │
                 │       Entry Point Program    │
                 └──────────────┬───────────────┘
                                │
                  ┌─────────────┴─────────────┐
                  │                           │
                  ▼                           ▼
        ┌───────────────────┐       ┌───────────────────┐
        │    PERCABANGAN    │       │     PERULANGAN    │
        │                   │       │                   │
        │ if-else           │       │ for               │
        │ if-else if        │       │ while             │
        │ switch            │       │ do-while          │
        └───────────────────┘       └───────────────────┘
```

Perhatikan contoh kode program sistem perpustakaan berikut beserta penjelasannya:

```java
package pertemuan1_dasarjava;
    
public class Pertemuan1_DasarJava {

    public static void main(String[] args) {
        // Perintah untuk menampilkan teks ke layar
        System.out.println("Selamat Datang di Pemrograman Java!");
    }
}
```

1. **`package pertemuan1_dasarjava;`**
Menandakan nama folder atau kelompok tempat file Java ini disimpan.
2. **`public class Pertemuan1_DasarJava`**
Mendefinisikan nama kelas utama. Nama kelas wajib sama persis dengan nama file .java (contoh: Pertemuan1_DasarJava.java).
3. **`public static void main(String[] args)`**
Fungsi utama yang akan dipanggil dan dijalankan pertama kali oleh Java saat program mulai dibuka.
4. **`System.out.println(...)`**
Perintah standar di Java untuk menampilkan teks atau nilai ke layar (output).
5. **`Aturan Penamaan (Naming Convention)`**
Dalam penulisan kode Java, terdapat standar penamaan yang sangat disarankan agar kode rapi dan mudah dibaca oleh developer lain:
    - **PascalCase:** Digunakan untuk penamaan Kelas (Class). Huruf pertama di setiap kata ditulis dengan huruf besar tanpa spasi. Contoh: SistemPerpustakaan, PerpustakaanDigital, atau BukuTeks.
    - **camelCase:** Digunakan untuk penamaan Variabel dan Fungsi/Method. Kata pertama diawali dengan huruf kecil, sedangkan kata-kata berikutnya diawali dengan huruf besar. Contoh: judulBuku, jumlahHalaman, atau hitungDenda().

### Output
Untuk menampilkan data atau teks ke layar konsol, digunakan perintah berikut:
- System.out.println() → mencetak teks ke layar, lalu otomatis berpindah ke baris berikutnya (newline).
- System.out.print() → mencetak teks ke layar tanpa berpindah ke baris berikutnya.

```java
System.out.print("Judul Buku: ");
System.out.println("Laskar Pelangi");
```

### Input
Untuk menerima data yang dimasukkan pengguna melalui keyboard, Java menyediakan class Scanner yang terdapat dalam package **`java.util`**. Agar dapat digunakan, Scanner perlu diimpor terlebih dahulu menggunakan:

```java
import java.util.Scanner;
Scanner input = new Scanner(System.in);
```

Setelah diimpor, objek Scanner dibuat untuk membaca data yang dimasukkan pengguna melalui **`System.in`**:
**`System.in`** digunakan sebagai sumber input dari keyboard. Selanjutnya, method pada Scanner digunakan sesuai dengan jenis data yang ingin dibaca.

Beberapa fungsi pembacaan data yang sering digunakan pada Scanner:
- **`nextLine()`** → membaca input berupa teks atau kalimat (contoh: judul buku, nama peminjam).
- **`nextInt()`** → membaca input berupa angka bulat (contoh: jumlah halaman, stok buku).
- **`nextDouble()`** → membaca input berupa angka desimal (contoh: harga buku, nilai IPK).

```java
import java.util.Scanner;

public class InputBuku {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Buku: ");
        String judulBuku = input.nextLine(); // Membaca teks

        System.out.print("Masukkan Jumlah Halaman: ");
        int jumlahHalaman = input.nextInt(); // Membaca angka

        // Menampilkan kembali data yang dimasukkan pengguna
        System.out.println("\n--- DATA BUKU ---");
        System.out.println("Judul          : " + judulBuku);
        System.out.println("Jumlah Halaman : " + jumlahHalaman + " halaman");
    }
}
```

## PART 3: Variabel dan Tipe Data
Variabel adalah wadah di dalam memori komputer yang digunakan untuk menyimpan data sementara saat program berjalan. Dalam bahasa Java, setiap variabel wajib memiliki tipe data tertentu yang menentukan jenis nilai yang dapat disimpan di dalamnya.

Jenis Tipe Data Dasar
1. **int (integer):** menyimpan bilangan bulat tanpa desimal (contoh: stok buku, jumlah halaman, tahun terbit).
2. **double:** menyimpan bilangan desimal atau pecahan (contoh: 3.14, -8.8).
3. **boolean:** menyimpan nilai logika, hanya bernilai true (benar) atau false (salah) (contoh: status ketersediaan buku).
4. **String:** menyimpan teks atau kumpulan karakter (contoh: judul buku, nama pengarang, kategori).

---

## PART 4: Operator di Java
Operator adalah simbol yang digunakan dalam Java untuk melakukan operasi terhadap nilai atau variabel. Operator dapat digunakan untuk melakukan perhitungan, membandingkan nilai, menggabungkan kondisi, serta mengubah nilai suatu variabel.

Dalam Java, operator dapat dikelompokkan menjadi beberapa jenis, di antaranya:
### Operator Aritmatika
Operator aritmatika digunakan untuk melakukan perhitungan matematika terhadap nilai atau variabel.

| Operator | Nama | Contoh | Hasil |
|:---:|---|:---:|---:|
| `+` | Penjumlahan | `5 + 3` | `8` |
| `-` | Pengurangan | `5 - 3` | `2` |
| `*` | Perkalian | `5 * 3` | `15` |
| `/` | Pembagian | `10 / 2` | `5` |
| `%` | Modulus (Sisa Bagi) | `10 % 3` | `1` |

Contoh kode:

```java
public class Aritmatika {
    public static void main(String[] args) {
        int a = 10, b = 3;

        System.out.println(a + b); // 13
        System.out.println(a - b); // 7
        System.out.println(a * b); // 30
        System.out.println(a / b); // 3
        System.out.println(a % b); // 1
    }
}
```

### Operator Relasi (Perbandingan)
Operator relasi atau operator perbandingan digunakan untuk membandingkan dua nilai.
Hasil dari operasi relasi selalu berupa nilai **boolean**, yaitu:
true → kondisi benar
false → kondisi salah

| Operator | Nama | Contoh | Hasil |
|:---:|---|:---:|:---:|
| `==` | Sama dengan | `5 == 3` | `false` |
| `!=` | Tidak sama dengan | `5 != 3` | `true` |
| `>` | Lebih besar dari | `5 > 3` | `true` |
| `<` | Lebih kecil dari | `5 < 3` | `false` |
| `>=` | Lebih besar atau sama dengan | `5 >= 5` | `true` |
| `<=` | Lebih kecil atau sama dengan | `3 <= 5` | `true` |

**Contoh kode:**

```java
public class Relasi {
    public static void main(String[] args) {
        int a = 10, b = 3;

        System.out.println(a == b); // false
        System.out.println(a != b); // true
        System.out.println(a > b);  // true
        System.out.println(a < b);  // false
        System.out.println(a >= b); // true
        System.out.println(a <= b); // false
    }
}
```

### Operator Logika
Operator logika digunakan untuk menggabungkan atau membalikkan kondisi boolean. Biasanya dipakai pada percabangan (if, switch) atau perulangan.

| Operator | Nama | Contoh | Keterangan |
|:---:|---|---|---|
| `&&` | AND (Dan) | `(x > 3) && (y < 10)` | `true` jika semua kondisi benar |
| `\|\|` | OR (Atau) | `(x > 3) \|\| (y < 10)` | `true` jika minimal satu kondisi benar |
| `!` | NOT (Bukan) | `!(x > 3)` | Membalik nilai boolean |

**Contoh kode:**

```java
public class Logika {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        System.out.println(a && b); // false
        System.out.println(a || b); // true
        System.out.println(!a);     // false
    }
}
```

---

## PART 5: Percabangan
Percabangan (selection statement) adalah struktur kontrol yang digunakan untuk mengatur alur eksekusi program berdasarkan suatu kondisi. Dengan percabangan, program dapat memilih tindakan yang berbeda sesuai dengan hasil evaluasi suatu ekspresi boolean (true atau false).

Dalam Java, terdapat tiga bentuk percabangan yang paling umum digunakan, yaitu if-else, if-else if, dan switch.

### If-Else
if-else merupakan bentuk percabangan paling sederhana yang digunakan ketika program hanya memiliki dua kemungkinan hasil, yaitu kondisi terpenuhi atau tidak terpenuhi.

Alur kerjanya adalah sebagai berikut:
- Kondisi pada if akan dievaluasi terlebih dahulu.
- Jika kondisi bernilai true, maka blok if dijalankan.
- Jika kondisi bernilai false, maka blok else dijalankan.

**Sintaks**
```java
if (kondisi) {
    // dijalankan jika kondisi bernilai true
} else {
    // dijalankan jika kondisi bernilai false
}
```

**Contoh Program**

```java
public class IfElse {
    public static void main(String[] args) {
        int nilai = 80;

        if (nilai >= 75) {
            System.out.println("Lulus");
        } else {
            System.out.println("Tidak Lulus");
        }
    }
}
```

**Output:**
Lulus

Pada contoh di atas, variabel nilai bernilai 80. Karena kondisi nilai >= 75 bernilai true, program menampilkan "Lulus" dan mengabaikan bagian else.

### If-Else If
if-else if digunakan ketika program memiliki lebih dari dua kondisi yang perlu diperiksa. Setiap kondisi akan diuji secara berurutan dari atas ke bawah, dan hanya kondisi pertama yang bernilai benar yang akan dijalankan.

Struktur ini cocok digunakan untuk mengelompokkan data, seperti kategori nilai, usia, atau tingkat diskon.

**Sintaks**
```java
if (kondisi1) {
    // aksi 1
} else if (kondisi2) {
    // aksi 2
} else {
    // aksi jika semua kondisi salah
}
```

**Contoh Program**

```java
public class IfElseIf {
    public static void main(String[] args) {
        int nilai = 80;

        if (nilai >= 90) {
            System.out.println("Sangat Baik");
        } else if (nilai >= 75) {
            System.out.println("Baik");
        } else {
            System.out.println("Kurang");
        }
    }
}
```

**Output:**
Baik

Nilai 80 tidak memenuhi kondisi pertama (>= 90), sehingga program melanjutkan pemeriksaan ke kondisi berikutnya. Karena 80 >= 75, program menampilkan "Baik" dan tidak memeriksa kondisi lainnya.

## Switch
switch adalah bentuk percabangan yang digunakan untuk memilih satu aksi dari beberapa pilihan nilai yang tetap (konstan). Dibandingkan dengan if-else if, struktur switch lebih ringkas dan mudah dibaca ketika semua kondisi bergantung pada satu variabel yang sama.

Setiap pilihan ditulis menggunakan case, sedangkan default dijalankan apabila tidak ada nilai yang sesuai.

**Sintaks**
```java
switch (variabel) {
    case nilai1:
        // aksi
        break;
    case nilai2:
        // aksi
        break;
    default:
        // aksi jika tidak ada yang cocok
}
```

**Contoh Program**

```java
public class Switch {
    public static void main(String[] args) {
        int pilihan = 2;

        switch (pilihan) {
            case 1:
                System.out.println("Tambah Buku");
                break;
            case 2:
                System.out.println("Pinjam Buku");
                break;
            case 3:
                System.out.println("Kembalikan Buku");
                break;
            default:
                System.out.println("Pilihan Tidak Ada");
        }
    }
}
```

**Output:**
Pinjam Buku

Pada contoh tersebut, nilai variabel pilihan adalah 2, sehingga program menjalankan case 2. Perintah break digunakan untuk menghentikan proses switch agar program tidak melanjutkan ke case berikutnya.

* **Perbedaan If-Else, If-Else If, dan Switch**
| Percabangan | Digunakan Ketika | Jumlah Kondisi |
|---|---|---|
| `if-else` | Hanya ada dua kemungkinan hasil | 2 |
| `if-else if` | Terdapat beberapa kondisi yang perlu diperiksa | Lebih dari 2 |
| `switch` | Memilih aksi berdasarkan satu variabel dengan nilai tertentu | Banyak pilihan |

---

## PART 6: Perulangan
Perulangan (looping) adalah struktur kontrol yang digunakan untuk menjalankan blok kode secara berulang selama kondisi tertentu terpenuhi. Perulangan membantu mengurangi penulisan kode yang sama secara berulang sehingga program menjadi lebih singkat dan efisien.

Dalam Java, terdapat tiga jenis perulangan yang umum digunakan, yaitu:
1. for
2. while
3. do-while

### For
Perulangan for biasanya digunakan ketika jumlah perulangan sudah diketahui atau dapat ditentukan sejak awal.

Struktur for terdiri dari tiga bagian utama:
- Inisialisasi: menentukan nilai awal variabel penghitung.
- Kondisi: menentukan apakah perulangan masih dapat dilakukan.
- Increment/Decrement: mengubah nilai variabel penghitung setiap perulangan.

**Sintaks**
```java
for (inisialisasi; kondisi; increment/decrement) {
    // kode yang diulang
}
```

**Contoh Program**

```java
public class For {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Perulangan ke-" + i);
        }
    }
}
```

**Output:**
Perulangan ke-1
Perulangan ke-2
Perulangan ke-3
Perulangan ke-4
Perulangan ke-5

Pada contoh tersebut:
- int i = 1 → menentukan nilai awal i yaitu 1.
- i <= 5 → perulangan berjalan selama i kurang dari atau sama dengan 5.
- i++ → nilai i bertambah 1 setiap perulangan.
Karena kondisi berhenti ketika i lebih besar dari 5, maka perulangan dilakukan sebanyak 5 kali.

### While
Perulangan while digunakan ketika jumlah perulangan belum tentu diketahui sejak awal dan perulangan bergantung pada suatu kondisi.

Pada while, kondisi diperiksa sebelum blok kode dijalankan. Jika kondisi bernilai true, blok kode akan dijalankan. Setelah itu, kondisi diperiksa kembali sampai menghasilkan false.

**Sintaks**
```java
while (kondisi) {
    // kode yang diulang
}
```

**Contoh Program**

```java
public class While {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {
            System.out.println("Perulangan ke-" + i);
            i++;
        }
    }
}
```

**Output:**
Perulangan ke-1
Perulangan ke-2
Perulangan ke-3
Perulangan ke-4
Perulangan ke-5

Pada contoh tersebut:
- int i = 1 → menentukan nilai awal i.
- i <= 5 → menjadi kondisi perulangan.
- i++ → menambah nilai i sebesar 1 setiap perulangan.
- Ketika i menjadi 6, kondisi i <= 5 bernilai false, sehingga perulangan berhenti.
Hal penting: Karena kondisi diperiksa terlebih dahulu, while dapat tidak menjalankan blok kode sama sekali jika kondisi awal bernilai false.

### Do-While
Perulangan do-while hampir sama dengan while, tetapi memiliki perbedaan pada urutan pemeriksaan kondisi.

Pada do-while, blok kode dijalankan terlebih dahulu, kemudian kondisi diperiksa. Oleh karena itu, blok kode pada do-while pasti dijalankan minimal satu kali, meskipun kondisi awal bernilai false.

**Sintaks**
```java
do {
    // kode yang diulang
} while (kondisi);
```

**Contoh Program**

```java
public class DoWhile {
    public static void main(String[] args) {
        int i = 1;

        do {
            System.out.println("Perulangan ke-" + i);
            i++;
        } while (i <= 5);
    }
}
```

**Output**
Perulangan ke-1
Perulangan ke-2
Perulangan ke-3
Perulangan ke-4
Perulangan ke-5

* **Pada contoh tersebut:**
    - Nilai awal i adalah 1.
    - Blok do dijalankan terlebih dahulu.
    - Nilai i bertambah dengan i++.
    - Kondisi i <= 5 kemudian diperiksa.
    - Jika kondisi true, perulangan kembali ke bagian do.
    - Jika kondisi false, perulangan berhenti.

* **Perbedaan while dan do-while**
    Perbedaan utama keduanya terletak pada waktu pemeriksaan kondisi:
    - while → kondisi diperiksa terlebih dahulu, kemudian kode dijalankan.
    - do-while → kode dijalankan terlebih dahulu, kemudian kondisi diperiksa.

Contoh Sederhana:
```java
int i = 10;

while (i <= 5) {
    System.out.println("Hello");
}
```

Kode di atas tidak akan mencetak apa pun karena kondisi 10 <= 5 langsung bernilai false.

Sedangkan:
```java
int i = 10;

do {
    System.out.println("Hello");
} while (i <= 5);
```
Kode tersebut akan mencetak:
Hello

karena blok do dijalankan minimal satu kali sebelum kondisi diperiksa.

* **Ringkasan Perulangan**
| Perulangan | Kegunaan | Pemeriksaan Kondisi |
|---|---|---|
| `for` | Digunakan ketika jumlah perulangan sudah diketahui | Sebelum perulangan |
| `while` | Digunakan ketika perulangan bergantung pada suatu kondisi | Sebelum perulangan |
| `do-while` | Digunakan ketika kode harus dijalankan minimal satu kali | Setelah perulangan |

---

## 📚 Referensi

- Dwi Hastuti & Yusril Arief, "Seri Belajar Pemrograman: Pemrograman Dasar dengan Java". Tersedia di: [tautan](https://www.researchgate.net/publication/369020845_Seri_Belajar_Pemrograman_Pemrograman_Dasar_dengan_Java)
- W3Schools, "Java Output / Print". Tersedia di: [tautan](https://www.w3schools.com/java/java_output.asp)
- W3Schools, "Java Data Types". Tersedia di: [tautan](https://www.w3schools.com/java/java_data_types.asp)
- W3Schools, "Java Operators". Tersedia di: [tautan](https://www.w3schools.com/java/java_operators.asp)
- W3Schools, "Java If ... Else". Tersedia di: [tautan](https://www.w3schools.com/java/java_conditions.asp)
- W3Schools, "Java Switch". Tersedia di: [tautan](https://www.w3schools.com/java/java_switch.asp)
- W3Schools, "Java While Loop". Tersedia di: [tautan](https://www.w3schools.com/java/java_while_loop.asp)
- W3Schools, "Java For Loop". Tersedia di: [tautan](https://www.w3schools.com/java/java_for_loop.asp)

---

## 🏆 Challenge Praktikan
1. Buat program untuk meminta input harga buku dan jumlah buku, kemudian hitung dan tampilkan total harga pembelian.
2. Buat program yang meminta input nilai mahasiswa, kemudian tentukan keterangan nilai menggunakan if-else if:
    A) jika nilai ≥ 85
    B) jika nilai ≥ 75
    C) jika nilai ≥ 65
    D) jika nilai < 65
3. Buat program menggunakan perulangan for untuk menampilkan angka 1 sampai 10, kemudian gunakan switch untuk menampilkan keterangan berdasarkan angka yang dipilih pengguna.

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />

<p align="center"><a href="#top">Kembali ke atas</a></p>