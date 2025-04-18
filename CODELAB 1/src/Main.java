class Hewan {
    // 3 atribut dengan tipe data String
    String Nama;
    String Jenis;
    String Suara;

    // Metode untuk menampilkan informasi hewan
    void tampilkanInfo() {
        System.out.println("Nama: " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat dua objek Hewan
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        // Mengatur atribut untuk hewan1
        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        // Mengatur atribut untuk hewan2
        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Woof-Woof!!";

        // Memanggil metode tampilkanInfo() dari kedua objek
        hewan1.tampilkanInfo();
        System.out.println();
        hewan2.tampilkanInfo();
    }
}