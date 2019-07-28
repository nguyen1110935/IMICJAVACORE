package buoi7;

import java.util.Random;

public class conBo extends DongVat
{
    Random rand = new Random();
    double sanLuongSua = rand.nextInt(50); // Toi da 50 lit sua/mua
    double cost;
    public conBo(){
        trongluong = rand.nextInt(175)+25; // Trong luong tu 25kg den 200kg
        this.cost  = trongluong*10 + sanLuongSua*1;

    }
    @Override
    void ngu() {
        System.out.println("Con Bo biet ngu");
    }

    @Override
    void an() {
        System.out.println("Con Bo biet an");
    }

    @Override
    void chay() {
        System.out.println("Con Bo biet chay");
    }

    @Override
    void  tinhGiaTri (){
        System.out.println(id + " co gia tri " + cost + "$");
    }
}
