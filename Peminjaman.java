import java.time.LocalDate;

public class Peminjaman {
    private Buku buku;
    private Anggota anggota;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali; // Tanggal pengembalian yang direncanakan/aktual

    public Peminjaman(Buku buku, Anggota anggota) {
        this.buku = buku;
        this.anggota = anggota;
        this.tanggalPinjam = LocalDate.now();
    }

    // Getter dan Setter
    public Buku getBuku() {
        return buku;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }
    
    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    @Override
    public String toString() {
        return "Peminjaman [Buku: " + buku.getJudul() + ", Anggota: " + anggota.getNama() + 
               ", Tgl Pinjam: " + tanggalPinjam + 
               ", Tgl Kembali: " + (tanggalKembali != null ? tanggalKembali : "Belum Kembali") + "]";
    }
}
