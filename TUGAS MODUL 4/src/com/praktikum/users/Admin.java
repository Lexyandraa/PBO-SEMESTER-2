package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

// Kelas untuk pengguna dengan peran Admin
public class Admin extends User implements AdminActions {
    private Scanner scanner = new Scanner(System.in);

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        // Contoh cek sederhana (ganti dengan verifikasi nyata jika perlu)
        return "admin".equals(username) && "5758".equals(password);
    }

    @Override
    public void displayAppMenu() {
        int pilihan;
        do {
            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            pilihan = Integer.parseInt(scanner.nextLine());
            switch (pilihan) {
                case 1: manageItems(); break;
                case 2: manageUsers(); break;
                case 0: System.out.println("Logout..."); break;
                default: System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola com.praktikum.Mahasiswa Belum Tersedia <<");
    }
}