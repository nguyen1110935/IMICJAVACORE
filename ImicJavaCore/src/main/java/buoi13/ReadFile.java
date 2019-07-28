package buoi13;

import java.io.FileInputStream;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        FileInputStream  file = null;
        try {
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\Nguyen\\Desktop\\demo2.txt"));
            StringBuilder sb = new StringBuilder();
            while (in.hasNext()){
                sb.append(in.next());
                sb.append(" ");
            }
            String str = sb.toString();
            System.out.println(str);
        }
        catch ( Exception e){
            System.err.println(e);
            System.out.println(" Debug1");
        }

    }
}
