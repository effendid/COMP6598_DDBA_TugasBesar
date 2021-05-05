public class Buku {
    String judul;
    String pengarang;
    int qty;

    public Buku(String judul, String pengarang,int qty){
        this.judul=judul;
        this.pengarang=pengarang;
        this.qty=qty;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
