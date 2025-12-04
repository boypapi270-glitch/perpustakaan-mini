public class Buku {
    private String kodeBuku;
    private String judul;
    private String penulis;
    private boolean tersedia;

    public Buku(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tersedia = true; // Buku baru awalnya tersedia
    }

    // Getter dan Setter
    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String toString() {
        return "Kode: " + kodeBuku + ", Judul: " + judul + ", Penulis: " + penulis + ", Status: " + (tersedia ? "Tersedia" : "Dipinjam");
    }
}
