package com.praktikum.main;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import java.util.Scanner;

// Kelas utama untuk menjalankan aplikasi login
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        // Pilih objek User sesuai input username
        User currentUser;
        if ("admin".equals(user)) {
            currentUser = new Admin(user, pass);
        } else {
            currentUser = new Mahasiswa(user, pass);
        }

        // Proses login
        if (currentUser.login()) {
            System.out.println("Login sukses!");
            currentUser.displayAppMenu(); // Polimorfisme terpanggil di sini
        } else {
            System.out.println("Login gagal. Periksa username/password.");
        }
    }
}