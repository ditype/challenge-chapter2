

import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     *  this is main method
     * @param args to collect arguments with the data type string
     * @throws IOException simply an exception that is thrown when an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        boolean loop = true;

        // while to loop main menu
        while (loop) {
            System.out.println("-------------------------------------");
            System.out.println("Aplikasi Pengolah Nilai Siswa");
            System.out.println("-------------------------------------");
            System.out.println("Letakan file csv dengan nama file data_sekolah di direktori\nberikut: C://temp/direktori");

            System.out.println("\npilih menu:");
            System.out.println("1. Generate txt untuk menampilkan modus");
            System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");

            System.out.print("\nInput Anda: ");
            userChoice = scanner.nextInt();

            // switch case to provide choices for user to select the specific menu
            switch (userChoice) {
                case 1:
                    messageSuccess();
                    ModeApp obj = new ModeApp("/home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/data_sekolah.csv", "/home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/output_mode.txt");
                    obj.call();
                    loop = again();
                    break;
                case 2:
                    loop = false;
                    break;
                case 3:
                    ModeAppAndFile obj2 = new ModeAppAndFile("/home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/output_mode.txt",);
                    obj2.call();
                    loop = again();
                    break;
                case 0:
                    System.exit(0); // close program
                    break;
                default:
                    System.out.println("Input tidak ditemukan, pilih antara [1/2/3/0]");
            }
        }
    }

    // method to loop if user choice 1 program will continue looping, else will stop the program.
    public static boolean again(){
        int loopAgain = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan pilihan: ");
        int choice = scanner.nextInt();

        return choice == loopAgain;
    }

    // method to print if the specific menu has operating well and asking user to continue leave
    public static void messageSuccess(){
        System.out.println("-------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("-------------------------------------");
        System.out.println("File telah di generate di /home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/\nsilakan cek");
        System.out.println("0 Exit");
        System.out.println("1 Kembali ke menu utama");
    }

    public static void  failed(){
        System.out.println("-------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("-------------------------------------");
        System.out.println("File tidak ditemukan");
        System.out.println("0 Exit");
        System.out.println("1 Kembali ke menu utama");
    }

}
