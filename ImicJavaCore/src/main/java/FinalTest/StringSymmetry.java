//Bai tap 3
package FinalTest;

import java.util.Scanner;

public class StringSymmetry {
    public static void main(String[] args) {
        if (checkSymmetry()){
            System.out.println("This string IS symmetrical");
        }
    }

    public static boolean checkSymmetry (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your string.");
        String str=scan.nextLine();
        String[] arr = str.split("");
        for (int i =0, j = arr.length-1; i < arr.length; i++, j--) {
            if (arr[i].equals(arr[j])) {
                continue;
            }
            else {
                System.out.println(arr[i]+" and "+arr[j]+" do NOT match.");
                System.out.println("This string is NOT symmetrical");
                return false;
            }
        }
        return true;
    }
}
