package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

// Kelas untuk pengguna dengan peran Mahasiswa
public class Mahasiswa extends User implements MahasiswaActions {
    private Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        // Contoh verifikasi sederhana (ganti sesuai kebutuhan)
        return "lexyandra".equals(username) && "030".equals(password);
    }

    @Override
    public void displayAppMenu() {
        int pilihan;
        do {
            System.out.println("\n== Menu Mahasiswa ==");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            pilihan = Integer.parseInt(scanner.nextLine());
            switch (pilihan) {
                case 1: reportItem(); break;
                case 2: viewReportedItems(); break;
                case 0: System.out.println("Logout..."); break;
                default: System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }

    @Override
    public void reportItem() {
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();
        System.out.println(">> Laporan diterima: " + nama + ", " + deskripsi + ", " + lokasi);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}