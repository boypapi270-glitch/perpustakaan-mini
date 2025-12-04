import java.time.LocalDate;

public class Pengembalian {
    private Peminjaman peminjaman;
    private LocalDate tanggalAktualKembali;

    public Pengembalian(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
        this.tanggalAktualKembali = LocalDate.now();
        // Update status di objek Peminjaman
        peminjaman.setTanggalKembali(tanggalAktualKembali);
    }

    @Override
    public String toString() {
        return "PENGEMBALIAN SELESAI -> " + peminjaman.toString();
    }
}
