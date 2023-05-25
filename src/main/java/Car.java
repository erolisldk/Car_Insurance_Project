import java.util.Scanner;

public class Car {
    // otomobil, kamyon, otobüs, motosiklet objelerini olusturabilmek için Arac class'ını olusturduk.
    // App'te hesaplama yapabilmek için ihtiyacımız olan farklı degerlere sahip olması beklenen ortak özellikleri:
    //tipi,primi
    public String type;
    public int prim;


    public void countPrim(int term){
        switch (this.type){
            case "otomobil":
                this.prim= term==1 ? 2000 : 2500;
                break;
            case "kamyon":
                this.prim= term==1 ? 3000 : 3500;
                break;
            case "motosiklet":
                this.prim= term==1 ? 1500 : 1750;
                break;
            case "otobüs":
                countPrimBus(term);
                break;
            default:
                System.out.println("Hatalı giriş yaptınız!");
                this.prim=0;
                break;
        }
    }
    private void countPrimBus(int term){
        Scanner inp = new Scanner(System.in);
        System.out.println("Otobüs tipini giriniz: ");
        System.out.println("1. 18-30 koltuk");
        System.out.println("2. 30 koltuk veya üzeri: ");
        int busType =inp.nextInt();
        switch (busType){
            case 1:
                this.prim = term==1 ? 4000 : 4500;
                break;
            case 2:
                this.prim = term==1 ? 5000 : 5500;
                break;
            default:
                System.out.println("Hatalı giriş yaptınız!");
                this.prim=0;
                break;

 }
}

}
