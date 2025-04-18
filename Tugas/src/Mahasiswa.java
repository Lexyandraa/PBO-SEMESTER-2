import java.util.Scanner;

public class Mahasiswa {
    Scanner scanner = new Scanner(System.in);
    String nama;
    String nim;

    void login() {
        System.out.print("Masukkan Nama Anda: ");
        String inputNama = scanner.nextLine();

        System.out.print("Masukkan NIM Anda: ");
        String inputNIM = scanner.nextLine();

        String validNama = "Lexyandra Syahputra";
        String validNIM = "202410370110030";

        if (inputNama.equalsIgnoreCase(validNama) && inputNIM.equals(validNIM)) {
            this.nama = inputNama;
            this.nim = inputNIM;
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}