package com.praktikum.users;

import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.*;

public class Admin extends User {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    @Override
    public void showMenu(Scanner sc) {
        int pilih = -1;
        do {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Users");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");

            try {
                pilih = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilih) {
                case 1:
                    manageItems(sc);
                    break;
                case 2:
                    manageUsers(sc);
                    break;
                case 0:
                    System.out.println("Logout.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }

    public void manageItems(Scanner sc) {
        System.out.println("\n-- Semua Laporan --");
        List<Item> list = LoginSystem.reportedItems;
        if (list.isEmpty()) {
            System.out.println("Belum ada laporan.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Item it = list.get(i);
            System.out.printf("%d. %s | %s | %s | status: %s\n",
                    i, it.getItemName(), it.getDescription(),
                    it.getLocation(), it.getStatus());
        }
        System.out.print("Masukkan indeks untuk menandai Claimed (atau -1 untuk kembali): ");
        int idx;
        try {
            idx = sc.nextInt(); sc.nextLine();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println("Input harus angka!");
            return;
        }
        if (idx < 0) return;
        try {
            Item toClaim = list.get(idx);
            toClaim.setStatus("Claimed");
            System.out.println("Barang berhasil ditandai Claimed.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Indeks tidak valid!");
        }
    }

    public void manageUsers(Scanner sc) {
        int pilihan = -1;
        do {
            System.out.println("\n-- Manage Users --");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            try {
                pilihan = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Input harus angka!");
                continue;
            }
            switch (pilihan) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    LoginSystem.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.print("NIM yang akan dihapus: ");
                    String hapusNim = sc.nextLine();
                    Iterator<User> it = LoginSystem.userList.iterator();
                    boolean found = false;
                    while (it.hasNext()) {
                        User u = it.next();
                        if (u instanceof Mahasiswa) {
                            Mahasiswa m = (Mahasiswa) u;
                            if (m.getNim().equals(hapusNim)) {
                                it.remove();
                                found = true;
                                System.out.println("Mahasiswa dengan NIM " + hapusNim + " dihapus.");
                                break;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
