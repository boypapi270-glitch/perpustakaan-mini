==================================================
NAMA APLIKASI   : System perpustakaan mini 
NAMA            : Tofa Fatur  Rahman
NIM             : 1001250042
KELAS           : Pemrograman berorientasi objek
==================================================


Panduan Menjalankan Program Sistem Manajemen Perpustakaan Mini
Dokumen ini menjelaskan langkah-langkah yang diperlukan untuk mengkompilasi dan menjalankan aplikasi perpustakaan berbasis konsol yang telah disediakan dalam lima file Java terpisah.
1. Persiapan Lingkungan (Versi JDK)
Untuk menjalankan program ini, Anda memerlukan Java Development Kit (JDK) yang terinstal di sistem Anda. Program ini kompatibel dengan versi Java modern (disarankan JDK 8 atau yang lebih baru, misalnya JDK 17).
Memeriksa Versi JDK Anda
Buka Terminal (Linux/macOS) atau Command Prompt/PowerShell (Windows) dan ketik perintah berikut untuk memverifikasi instalasi Anda:
bash
java -version
javac -version
Gunakan kode dengan hati-hati.

Pastikan perintah javac (Java Compiler) tersedia, karena ini diperlukan untuk langkah kompilasi.
2. Struktur File
Pastikan kelima file Java tersebut disimpan dalam satu folder bernama perpustakaan untuk mematuhi struktur paket yang telah ditentukan (package perpustakaan;).
/LokasiProyekAnda/
└── perpustakaan/
    ├── AppPerpustakaan.java
    ├── Anggota.java
    ├── Buku.java
    ├── Peminjaman.java
    └── Pengembalian.java
3. Cara Kompilasi (Compile)
Langkah kompilasi mengubah kode sumber (.java) menjadi bytecode yang dapat dieksekusi oleh Java Virtual Machine (JVM), menghasilkan file .class.
Langkah-langkah:
Navigasikan ke direktori induk: Pindah ke folder di luar direktori perpustakaan (misalnya, ke /LokasiProyekAnda/).
Kompilasi semua file: Gunakan perintah javac untuk mengkompilasi semua file dalam paket perpustakaan.
bash
javac perpustakaan/*.java
Gunakan kode dengan hati-hati.

Hasil:
Perintah ini akan membuat lima file .class baru di dalam folder perpustakaan.
4. Cara Menjalankan (Run)
Setelah kompilasi berhasil, Anda dapat menjalankan aplikasi utama menggunakan perintah java.
Langkah-langkah:
Pastikan Anda masih di direktori induk: (/LokasiProyekAnda/).
Jalankan aplikasi: Gunakan perintah java, tentukan classpath saat ini (-cp .), dan sebutkan nama kelas lengkapnya (perpustakaan.AppPerpustakaan).
bash
java -cp . perpustakaan.AppPerpustakaan
Gunakan kode dengan hati-hati.

Interaksi Program
Program akan menampilkan menu konsol seperti berikut. Anda dapat memasukkan angka sesuai menu untuk berinteraksi dengan sistem perpustakaan:
=== MENU PERPUSTAKAAN ===
1. Lihat daftar buku
2. Tambah buku baru
3. Daftarkan anggota baru
4. Pinjam buku
5. Kembalikan buku
6. Lihat daftar peminjaman aktif
0. Keluar
Pilih menu: _





