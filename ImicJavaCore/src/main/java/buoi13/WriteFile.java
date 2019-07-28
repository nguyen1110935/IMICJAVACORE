package buoi13;

import java.io.FileOutputStream;

public class WriteFile {
    public static void main(String[] args) {
        String outString = "This is a message 2";
        FileOutputStream file = null;
        try{
            file = new FileOutputStream("C:\\Users\\Nguyen\\Desktop\\demo.txt");
            byte ouputByte[] = outString.getBytes();
            file.write(ouputByte);
            System.out.println("Sucess...");
        }
        catch ( Exception e){
            System.err.println(e);
        } finally {
            try {
                file.close();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }
    }
}
