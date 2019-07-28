package buoi7;

import java.util.Random;

public class conGa extends DongVat
{
    Random rand = new Random();
    int sanLuongTrung = rand.nextInt(20);// Toi da 20 trung/mua
    double cost;

    public conGa(){
        trongluong = rand.nextInt(3)+1; // trongluong ga tu 1 den 4kg
        this.cost  = trongluong*10 + sanLuongTrung*1;
    }

    @Override
    void ngu() {
        System.out.println("Con Ga biet ngu");
    }

    @Override
    void an() {
        System.out.println("Con Ga biet an");
    }

    @Override
    void chay() {
        System.out.println("Con Ga biet chay");
    }

    @Override
    void  tinhGiaTri (){
        System.out.println(id + " co gia tri " + cost + "$");
    }
}
