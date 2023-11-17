package bp2;

public class bbMember {
    //data member
    private String ID, nama, telp, alamat;
    
    bbMember(){ //constuctor
        ID = "123";
        nama = "abc";
        telp = "0853";
        alamat = "def";
    }
    
    //constructor dengan parameter
    bbMember(String id, String nm, String tlp, String alm){
        ID = id; nama = nm; telp = tlp; alamat = alm;
        System.out.println("\n                       Member Ditambahkan");
    }
        
    //member function
    public void setid(String id){ ID = id; } //method set untuk menerima value 
    public void setnama(String nm){ nama = nm; }
    public void settelp(String tlp){ telp = tlp; }
    public void setalamat(String alm){ alamat = alm; }
    public String getid(){ return ID; } //methpd get untuk mengembalikan value atau memanggil value
    public String getnama(){ return nama; }
    public String gettelp(){ return telp; }
    public String getalamat(){ return alamat; }
    public String ToString(){
        return ID + "\t" + nama;
    }
}
