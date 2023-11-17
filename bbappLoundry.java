package bp2;
import java.util.Scanner;

public class bbappLoundry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        bbMember member[] = new bbMember[3];
        member[0] = new bbMember();
        member[0].setid("1");
        member[0].setnama("Fia");
        member[0].settelp("0896");
        member[0].setalamat("Jl Jawa");
        
        bbPaket paket[] = new bbPaket[3];
        paket[0] = new bbPaket();
        paket[1] = new bbPaket();  
        paket[0].setkodePaket("111");
        paket[0].setjenisPaket("Cuci Kering");
        paket[0].setharga(17000);               
        paket[1].setkodePaket("222");
        paket[1].setjenisPaket("Cuci Setrika");
        paket[1].setharga(20000);
        
        bbTransaksi transaksi[] = new bbTransaksi[3];
        
        bbOutlet outlet[] = new bbOutlet[2];
        outlet[0] = new bbOutlet();
        outlet[0].setKodeOutlet("11");
        outlet[0].setNamaOutlet("Loundry Go");
        outlet[0].setKapasitas("50");
        
        int pilih;
        
        int jumlahMember = 1, jumlahPaket = 2, jumlahTransaksi = 0, jumlahOutlet = 1;
        int maxMember = 3, maxPaket = 3, maxTransaksi = 3, maxOutlet = 2;
        
        do{                       
            System.out.println("\n=========================================");
            System.out.println("                MENU LOUNDRY               ");
            System.out.println("=========================================");
            System.out.println("1. Member");
            System.out.println("2. Paket");
            System.out.println("3. Transaksi");
            System.out.println("4. Outlet");
            System.out.println("5. Keluar");
            System.out.print("\nPilih  \t: ");
            pilih = sc.nextInt();           
            switch(pilih){                      
                case 1:
                    int pilihMember = 0;
                    do{
                        System.out.println("\n=========================================");
                        System.out.println("                 MENU MEMBER               ");
                        System.out.println("=========================================");
                        System.out.println("1. Tambah Member");
                        System.out.println("2. Update Data Member");
                        System.out.println("3. Hapus Member");
                        System.out.println("4. Cetak Data Member");
                        System.out.println("5. Query");
                        System.out.println("6. Kembali");
                        System.out.print("\nPilih  \t: ");
                        pilihMember = sc.nextInt();
                        switch(pilihMember){
                            case 1:                                
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              TAMBAH  MEMBER             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah member masih di bawah kapasitas max
                                if(jumlahMember < maxMember){
                                    System.out.print("Masukkan Nama     : ");
                                    sc = new Scanner(System.in);
                                    String nama = sc.nextLine();
                                    String id = "";
                                    //cek apakah id sudah ada
                                    boolean sudahada;
                                    do{
                                        System.out.print("Masukkan ID       : ");
                                        id = sc.next();
                                        sudahada = false;
                                        for (int i = 0; i < jumlahMember; i++) {
                                            if(member[i].getid().equalsIgnoreCase(id)){
                                                sudahada = true;
                                                break;
                                            }
                                        }
                                        if(sudahada){
                                            System.out.println("ID Sudah Ada");
                                        }
                                    }while(sudahada == true);
                                    System.out.print("Masukkan No.Telp  : ");
                                    String telp = sc.next();
                                    System.out.print("Masukkan Alamat   : ");
                                    sc = new Scanner(System.in);
                                    String alm = sc.nextLine();
                                    member[jumlahMember] = new bbMember(id, nama, telp, alm);
                                    jumlahMember++;                                    
                                }else{                                   
                                    System.out.println("                        Kapasitas Penuh!!");
                                }                                                      
                                break;
                            case 2:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              UPDATE  MEMBER             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah object member harus minimal 1
                                if(jumlahMember > 0){
                                    System.out.print("Masukkan ID   : ");
                                    String id = sc.next();
                                    //cari array object di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahMember; i++) {
                                        if(member[i].getid().equalsIgnoreCase(id)){
                                            ketemu = true;
                                            System.out.println("\n                           Data Ditemukan");
                                            //skenarionya update telp dan nama baru
                                            System.out.print("Nama Baru     : ");
                                            sc = new Scanner(System.in);
                                            String nama = sc.nextLine();
                                            System.out.print("No.Telp Baru  : ");
                                            String telp = sc.next();
                                            System.out.println("\nSimpan Data?");
                                            System.out.println("1. Ya");
                                            System.out.println("2. Tidak");
                                            System.out.print("Pilih  \t: ");
                                            pilihMember = sc.nextInt();
                                            if(pilihMember == 1){
                                                //update elemen array object di main
                                                member[i].setnama(nama);
                                                member[i].settelp(telp);
                                                System.out.println("\n                            Data Diupdate");                                   
                                            }else{
                                                System.out.println("Batal Update");
                                                break;
                                            }
                                        }
                                        if(!ketemu){
                                            System.out.println("ID Tidak Ada");
                                        }
                                    }
                                }else{
                                    System.out.println("Data Member Kosong");
                                }                               
                                break;
                            case 3:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               HAPUS  MEMBER             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah object member harus minimal 1
                                if(jumlahMember > 0){
                                    System.out.print("Masukkan ID   : ");
                                    String id = sc.next();
                                    //cari array object member di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahMember; i++) {
                                        ketemu = true;
                                        System.out.println("\n                           Data Ditemukan");
                                        System.out.println("Hapus?");
                                        System.out.println("1. Ya");
                                        System.out.println("2. Tidak");
                                        System.out.print("Pilih  \t: ");
                                        pilihMember = sc.nextInt();
                                        if(pilihMember == 1){
                                            //hapus elemen array object di main
                                            member[i] = null;
                                            //geser maju untuk mengisi elemen yang dihapus
                                            for (int j = 0; j < jumlahMember; j++) {
                                                if(j == jumlahMember-1){
                                                    member[j] = null;
                                                }else{
                                                    member[j] = member[j+1];
                                                }
                                                jumlahMember--;
                                                System.out.println("\n                             Data Dihapus");
                                            }
                                        }else{
                                            System.out.println("Batal Hapus");
                                            break;
                                        }
                                    }
                                    if(!ketemu){
                                        System.out.println("ID Tidak Ada");                                        
                                    }
                                }else{
                                    System.out.println("Data Member Ksosong");
                                }
                                break;
                            case 4:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("                DATA  MEMBER             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //onject baru harus ada dulu
                                if(jumlahMember > 0){
                                    System.out.println("\nNo.\tID\tNama\tTelp\tAlamat");                                    
                                    System.out.println("-----------------------------------------");
                                    for (int i = 0; i < jumlahMember; i++) {
                                        System.out.print((i+1) + ".\t");
                                        System.out.print(member[i].getid() + "\t");
                                        System.out.print(member[i].getnama() + "\t");
                                        System.out.print(member[i].gettelp() + "\t");
                                        System.out.println(member[i].getalamat());
                                    }
                                }else{
                                    System.out.println("Data Member Kosong");
                                }
                                break;
                            case 5:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("            QUERY DATA  MEMBER           ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //object member harus ada dlu
                                if(jumlahMember > 0){
                                    for (int i = 0; i < jumlahMember; i++) {
                                        System.out.println(member[i].ToString());
                                    }
                                }else{
                                    System.out.println("Data Member Kosong");
                                }
                                break;
                            case 6:
                                System.out.println("\n  ← Kembali ");
                                break;
                            default :
                                System.out.println("Pilihan Tidak Ada!!");
                        }  
                    }while (pilihMember != 6);                   
                    break;                   
                case 2:
                    int pilihPaket = 0;
                    do{
                        System.out.println("\n=========================================");
                        System.out.println("                 MENU PAKET                ");
                        System.out.println("=========================================");
                        System.out.println("1. Tambah Paket");
                        System.out.println("2. Update Data Paket");
                        System.out.println("3. Hapus Paket");
                        System.out.println("4. Cetak Data Paket");
                        System.out.println("5. Query");
                        System.out.println("6. Kembali");
                        System.out.print("\nPilih  \t: ");
                        pilihPaket = sc.nextInt();  
                        switch(pilihPaket){
                            case 1:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               TAMBAH PAKET              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah paket masih di bawah kapasitas max
                                if(jumlahPaket < maxPaket){
                                    System.out.print("Masukkan Nama Paket   : ");
                                    sc = new Scanner(System.in);
                                    String jns = sc.nextLine();
                                    String kd = "";
                                    //cek apakah kode paket sudah ada
                                    boolean sudahada;
                                    do{
                                        System.out.print("Masukkan Kode Paket   : ");
                                        kd = sc.next();
                                        sudahada = false;
                                        for (int i = 0; i < jumlahPaket; i++) {
                                            if(paket[i].getkodePaket().equalsIgnoreCase(kd)){
                                                sudahada = true;
                                                break;
                                            }
                                        }
                                        if(sudahada){
                                            System.out.println("Kode Paket Sudah Ada");
                                        }
                                    }while(sudahada == true);
                                    System.out.print("Masukkan Harga    : Rp. ");
                                    int hrg = sc.nextInt();                                    
                                    paket[jumlahPaket] = new bbPaket(jns, kd, hrg);
                                    jumlahPaket++;                                    
                                }else{                                   
                                    System.out.println("                        Kapasitas Penuh!!");
                                }
                                break;
                            case 2:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               UPDATE PAKET              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah object paket harus minimal 1
                                if(jumlahPaket > 0){
                                    System.out.print("Masukkan Kode Paket   : ");
                                    String kd = sc.next();
                                    //cari array object di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahPaket; i++) {
                                        if(paket[i].getkodePaket().equalsIgnoreCase(kd)){
                                            ketemu = true;
                                            System.out.println("\n                           Data Ditemukan");
                                            //skenarionya update nama dan harga baru
                                            System.out.print("Nama Paket Baru   : ");
                                            sc = new Scanner(System.in);
                                            String jns = sc.nextLine();
                                            System.out.print("Harga Baru        : Rp. ");
                                            int hrg = sc.nextInt();
                                            System.out.println("\nSimpan Data?");
                                            System.out.println("1. Ya");
                                            System.out.println("2. Tidak");
                                            System.out.print("Pilih  \t: ");
                                            pilihPaket = sc.nextInt();
                                            if(pilihPaket == 1){
                                                //update elemen array object di main
                                                paket[i].setjenisPaket(jns);
                                                paket[i].setharga(hrg);
                                                System.out.println("\n                            Data Diupdate");                                   
                                            }else{
                                                System.out.println("Batal Update");
                                                break;
                                            }
                                        }
                                        if(!ketemu){
                                            System.out.println("Kode Paket Tidak Ada");
                                        }
                                    }
                                }else{
                                    System.out.println("Data Paket Kosong");
                                }
                                break;
                            case 3:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("                HAPUS PAKET              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah object paket harus minimal 1
                                if(jumlahPaket > 0){
                                    System.out.print("Masukkan Kode Paket   : ");
                                    String kd = sc.next();
                                    //cari array object paket di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahPaket; i++) {
                                        ketemu = true;
                                        System.out.println("\n                           Data Ditemukan");
                                        System.out.println("Hapus?");
                                        System.out.println("1. Ya");
                                        System.out.println("2. Tidak");
                                        System.out.print("Pilih  \t: ");
                                        pilihPaket = sc.nextInt();
                                        if(pilihPaket == 1){
                                            //hapus elemen array object di main
                                            paket[i] = null;
                                            //geser maju untuk mengisi elemen yang dihapus
                                            for (int j = 0; j < jumlahPaket; j++) {
                                                if(j == jumlahPaket-1){
                                                    paket[j] = null;
                                                }else{
                                                    paket[j] = paket[j+1];
                                                }
                                                jumlahPaket--;
                                                System.out.println("\n                             Data Dihapus");
                                            }
                                        }else{
                                            System.out.println("Batal Hapus");
                                            break;
                                        }
                                    }
                                    if(!ketemu){
                                        System.out.println("Kode Paket Tidak Ada");                                        
                                    }
                                }else{
                                    System.out.println("Data Paket Kosong");
                                }
                                break;
                            case 4:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("                DATA PAKET               ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //object baru harus ada dulu
                                if(jumlahPaket > 0){
                                    System.out.println("\nNo.\tKode\tNama\t\tHarga");
                                    System.out.println("-----------------------------------------");
                                    for (int i = 0; i < jumlahPaket; i++) {
                                        System.out.print((i+1) + ".\t");
                                        System.out.print(paket[i].getkodePaket() + "\t");
                                        System.out.print(paket[i].getjenisPaket() + "\t");
                                        System.out.println("Rp. " + paket[i].getharga());                                        
                                    }
                                }else{
                                    System.out.println("Data Paket Kosong");
                                }                                
                                break;                                
                            case 5:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("             QUERY DATA PAKET            ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //object paket harus ada dlu
                                if(jumlahPaket > 0){
                                    for (int i = 0; i < jumlahPaket; i++) {
                                        System.out.println(paket[i].ToString());
                                    }
                                }else{
                                    System.out.println("Data Paket Kosong");
                                }
                                break;
                            case 6:
                                System.out.println("\n  ← Kembali ");
                                break;
                            default :
                                System.out.println("Pilihan Tidak Ada!!");
                        }
                    }while (pilihPaket != 6);
                    break;
                case 3:
                    int pilihTransaksi = 0;
                    do{
                        System.out.println("\n=========================================");
                        System.out.println("               MENU TRANSAKSI              ");
                        System.out.println("=========================================");
                        System.out.println("1. Tambah Transaksi");
                        System.out.println("2. Hapus Transaksi");
                        System.out.println("3. Ambil Paket");
                        System.out.println("4. Hapus Paket");
                        System.out.println("5. Cetak Transaksi");
                        System.out.println("6. Kembali");
                        System.out.print("\nPilih  \t: ");
                        pilihTransaksi = sc.nextInt();     
                        switch(pilihTransaksi){
                            case 1:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              BUAT TRANSAKSI             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahTransaksi < maxTransaksi){
                                    System.out.print("Masukkan ID       : ");
                                    String id = sc.next();
                                    System.out.print("Masukkan Periode  : ");
                                    String p = sc.next();
                                    //validasi member ke array object di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahMember; i++) {
                                        if(member[i] != null && member[i].getid().equalsIgnoreCase(id)){
                                            ketemu = true;
                                            transaksi[jumlahTransaksi] = new bbTransaksi();
                                            transaksi[jumlahTransaksi].setMember(member[i]);
                                            transaksi[jumlahTransaksi].setPeriode(p);
                                            jumlahTransaksi++;                                                                                                                                             
                                            break;
                                        }
                                    }
                                    if(ketemu = false){
                                        System.out.println("ID Tidak Ada");
                                    }
                                }else{
                                    System.out.println("                        Kapasitas Penuh!!");
                                }
                                break;
                            case 2:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              HAPUS TRANSAKSI            ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahTransaksi > 0){
                                    System.out.print("Masukkan ID       : ");
                                    String id = sc.next();
                                    System.out.print("Masukkan Periode  : ");
                                    String p = sc.next();
                                    //validasi member dan period
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahTransaksi; i++) {
                                        if(transaksi[i] != null && transaksi[i].getMember().getid().equalsIgnoreCase(id)){
                                            if(transaksi[i].getPeriode().equalsIgnoreCase(p)){
                                                ketemu = true;
                                                System.out.println("Hapus?");
                                                System.out.println("1. Ya");
                                                System.out.println("2. Tidak");
                                                System.out.print("Pilih  \t: ");
                                                pilihTransaksi = sc.nextInt();
                                                if(pilihTransaksi == 1){
                                                    //hapus elemen array object di main
                                                    transaksi[i] = null;
                                                    //geser elemen array ke depan
                                                    int t = 0;
                                                    for (int j = 0; j < jumlahTransaksi; j++) {
                                                        if(j == jumlahTransaksi-1){
                                                            transaksi[j] = null;
                                                        }else{
                                                            transaksi[j] = transaksi[j+1];
                                                        }
                                                        jumlahTransaksi--;
                                                        
                                                        System.out.println("\n                             Data Dihapus");
                                                    }
                                                }else{
                                                    System.out.println("Batal Hapus");
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if(ketemu == false){
                                        System.out.println("Transaksi Tidak Ada");
                                    }
                                }else{
                                    System.out.println("Transaksi Belum Ada");
                                }
                                break;
                            case 3:                                
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("                AMBIL PAKET              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahTransaksi > 0){
                                    System.out.print("Masukkan ID       : ");
                                    String id = sc.next();
                                    System.out.print("Masukkan Periode  : ");
                                    String p = sc.next();
                                    //validasi member dan period
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahTransaksi; i++) {
                                        if(transaksi[i] != null && transaksi[i].getMember().getid().equalsIgnoreCase(id)){
                                            if(transaksi[i].getPeriode().equalsIgnoreCase(p)){
                                                ketemu = true;
                                                System.out.print("Masukkan Kode Paket   : ");
                                                String kd = sc.next();
                                                //validasi kode paket ke array paket di main
                                                for (int j = 0; j < jumlahTransaksi; j++) {
                                                    if(paket[j] != null && paket[j].getkodePaket().equalsIgnoreCase(kd)){
                                                        System.out.println("Tambah?");
                                                        System.out.println("1. Ya");
                                                        System.out.println("2. Tidak");
                                                        System.out.print("Pilih  \t: ");
                                                        pilihTransaksi = sc.nextInt();
                                                        if(pilihTransaksi == 1){
                                                            //simpan ke array object paket di transaksi
                                                            transaksi[i].tambahPaket(paket[j]);                                                                                                                        
                                                        }else{
                                                            System.out.println("Batal Tambah");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if(ketemu == false){
                                        System.out.println("Transaksi Tidak Ada");
                                    }
                                }else{
                                    System.out.println("Transaksi Belum Ada");
                                }
                                break;
                            case 4:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("             HAPUS DATA PAKET            ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahTransaksi > 0){
                                    System.out.print("Masukkan ID       : ");
                                    String id = sc.next();
                                    System.out.print("Masukkan Periode  : ");
                                    String p = sc.next();
                                    //validasi id dan period
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahTransaksi; i++) {
                                        if(transaksi[i] != null && transaksi[i].getMember().getid().equalsIgnoreCase(id)){
                                            if(transaksi[i].getPeriode().equalsIgnoreCase(p)){
                                                //tampilkan daftar paket yang ada di transaksi member
                                                bbPaket t[] = transaksi[i].getPaket();
                                                for (int j = 0; j < transaksi[i].getjumlahPaket(); j++) {
                                                    System.out.print(" " + t[j].getkodePaket() + "\t");
                                                    System.out.print(t[j].getjenisPaket() + "\t");
                                                    System.out.println("Rp. " + t[j].getharga());
                                                }
                                                System.out.print("Masukkan Kode Paket   : ");
                                                String kd = sc.next();
                                                //validasi kode paket ke array paket di transaksi
                                                for (int j = 0; j < jumlahPaket; j++) {
                                                    if(t[j].getkodePaket().equalsIgnoreCase(kd)){
                                                        ketemu = true;
                                                        System.out.println("Hapus?");
                                                        System.out.println("1. Ya");
                                                        System.out.println("2. Tidak");
                                                        System.out.print("Pilih  \t: ");
                                                        pilihTransaksi = sc.nextInt();
                                                        if(pilihTransaksi == 1){
                                                            //simpan ke array object paket di transaksi
                                                            transaksi[i].hapusPaket(kd);
                                                        }else{
                                                            System.out.println("Batal Tambah");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                        if(ketemu == false){
                                            System.out.println("Transaksi Tidak Ada");
                                        }
                                    }                                    
                                }else{
                                    System.out.println("Transaksi Belum Ada");
                                }
                                break;
                            case 5:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              CETAK TRANSAKSI            ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahTransaksi > 0){
                                    System.out.print("Masukkan ID       : ");
                                    String id = sc.next();
                                    System.out.print("Masukkan Periode  : ");                                            
                                    String p = sc.next();
                                    //validasi member dan period
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahTransaksi; i++) {
                                        if(transaksi[i].getMember().getid().equalsIgnoreCase(id)){
                                            if(transaksi[i].getPeriode().equalsIgnoreCase(p)){
                                                ketemu = true;
                                                if(transaksi[i].getjumlahPaket() > 0){
                                                    System.out.println(transaksi[i].ToString());
                                                }else{
                                                    System.out.println("Transaksi Belum Ditambahkan");
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if(ketemu == false){
                                        System.out.println("Transaksi Tidak Ada");
                                    }
                                }else{
                                    System.out.println("Transaksi Belum Ada");
                                }
                                break;
                            case 6:
                                System.out.println("\n  ← Kembali ");
                                break;
                            default :
                                System.out.println("Pilihan Tidak Ada");
                        }
                    }while(pilihTransaksi!=6);
                    break;
                case 4:
                    int pilihOutlet = 0;
                    do{
                        System.out.println("\n=========================================");
                        System.out.println("                MENU OUTLET                ");
                        System.out.println("=========================================");
                        System.out.println("1. Buat Outlet");
                        System.out.println("2. Hapus Outlet");
                        System.out.println("3. Update Data Outlet");
                        System.out.println("4. Tambah Member");
                        System.out.println("5. Hapus Member");
                        System.out.println("6. Cetak Member");
                        System.out.println("7. Kembali");
                        System.out.print("\nPilih  \t: ");
                        pilihOutlet = sc.nextInt();
                        switch(pilihOutlet){
                            case 1:                                                                
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              TAMBAH  OUTLET             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah outlet masih di bawah kapasitas max
                                if(jumlahOutlet < maxOutlet){
                                    System.out.print("Masukkan Nama Outlet  : ");
                                    sc = new Scanner(System.in);
                                    String nm = sc.nextLine();
                                    String kd = "";
                                    //cek apakah kode paket sudah ada
                                    boolean sudahada;
                                    do{
                                        System.out.print("Masukkan Kode Outlet  : ");
                                        kd = sc.next();
                                        sudahada = false;
                                        for (int i = 0; i < jumlahOutlet; i++) {
                                            if(outlet[i].getKodeOutlet().equalsIgnoreCase(kd)){
                                                sudahada = true;
                                                break;
                                            }
                                        }
                                        if(sudahada){
                                            System.out.println("Kode Outlet Sudah Ada");
                                        }
                                    }while(sudahada == true);
                                    System.out.print("Masukkan Kapasitas    : ");
                                    String k = sc.next();                                    
                                    outlet[jumlahOutlet] = new bbOutlet(nm, kd, k);
                                    jumlahOutlet++;                                    
                                }else{                                   
                                    System.out.println("                          Kapasitas Penuh!!");
                                }                                                          
                                break;
                            case 2:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               HAPUS OUTLET              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah object outlet harus minimal 1
                                if(jumlahOutlet > 0){
                                    System.out.print("Masukkan Kode Outlet  : ");
                                    String kd = sc.next();
                                    //cari array object outlet di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahOutlet; i++) {
                                        ketemu = true;
                                        System.out.println("\n                           Data Ditemukan");
                                        System.out.println("Hapus?");
                                        System.out.println("1. Ya");
                                        System.out.println("2. Tidak");
                                        System.out.print("Pilih  \t: ");
                                        pilihOutlet = sc.nextInt();
                                        if(pilihOutlet == 1){
                                            //hapus elemen array object di main
                                            outlet[i] = null;
                                            //geser maju untuk mengisi elemen yang dihapus
                                            for (int j = 0; j < jumlahOutlet; j++) {
                                                if(j == jumlahOutlet-1){
                                                    outlet[j] = null;
                                                }else{
                                                    outlet[j] = outlet[j+1];
                                                }
                                                jumlahOutlet--;
                                                System.out.println("\n                             Data Dihapus");
                                            }
                                        }else{
                                            System.out.println("Batal Hapus");
                                            break;
                                        }
                                    }
                                    if(!ketemu){
                                        System.out.println("Kode Outlet Tidak Ada");                                        
                                    }
                                }else{
                                    System.out.println("Data Outlet Kosong");
                                }
                                break;
                            case 3:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               UPDATE OUTLET             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                //jumlah object outlet harus minimal 1
                                if(jumlahOutlet > 0){
                                    System.out.print("Masukkan Kode Outlet  : ");
                                    String kd = sc.next();
                                    //cari array object di main
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahOutlet; i++) {
                                        if(outlet[i].getKodeOutlet().equalsIgnoreCase(kd)){
                                            ketemu = true;
                                            System.out.println("\n                           Data Ditemukan");
                                            //skenarionya update nama dan kapasitas baru
                                            System.out.print("Nama Outlet Baru  : ");
                                            sc = new Scanner(System.in);
                                            String nm = sc.nextLine();
                                            System.out.print("Kapasitas         : ");
                                            String k = sc.next();
                                            System.out.println("\nSimpan Data?");
                                            System.out.println("1. Ya");
                                            System.out.println("2. Tidak");
                                            System.out.print("Pilih  \t: ");
                                            pilihOutlet = sc.nextInt();
                                            if(pilihOutlet == 1){
                                                //update elemen array object di main
                                                outlet[i].setNamaOutlet(nm);
                                                outlet[i].setKapasitas(k);
                                                System.out.println("\n                            Data Diupdate");                                   
                                            }else{
                                                System.out.println("Batal Update");
                                                break;
                                            }
                                        }
                                        if(!ketemu){
                                            System.out.println("Kode Outlet Tidak Ada");
                                        }
                                    }
                                }else{
                                    System.out.println("Data Outlet Kosong");
                                }
                                break;
                            case 4:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("              TAMBAH  MEMBER             ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahMember < maxMember){
                                    System.out.print("Masukkan Kode Outlet  : ");
                                    String kd = sc.next();
                                    System.out.print("Masukkan ID Member    : ");
                                    String id = sc.next();
                                    boolean sudahada = false;
                                    for (int i = 0; i < jumlahMember; i++) {
                                        if(member[i] != null && member[i].getid().equalsIgnoreCase(id)){
                                            if(outlet[i] != null && outlet[i].getKodeOutlet().equalsIgnoreCase(kd)){
                                                outlet[i].setMember(member[i]);                                
                                                System.out.println("\n                       Member Ditambahkan"); 
                                            }else{
                                                System.out.println("Outlet Tidak Ada");
                                            }
                                        }else{
                                            System.out.println("ID Belum Terdaftar");
                                        }
                                    }
                                    if(sudahada){
                                        System.out.println("ID Sudah Ada");
                                    }
                                }else{
                                    System.out.println("Kapasitas Penuh");
                                }                                
                                break;
                            case 5:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               HAPUS MEMBER              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahMember > 0){
                                    System.out.print("Masukkan Kode Outlet  : ");
                                    String kd = sc.next();
                                    System.out.print("Masukkan ID Member    : ");
                                    String id = sc.next();
                                    boolean ketemu = false;
                                    for (int i = 0; i < jumlahMember; i++) {
                                        if(outlet[i] != null && outlet[i].getKodeOutlet().equalsIgnoreCase(kd)){
                                            if(outlet[i].getMember() != null && outlet[i].getMember().getid().equalsIgnoreCase(id)){
                                                ketemu = true;
                                                outlet[i].deleteMember();
                                                System.out.println("\n                             Data Dihapus");
                                            }else{
                                                System.out.println("ID Tidak Ada");
                                            }
                                        }else{
                                            System.out.println("Outlet Tidak Ada");
                                        }
                                    }                                    
                                    if(!ketemu){
                                        System.out.println("Kode Outlet Tidak Ada");
                                    }
                                }else{
                                    System.out.println("Data Outlet Kosong");
                                }                                
                                break;
                            case 6:
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                System.out.println("               DATA  MEMBER              ");
                                System.out.println("= = = = = = = = = = = = = = = = = = = = =");
                                if(jumlahOutlet > 0){
                                    for (int i = 0; i < jumlahOutlet; i++) {
                                        if(outlet != null){
                                            System.out.println("\nOutlet " + outlet[i].getNamaOutlet());
                                            System.out.println("--------------------");                                            
                                            if(outlet[i].getMember() != null){
                                                System.out.println(outlet[i].getMember().ToString());
                                            }else{
                                                System.out.println("Member Tidak Ada");
                                            }
                                        }else{
                                            System.out.println("Outlet Tidak Ada");
                                        }
                                    }                                    
                                }                                
                                break;
                            case 7:
                                System.out.println("\n  ← Kembali ");
                                break;
                            default :
                                System.out.println("Pilihan Tidak Ada!");
                        }
                    }while(pilihOutlet!=7);
                    break;
                case 5:
                    System.out.println("\n=========================================");
                    System.out.println("                TERIMA KASIH               ");
                    System.out.println("=========================================");
                    break;
                default :
                    System.out.println("Pilihan Tidak Ada!!");
            }
        }while (pilih!=5);
    }
}