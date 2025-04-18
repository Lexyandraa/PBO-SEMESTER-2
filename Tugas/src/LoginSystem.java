import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            admin.login();
        } else if (pilihan == 2) {
            mahasiswa.login();
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}