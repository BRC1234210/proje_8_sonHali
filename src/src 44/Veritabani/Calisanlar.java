package Veritabani;

import Modeller.Calisanlar.Calisan;
import java.util.ArrayList;

public class Calisanlar {


    // Buradaki calisanList static cünkü proje calismaya basladiği anda oluşması lazım.
    // Bunu bir veritabani gibi görebiliriz. Calisanlarimizin hepsi bu liste icerisinde yer alacak.
    private static ArrayList<Calisan> calisanList = new ArrayList<>();

    // // Tüm çalışanları almak için
    public static ArrayList<Calisan> getCalisanList() {
        return calisanList;
    }


    public static void addACalisan(Calisan calisan) {
        calisanList.add(calisan);
    }


    public static void deleteACalisanWithId(String calisanId) {
        boolean bulunduMu= false;
        for (Calisan calisan: calisanList){
            if (calisan.getCalisanId().equals(calisanId)){
                calisanList.remove(calisan);
                bulunduMu=true;
                System.out.println("çalışan başarıyla silindi.");
                break;
            }
        }
        if (!bulunduMu){
            System.out.println("böyle bir çalışan yok.");
        }

    }


    public static void printDepartmandakiCalisanlar(String departmanKodu) {
        for (Calisan calisan2 : calisanList) {
            if (calisan2.getDepartman().getDepartmanKodu().equals(departmanKodu)) {
                System.out.println(calisan2);
            }
        }
    }


    public static void printCalisanlar() {
        for (Calisan calisan3: calisanList){
            System.out.println(calisan3);
        }

    }
}
