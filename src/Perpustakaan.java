import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Perpustakaan {
    static Scanner input = new Scanner(System.in);

    static ArrayList<User> list = new ArrayList<>();
    static ArrayList<Buku> listBuku = new ArrayList<>();

    static void Database(){

        list.add(new User("admin", "admin", true));
        list.add(new User("user", "user", false));
    }

    // method untuk mengisi List
    static void databaseBuku(){

        listBuku.add(new Buku("Introduction to Java Programming, Comprehensive Version, 9th Edition",
                "Y. Daniel Liang", 4));
        listBuku.add(new Buku("Financial Accounting",
                "Weygant Kimmel", 3));
        listBuku.add(new Buku("Systems Analysis and Design",
                "Dennis A", 6));

        menuUtama();
    }


    static void login(){
        Database();
        if(list.size()>0) {
            System.out.print("Username : ");
            String inputUserName = new Scanner(System.in).nextLine(); //assign the user's input username
            System.out.print("Password : ");
            String inputPassword = new Scanner(System.in).nextLine();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(inputUserName)
                        && list.get(i).getPassword().equals(inputPassword)
                        && list.get(i).isAdmin()) {
                    System.out.println("admin ok");
                }
            }
        }
    }


    static void menuUtama(){
        int pilihan;
        do {
            System.out.println("====== Menu ======");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. List Semua Koleksi");
            System.out.println("4. Peminjaman");
            System.out.println("5. Pengembalian");

            System.out.print("Masukkan pilihan > ");
            pilihan = input.nextInt();

            if (pilihan == 3){
                lihatKoleksi();
            }

        } while(pilihan == 5);
    }

    static void lihatKoleksi(){

        //sort asc berdasarkan pengarang
        listBuku.sort(Comparator.comparing(Buku::getPengarang));

        CommandLineTable st = new CommandLineTable();

        for (Buku buku : listBuku) {
            st.setShowVerticalLines(true);
            st.setHeaders("Judul", "Pengarang", "Jumlah");
            st.addRow(buku.getJudul(),
                    buku.getPengarang(),
                    Integer.toString(buku.getQty()));
        }
        st.print();

        //kembali ke menu utama
        menuUtama();
    }

    public static void main(String[] args) {
        databaseBuku();
//        login();
    }
}
