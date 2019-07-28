package buoi7;

import java.util.Random;

public class classTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int soGa  = rand.nextInt(10);
        int soBo  = rand.nextInt(10-soGa);
        int soCuu = rand.nextInt(10-soGa-soBo);
        int soDe  = 10-soGa-soBo-soCuu;
        double tongGiaTriTrangTrai =0;

        // Khoi tao ngau nhien so luong Ga, Bo, Cuu va De
        conGa[]  ga_obj_q  = new conGa[soGa];
        conBo[]  bo_obj_q  = new conBo[soBo];
        conCuu[] cuu_obj_q = new conCuu[soCuu];
        conDe[]  de_obj_q  = new conDe[soDe];
        System.out.println("soGa : "+soGa);
        System.out.println("soBo : "+soBo);
        System.out.println("soCuu: "+soCuu);
        System.out.println("soDe : "+soDe);
        // Gan id va sanLuong ngau nhien cho tat ca so ga
        int i = 0;
        for (conGa mot_ga: ga_obj_q ) {
            conGa ga = new conGa();
            ga_obj_q[i] = ga;
            ga_obj_q[i].id = "GA" + i;
            ga_obj_q[i].tinhGiaTri();
            tongGiaTriTrangTrai = tongGiaTriTrangTrai + ga_obj_q[i].cost;
            i++;
        }
        // Gan id va sanLuong ngau nhien cho tat ca so bo
        i = 0;
        for (conBo mot_bo: bo_obj_q ) {
            conBo bo = new conBo();
            bo_obj_q[i] = bo;
            bo_obj_q[i].id = "BO" + i;
            bo_obj_q[i].tinhGiaTri();
            tongGiaTriTrangTrai = tongGiaTriTrangTrai + bo_obj_q[i].cost;
            i++;
        }
        // Gan id va sanLuong ngau nhien cho tat ca so cuu
        i = 0;
        for (conCuu mot_cuu: cuu_obj_q ) {
            conCuu cuu = new conCuu();
            cuu_obj_q[i] = cuu;
            cuu_obj_q[i].id = "CUU" + i;
            cuu_obj_q[i].tinhGiaTri();
            tongGiaTriTrangTrai = tongGiaTriTrangTrai + cuu_obj_q[i].cost;
            i++;
        }
        // Gan id va sanLuong ngau nhien cho tat ca so de
        i = 0;
        for (conDe mot_de: de_obj_q ) {
            conDe de = new conDe();
            de_obj_q[i] = de;
            de_obj_q[i].id = "DE" + i;
            de_obj_q[i].tinhGiaTri();
            tongGiaTriTrangTrai = tongGiaTriTrangTrai + de_obj_q[i].cost;
            i++;
        }

        System.out.println("Tong gia tri nong trai la "+tongGiaTriTrangTrai+" $");
    }
}
