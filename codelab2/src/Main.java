// Kelas untuk menyimpan data rekening bank
class RekeningBank {
    // Atribut yang digunakan menyimpan nomor rekening
    long nomorRekening;
    // Atribut yang digunakan untuk menyimpan nama pemilik rekening
    String namaPemilik;
    // Atribut yang digunakan untuk menyimpan saldo rekening
    double saldo;

    // Method buat menampilkan info rekening ke layar
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        // menampilkan jumlah saldo dalam format Rupiah yang lebih rapi
        System.out.printf("Saldo: Rp%,.2f%n", saldo);
        System.out.println();
    }

    // Method buat setor uang ke rekening
    void setorUang(double jumlah) {
        saldo += jumlah; // Saldo ditambahkan sesuai jumlah yang disetor
        // menampilkan info transaksi agar tahu jumlah saldo setelah setor
        System.out.printf("%s menyetor Rp%,.2f. Saldo sekarang: Rp%,.2f%n", namaPemilik, jumlah, saldo);
    }

    // Method buat melakukan penarikan uang dari rekening
    void tarikUang(double jumlah) {
        // Cek dulu, saldo cukup atau tidak buat ditarik
        if (jumlah > saldo) {
            System.out.println(namaPemilik + " mencoba menarik Rp" + jumlah + " tapi saldo tidak mencukupi!");
        } else {
            saldo -= jumlah; // Kalo cukup, saldo dikurangi sesuai jumlah yang ditarik
            // Menampilkan info transaksi setelah penarikan
            System.out.printf("%s menarik Rp%,.2f. Saldo sekarang: Rp%,.2f%n", namaPemilik, jumlah, saldo);
        }
    }
}

// Kelas utama yang menjalankan program
public class Main {
    public static void main(String[] args) {
        // Buat objek rekening pertama (punya Lexyandra)
        RekeningBank rekening1 = new RekeningBank();
        rekening1.nomorRekening = 202410370110030L;
        rekening1.namaPemilik = "Lexyandra";
        rekening1.saldo = 9500000;

        // Buat objek rekening kedua (punya Gilbert)
        RekeningBank rekening2 = new RekeningBank();
        rekening2.nomorRekening = 202410370110006L;
        rekening2.namaPemilik = "Gilbert";
        rekening2.saldo = 10000000;

        // Menampilkan info rekening sebelum transaksi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Lexyandra melakukan setor Rp700.000 ke rekeningnya
        rekening1.setorUang(700000);
        // Gilbert melakukan penarikan Rp1.500.000 dari rekeningnya
        rekening2.tarikUang(1500000);

        System.out.println();

        // Menampilakn info rekening setelah transaksi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
