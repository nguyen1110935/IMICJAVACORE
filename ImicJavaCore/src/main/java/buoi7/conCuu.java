package buoi7;

import java.util.Random;

public class conCuu extends DongVat
{
    Random rand = new Random();
    double sanLuongLong= rand.nextInt(20);
    double cost;
    public conCuu(){
        trongluong = rand.nextInt(40)+10; // Trong luong cuu tu 10kg den 50kg
        this.cost  = trongluong*10 + sanLuongLong*5;
    }

    @Override
    void ngu() {
        System.out.println("Con Cuu biet ngu");
    }

    @Override
    void an() {
        System.out.println("Con Cuu biet an");
    }

    @Override
    void chay() {
        System.out.println("Con Cuu biet chay");
    }

    @Override
    void  tinhGiaTri (){
        System.out.println(id + " co gia tri " + cost + "$");
    }
}
