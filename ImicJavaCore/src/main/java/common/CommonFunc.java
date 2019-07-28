package common;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CommonFunc {

    //Convert String from user input to Date type
    public static Date dateInput (String str){
        //Date date = new Date();
        Date my_date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MMM/yyyy");

        try {
            my_date = ft.parse(str);
            //System.out.println("Import date: "+my_date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return my_date;
    }


    public static void writeFile (String outString, String filePatch) {
        System.out.println("Program is writing data");
        FileOutputStream file = null;
        try{
            file = new FileOutputStream(filePatch);
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


    public static String readFile(String filePatch) {
        FileInputStream file = null;
        String str = "";
        System.out.println("Program is reading data");
        try {
            Scanner in = new Scanner(new FileInputStream(filePatch));
            StringBuilder sb = new StringBuilder();

            while (in.hasNext()){
                sb.append(in.nextLine());
                sb.append("\n");
            }
            str = sb.toString();
        }
        catch ( Exception e){
            System.err.println(e);
            System.out.println("Error !!!");
        }
        return str;
    }
}
