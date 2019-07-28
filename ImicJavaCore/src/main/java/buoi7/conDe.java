package buoi7;

import java.util.Random;

public class conDe extends DongVat{
    Random rand = new Random();
    double cost;

    public conDe (){
        trongluong = rand.nextInt(40)+10; // Trong luong cuu tu 10kg den 50kg
        this.cost  = trongluong*10;
    }
    @Override
    void ngu() {
        System.out.println("Con De biet ngu");
    }

    @Override
    void an() {
        System.out.println("Con De biet an");
    }

    @Override
    void chay() {
        System.out.println("Con De biet chay");
    }

    @Override
    void  tinhGiaTri (){
        System.out.println(id + " co gia tri " + cost + "$");
    }
}
