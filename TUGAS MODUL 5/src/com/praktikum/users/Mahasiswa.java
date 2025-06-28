package com.praktikum.users;

import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.*;

public class Mahasiswa extends User {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    public String getNama() { return nama; }
    public String getNim()  { return nim; }

    @Override
    public void showMenu(Scanner sc) {
        int pilih = -1;
        do {
            System.out.println("\n--- Menu Mahasiswa ---");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            try {
                pilih = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Input harus angka!");
                continue;
            }
            switch (pilih) {
                case 1:
                    reportItem(sc);
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }

    public void reportItem(Scanner sc) {
        System.out.print("Nama Barang: ");
        String name = sc.nextLine();
        System.out.print("Deskripsi: ");
        String desc = sc.nextLine();
        System.out.print("Lokasi: ");
        String loc  = sc.nextLine();

        Item newItem = new Item(name, desc, loc);
        LoginSystem.reportedItems.add(newItem);
        System.out.println("Barang berhasil dilaporkan dengan status \"Reported\".");
    }

    public void viewReportedItems() {
        List<Item> list = LoginSystem.reportedItems;
        boolean ada = false;
        System.out.println("\n-- Laporan Barang (Status = Reported) --");
        for (Item it : list) {
            if ("Reported".equals(it.getStatus())) {
                System.out.printf("%s | %s | %s\n",
                        it.getItemName(), it.getDescription(), it.getLocation());
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("Belum ada laporan barang.");
        }
    }
}