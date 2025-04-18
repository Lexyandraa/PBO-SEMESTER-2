import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    String validUsername = "Admin";
    String validPassword = "hambaallah";

    void login() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}