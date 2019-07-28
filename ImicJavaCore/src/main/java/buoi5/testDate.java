package buoi5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDate {
    public static void main(String[] args) {
        String str = "2019/Jun/67 19:54:99";
        //Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");

        try {
            Date dnow = ft.parse(str);
            System.out.println(dnow.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
