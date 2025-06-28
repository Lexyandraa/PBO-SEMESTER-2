package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.models.Item;
import java.util.*;

public class LoginSystem {
    public static List<User> userList = new ArrayList<>();
    public static List<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // default users
        userList.add(new Admin("admin1", "pass1"));
        userList.add(new Admin("admin2", "pass2"));
        userList.add(new Mahasiswa("Alex", "1030"));
        userList.add(new Mahasiswa("Dwi",   "2024"));

        User loggedIn = null;
        while (loggedIn == null) {
            System.out.print("Username/Nama: ");
            String u = sc.nextLine();
            System.out.print("Password/NIM: ");
            String p = sc.nextLine();
            loggedIn = authenticate(u, p);
            if (loggedIn == null) {
                System.out.println("Login gagal, coba lagi.");
            }
        }

        // show respective menu
        loggedIn.showMenu(sc);
    }

    public static User authenticate(String unameOrName, String pwdOrNim) {
        for (User u : userList) {
            if (u instanceof Admin) {
                Admin a = (Admin) u;
                if (a.getUsername().equals(unameOrName) && a.getPassword().equals(pwdOrNim)) {
                    return a;
                }
            } else if (u instanceof Mahasiswa) {
                Mahasiswa m = (Mahasiswa) u;
                if (m.getNama().equals(unameOrName) && m.getNim().equals(pwdOrNim)) {
                    return m;
                }
            }
        }
        return null;
    }
}
