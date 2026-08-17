//========================================
// Topik: GUI
//========================================

// Kode untuk bagian btnSimpanActionPerformed

private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        // 1. Mengambil teks yang diketik pengguna
        String nama = txtNama.getText().trim();
        String nim = txtNIM.getText().trim();
        String kelas = txtKelas.getText().trim();
        
        // 2. Validasi Keamanan: Mencegah input kosong
        if (nama.isEmpty() || nim.isEmpty() || kelas.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "Semua kolom (Nama, NIM, Kelas) wajib diisi!", 
                    "Peringatan Input", 
                    JOptionPane.WARNING_MESSAGE);
            return; // Menghentikan eksekusi kode di bawahnya
        }
        
        // 3. Mengambil model dari JTable
        DefaultTableModel model = (DefaultTableModel) tblMahasiswa.getModel();
        
        // 4. Memasukkan data ke dalam baris baru
        Object[] barisBaru = {nim, nama, kelas};
        model.addRow(barisBaru);
        
        // 5. Membersihkan kolom input
        txtNama.setText("");
        txtNIM.setText("");
        txtKelas.setText("");
        
        // Mengembalikan kursor ke kolom awal
        txtNIM.requestFocus();
        
        // 6. Menampilkan informasi sukses
        JOptionPane.showMessageDialog(this, 
                "Data Mahasiswa berhasil ditambahkan ke dalam tabel!", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);
    }