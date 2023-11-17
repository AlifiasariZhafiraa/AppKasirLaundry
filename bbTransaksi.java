package bp2;

public class bbTransaksi {
    private bbMember member;
    private bbPaket paket[];    
    private String periode;
    private int jumlahPaket;
    private int totalHarga;
    
    bbTransaksi(){
        member = null; paket = new bbPaket[10];                             
        jumlahPaket = 0; totalHarga = 0;
        System.out.println("\n                     Transaksi Ditambahkan");
    }
    
    public void tambahPaket(bbPaket m){
        if((totalHarga + m.getharga()<=250000)){
            paket[jumlahPaket] = m;
            jumlahPaket++;
            totalHarga = totalHarga + m.getharga();                   
            System.out.println("\n                        Paket Ditambahkan");
        }else{
            System.out.println("Total Harga Melebihi Batas!");
        }
    }
    
    public void hapusPaket(String kd){
        boolean ada = false;
        for (int i = 0; i < jumlahPaket; i++) {
            if(kd.equalsIgnoreCase(paket[i].getkodePaket())){
                ada = true;
                totalHarga = totalHarga - paket[i].getharga();
                paket[i] = null;
                for (int j = 0; j < jumlahPaket; j++) {
                    if(j == jumlahPaket-1)
                        paket[j] = null;
                    else
                        paket[j] = paket[j+1];
                }
                jumlahPaket--;                                            
                System.out.println("\n                             Paket Dihapus");
                break;
            }
        }
        if(ada == false){
            System.out.println("Kode Paket Tidak Ada");
        }
    }
    
    //transaksi function
    public void setMember(bbMember m){member = m;}
    public void setPaket(bbPaket[] p){paket = p;}
    public void setPeriode(String pd){periode = pd;}
    public int getjumlahPaket(){return jumlahPaket;}
    public int totalHarga(){return totalHarga;}
    public bbMember getMember(){return member;}
    public bbPaket[] getPaket(){return paket;}
    public String getPeriode(){return periode;}
    public String ToString(){
        String temp = "\nLoundry Periode " + periode;
        temp = temp + "\nNama     : " + member.getnama();
        temp = temp + "\nTagihan  : Rp. " + totalHarga;
        temp = temp + "\n";
        temp = temp + "\nNo.\tKode\tNama\t\tHarga";                
        temp = temp + "\n-----------------------------------------";
        for (int i = 0; i < jumlahPaket; i++) {
            temp = temp + "\n" + (i+1) + "\t";
            temp = temp + paket[i].getkodePaket() + "\t";
            temp = temp + paket[i].getjenisPaket() + "\t";
            temp = temp + "Rp. " + paket[i].getharga() + "\n";
        }
        return temp;
    }
}
