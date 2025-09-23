package Modeller.Calisanlar;
import Veritabani.Calisanlar;

import Modeller.Departmanlar.Departman;
import Veritabani.Calisanlar;
import Veritabani.Departmanlar;
import com.sun.tools.javac.Main;

public class Calisan {

    private String calisanId;
    private String adSoyad;
    private int maas;
    private Departman Departman;
    private String isimKodu = "";
    private static int sayac = 250;

    public Calisan(String adSoyad, int maas, String departmanKodu) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        setDepartman(departmanKodu);
        this.setCalisanId();
        Calisanlar.addACalisan(this);
        sayac++;

    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    private void setDepartman(String departman) {
        for (Departman depart: Departmanlar.getDepartmanList() ){
            if (depart.getDepartmanKodu().equalsIgnoreCase(departman)) {
                this.Departman = depart;
            }
        }
    }


    private void setCalisanId() {
        sayac = Calisanlar.getCalisanList().size();
        this.calisanId = this.Departman.getDepartmanKodu()+ sayac + getCalisanIsimKodu();

    }

    private String getCalisanIsimKodu() {
        String[] isimler = adSoyad.split(" ");
        for (String isim : isimler) {
            this.isimKodu += isim.substring(0, 1).toUpperCase();
        }
        return this.isimKodu;
    }


    // Calisanin id sini almak icin basit getter method
    public String getCalisanId() {
        return this.calisanId;
    }

    // Calisanin departmanini almak icin basit getter method
    public Departman getDepartman() {
        return this.Departman;
    }


    // Departman adini verebilmek için bir method
    public String getDepartmanAdi() {
        String kod = getDepartman().getDepartmanKodu();

        switch (kod) {
            case "BTD":
                return "Bilişim Teknolojileri Departmanı";
            case "IKD":
                return "İnsan Kaynakları Departmanı";
            case "YD":
                return "Yönetim Departmanı";
            default:
                return "Geçersiz departman";
        }
    }

    public static void zamYap(String calisanId) {
        if (calisanId.equals("")){
            System.out.println("böyle bir çalışan yok");
        }else {
            for (Calisan calisan: Calisanlar.getCalisanList()){
                if (calisan.getCalisanId().equals(calisanId)){
                    int oran= calisan.getDepartman().getZamOrani();
                    calisan.maas= calisan.maas+ (calisan.maas*oran/100);
                    System.out.println("zam yapıldı ");
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {


        //
        // TODO toString() metheodunu doldurunuz



        return  "Calisan ID : '" + calisanId + "', Isim Soyisim : '" + adSoyad + "', Maas : '" + maas + "', Departman : '" + getDepartmanAdi() + "'" ;

    }
}
