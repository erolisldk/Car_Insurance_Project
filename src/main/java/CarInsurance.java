import java.util.InputMismatchException;
import java.util.Scanner;

public class CarInsurance {
        /*
      Arac Sigorta Prim Hesaplama
      Arac tipleri :otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
      Tarife dönemi: Aralik 2022,  Haziran 2022
      1.dönem   :Haziran 2022              2. dönem: Aralik 2022
        otomobil :2000                        otomobil :2500
        kamyon :3000                          kamyon : 3500
        otobüs :tip1 :4000 tip2: 5000         otobüs :tip1 :4500 tip2: 5500
        motosiklet :1500                      motosiklet: 1750
        Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü gösterilsin.
       */

    public static void main(String[] args) {

        start();
    }

    public static void start(){
        Scanner inp= new Scanner(System.in);
        boolean isFail; // flag variable ==> condition control variable
        //hatalı girişte veya yeni işlem için menü tekrar gösterilsin: do-while
        do {
            isFail=false;
            System.out.println("----Zorunlu Sigorta Primi Hesaplama--");
            System.out.println("Tarife dönemi seçiniz: ");
            System.out.println("1. Haziran 2022");
            System.out.println("2. Aralık 2022");
            int term = 0;
            try {
                term = inp.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Gecersiz giriş, lütfen sayı giriniz.");
            }
            inp.nextLine();

            // girilen dönem geçerli mi?
            if (term==1 || term==2){
                Car arac = new Car();
                String termName= term==1 ? "Haziran 2022" : "Aralık 2022";
                System.out.println("Araç tipini giriniz:");
                System.out.println("(otomobil, kamyon, otobüs, motosiklet)");
                String select = inp.next(); //kamyon, otomobil vs
                arac.type=select;
                arac.countPrim(term);
                if (arac.prim>0) {
                    System.out.println("Hesaplama işlemi başarıyla tamamlandı.");
                    // sonucu yazdır
                    System.out.println("Arac tipi: " + arac.type);
                    System.out.println("Tarife dönemi: " + termName);
                    System.out.println("Aracınızın ilgili dönem sigorta primi: " + arac.prim);
                    isFail = isAgain(inp);

                }else {
                    System.out.println("Hesaplama başarısız, tekrar deneyiniz'");
                    start();
                }
            }else{
                System.out.println("Hatalı giriş!!!");
                isFail=true;
            }

        }while (isFail);  // isFail ==> true oldugunda hatalı giriş oldu demektir, döngü başa döner.
        System.out.println("İyi günler dileriz...");


    }

    private static boolean isAgain(Scanner inp) {  // bir cod blogunu olusturmak icin refactor extract method kullanarak o blogu hazir method haline getirebilirz.
        boolean isFail;
        System.out.println("Yeni işlem yapmak için 1" + "/nÇıkış yapmak için 0'a basınız:");
        int choice = inp.nextInt();
        if (choice == 1)
            isFail = true;
        else
            isFail = false;
        return isFail;
}

}
