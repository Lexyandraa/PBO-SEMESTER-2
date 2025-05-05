package com.praktikum.users;

// Kelas abstrak untuk mendefinisikan struktur dasar User
public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metode abstrak untuk proses login
    public abstract boolean login();

    // Metode abstrak untuk menampilkan menu sesuai peran user
    public abstract void displayAppMenu();
}