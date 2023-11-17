package bp2;

public class bbOutlet {
    //data outlet
    private bbMember member;
    private String kodeOutlet, namaOutlet;
    private String kapasitas;
    
    bbOutlet(){
        kodeOutlet = "ABC";
        namaOutlet = "DEF";
        kapasitas = "100";
        member = null;
    }
    
    bbOutlet(String nm, String kd, String k){        
        namaOutlet = nm;
        kodeOutlet = kd;
        kapasitas = k;
        member = null;                                             
        System.out.println("\n                       Outlet Ditambahkan");
    }
    
    //outlet function
    public void setMember(bbMember m){member = m;}
    public bbMember getMember(){return member;}
    public void deleteMember(){member = null;}
    public void setKodeOutlet(String kd){kodeOutlet = kd;}
    public void setNamaOutlet(String nm){namaOutlet = nm;}
    public void setKapasitas(String k){kapasitas = k;}
    public String getKodeOutlet(){return kodeOutlet;}
    public String getNamaOutlet(){return namaOutlet;}
    public String getKapasitas(){return kapasitas;}
    public String ToString(){
        return kodeOutlet + " " + namaOutlet + " " + kapasitas;
    }
}