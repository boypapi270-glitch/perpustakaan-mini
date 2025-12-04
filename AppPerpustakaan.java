import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class AppPerpustakaan {
    // ArrayList untuk menyimpan data utama
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static ArrayList<Anggota> daftarAnggota = new ArrayList<>();
    // ArrayList untuk menyimpan riwayat semua transaksi (aktif dan selesai)
    private static ArrayList<Peminjaman> riwayatPeminjaman = new ArrayList<>();
    // ArrayList untuk menyimpan catatan pengembalian (optional, bisa dilihat dari riwayatPeminjaman juga)
    private static ArrayList<Pengembalian> riwayatPengembalian = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // a. Membuat beberapa objek awal
        inisialisasiDataAwal();

        int pilihan = -1;
        while (pilihan != 0) {
            tampilkanMenu();
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membuang newline character setelah nextInt()
                prosesPilihanMenu(pilihan);
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); // Membuang input yang salah
            }
        }
        System.out.println("Terima kasih! Sampai jumpa.");
        scanner.close();
    }

    private static void inisialisasiDataAwal() {
        // b. Menyimpan objek-objek tersebut ke dalam ArrayList
        daftarBuku.add(new Buku("B001", "Pemrograman Java", "Eko Kurniawan Khannedy"));
        daftarBuku.add(new Buku("B002", "Algoritma dan Struktur Data", "Rinaldi Munir"));
        daftarBuku.add(new Buku("B003", "Desain Pola Perangkat Lunak", "Gamma et al."));
        
        daftarAnggota.add(new Anggota("A001", "Budi Santoso", "Jl. Mawar No. 1"));
        daftarAnggota.add(new Anggota("A002", "Siti Aminah", "Jl. Melati No. 5"));
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== MENU PERPUSTAKAAN ===");
        System.out.println("1. Lihat daftar buku");
        System.out.println("2. Tambah buku baru");
        System.out.println("3. Daftarkan anggota baru");
        System.out.println("4. Pinjam buku");
        System.out.println("5. Kembalikan buku");
        System.out.println("6. Lihat daftar anggota");
        System.out.println("7. Lihat riwayat peminjaman");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void prosesPilihanMenu(int pilihan) {
        switch (pilihan) {
            case 1:
                lihatDaftarBuku();
                break;
            case 2:
                tambahBukuBaru();
                break;
            case 3:
                tambahkanAnggotaBaru();
                break;
            case 4:
                pinjamBuku();
                break;
            case 5:
                kembalikanBuku();
                break;
            case 6:
                lihatDaftarAnggota();
                break;
            case 7:
                lihatRiwayatPeminjaman();
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    // --- Implementasi Fungsi Menu ---

    private static void lihatDaftarBuku() {
        System.out.println("\n--- DAFTAR BUKU ---");
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku di perpustakaan.");
        } else {
            for (Buku buku : daftarBuku) {
                System.out.println(buku);
            }
        }
    }

    private static void tambahBukuBaru() {
        System.out.print("Masukkan kode buku: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scanner.nextLine();

        daftarBuku.add(new Buku(kode, judul, penulis));
        System.out.println("Buku baru berhasil ditambahkan!");
    }

    private static void lihatDaftarAnggota() {
        System.out.println("\n--- DAFTAR ANGGOTA ---");
        for (Anggota anggota : daftarAnggota) {
            System.out.println(anggota);
        }
    }
    
    private static void tambahkanAnggotaBaru() {
        System.out.print("Masukkan ID anggota: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan nama anggota: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat anggota: ");
        String alamat = scanner.nextLine();

        daftarAnggota.add(new Anggota(id, nama, alamat));
        System.out.println("Anggota baru berhasil didaftarkan!");
    }

    private static void pinjamBuku() {
        System.out.print("Masukkan ID Anggota peminjam: ");
        String idAnggota = scanner.nextLine();
        Anggota anggota = cariAnggota(idAnggota);

        if (anggota == null) {
            System.out.println("Error: Anggota dengan ID " + idAnggota + " tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan Kode Buku yang dipinjam: ");
        String kodeBuku = scanner.nextLine();
        Buku buku = cariBuku(kodeBuku);

        if (buku == null) {
            System.out.println("Error: Buku dengan Kode " + kodeBuku + " tidak ditemukan.");
            return;
        }

        if (!buku.isTersedia()) {
            System.out.println("Error: Buku '" + buku.getJudul() + "' sedang tidak tersedia (dipinjam).");
            return;
        }

        // Proses peminjaman
        buku.setTersedia(false);
        Peminjaman p = new Peminjaman(buku, anggota);
        riwayatPeminjaman.add(p);
        System.out.println("Peminjaman berhasil dicatat! Buku '" + buku.getJudul() + "' dipinjam oleh " + anggota.getNama());
    }

    private static void kembalikanBuku() {
        System.out.print("Masukkan Kode Buku yang dikembalikan: ");
        String kodeBuku = scanner.nextLine();
        Buku buku = cariBuku(kodeBuku);

        if (buku == null) {
            System.out.println("Error: Buku dengan Kode " + kodeBuku + " tidak ditemukan.");
            return;
        }

        if (buku.isTersedia()) {
            System.out.println("Error: Buku '" + buku.getJudul() + "' tidak sedang dipinjam.");
            return;
        }

        // Cari transaksi peminjaman yang aktif untuk buku ini
        Peminjaman peminjamanAktif = null;
        for (Peminjaman p : riwayatPeminjaman) {
            if (p.getBuku().getKodeBuku().equals(kodeBuku) && p.getTanggalKembali() == null) {
                peminjamanAktif = p;
                break;
            }
        }

        if (peminjamanAktif != null) {
            // Proses pengembalian
            buku.setTersedia(true);
            Pengembalian pengembalian = new Pengembalian(peminjamanAktif);
            riwayatPengembalian.add(pengembalian); // Tambahkan ke riwayat pengembalian
            System.out.println("Buku '" + buku.getJudul() + "' berhasil dikembalikan.");
        } else {
             // Seharusnya tidak terjadi jika logika isTersedia benar, tapi sebagai fallback
            System.out.println("Error: Transaksi peminjaman aktif tidak ditemukan untuk buku ini.");
        }
    }
    
    private static void lihatRiwayatPeminjaman() {
        System.out.println("\n--- RIWAYAT PEMINJAMAN ---");
        for (Peminjaman p : riwayatPeminjaman) {
            System.out.println(p);
        }
    }

    // --- Helper Methods ---

    private static Buku cariBuku(String kodeBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getKodeBuku().equalsIgnoreCase(kodeBuku)) {
                return buku;
            }
        }
        return null;
    }

    private static Anggota cariAnggota(String idAnggota) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getIdAnggota().equalsIgnoreCase(idAnggota)) {
                return anggota;
            }
        }
        return null;
    }
}
