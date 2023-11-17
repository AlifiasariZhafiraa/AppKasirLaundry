package bp2;

public class bbPaket {
    //data paket
    private String jenisPaket, kodePaket;
    private int harga;
    
    bbPaket(){
        jenisPaket = "abc";
        kodePaket = "def";
        harga = 0;
    }
    
    bbPaket(String jns, String kd, int hrg){
        jenisPaket = jns; kodePaket = kd; harga = hrg;          
        System.out.println("\n                        Paket Ditambahkan");
    }
    
    //paket function
    public void setjenisPaket(String jns){ jenisPaket = jns; }
    public void setkodePaket(String kd){ kodePaket = kd; }
    public void setharga(int hrg){ harga = hrg; }
    public String getjenisPaket(){ return jenisPaket; }
    public String getkodePaket(){ return kodePaket; }
    public int getharga(){ return harga; }
    public String ToString(){
        return kodePaket + "\t" + jenisPaket + "\tRp. " + harga;
    }
}
