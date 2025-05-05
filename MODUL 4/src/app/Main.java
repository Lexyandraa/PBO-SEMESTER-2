package app;

import perpustakaan.Anggota;
import perpustakaan.Buku;
import perpustakaan.Fiksi;
import perpustakaan.NonFiksi;


public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();

        Anggota anggota1 = new Anggota("Restu Gilang Saputra", "014");
        Anggota anggota2 = new Anggota("Naufal Arkaan", "020");

        anggota1.displayInfo();
        anggota2.displayInfo();

        System.out.println();

        anggota1.pinjamBuku(buku1.getJudul());
        anggota2.pinjamBuku(buku2.getJudul(), 7);

        System.out.println();

        anggota1.kembalikanBuku(buku1.getJudul());
        anggota2.kembalikanBuku(buku2.getJudul());
    }
}