// ===========================================================
// Topik: Polymorphism (Overriding & Overloading)
// Letakkan file ini pada src/main/MainApp.java
// ===========================================================

package main;

import model.BukuCetak;
import model.EBook;

public class MainApp {
    public static void main(String[] args) {
        // Constructor BukuCetak
        BukuCetak bukuCetak1 = new BukuCetak(
                "BC001", "Pemrograman Java", "James Gosling", 2023, 350, "Rak A-1");

        // Constructor Ebook
        EBook ebook1 = new EBook(
                "EB001", "Belajar Python Otodidak", "Guido van Rossum", 2024, 12.5, "PDF");

        // ----- DEMONSTRASI METHOD OVERRIDING -----
        System.out.println("\n--- DEMONSTRASI OVERIDING tampilkanInfo() ---");
        bukuCetak1.tampilkanInfo();        // versi lengkap (tanpa parameter)
        ebook1.tampilkanInfo();        // versi lengkap (tanpa parameter)
        
        // ----- DEMONSTRASI METHOD OVERLOADING -----
        System.out.println("\n--- DEMONSTRASI OVERLOADING tampilkanInfo() ---");
        bukuCetak1.tampilkanInfo();        // versi lengkap (tanpa parameter)
        bukuCetak1.tampilkanInfo(true);    // versi ringkas (dengan parameter boolean)
    }
}