package buoi8;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static buoi8.Control.checkCode;
import static buoi8.Control.checkDuplicatedCode;
import static common.CommonFunc.dateInput;

public class Control {

    public static ArrayList<Container> addNewContainer (int numOfContainer){

        Scanner scan = new Scanner(System.in);
        ArrayList<Container> allContainers      = new ArrayList<>();
        Date currentDate = new Date();

        // User Input information of container
        for(int i =0; i<numOfContainer;i++) {
            Container container = new Container();
            System.out.println("Please set container code index " + i);

            //Input container code
            while (true) {
                String code = scan.next();
                if (allContainers.size() != 0)
                    if (checkDuplicatedCode(code, allContainers)) {
                        System.out.println("Please set container code index " + i + " again.");
                        continue;
                    }
                container.setContainerNumber(code);
                if (checkCode(container.getContainerNumber())) {
                    break;
                } else {
                    System.out.println("Please set container code again: ");
                    continue;
                }
            }

            //Input container type
            System.out.println("Please set container type (Normal/Frozen/...): ");
            container.setContainerType(scan.next());
            //Input container height
            System.out.println("Please set container height (m): ");
            container.setContainerHeight(scan.nextFloat());
            //Input container length
            System.out.println("Please set container length (m): ");
            container.setContainerLength(scan.nextFloat());

            //Input import date
            System.out.println("Please set import date (dd/MM/yyy) Ex: 23/Jun/2019: ");
            while (true) {
                try {
                    container.setContainerImportDate(dateInput(scan.next()));
                } catch (Exception e) {
                    System.out.println("Error !!! Please input import date again: ");
                    continue;
                }
                System.out.println("Current date: " + currentDate);
                System.out.println("Import date : " + container.getContainerImportDate());
                if (container.getContainerImportDate().compareTo(currentDate) < 0) {
                    container.setContainerHold("Y");
                    break;
                } else {
                    System.out.println("Please set import date again (smaller than today date): ");
                    continue;
                }
            }

            //Input container status
            System.out.println("Please set container status (input true(Good); false(Broken): ");
            boolean status = scan.nextBoolean();
            if (status == false) {
                System.out.println("Please set broken information: ");
                container.setContainerLook(scan.nextLine());
                while (true) {
                    container.setContainerLook(scan.nextLine());
                    if (container.getContainerLook().length() <= 5) {
                        System.out.println("Please set broken information at least 5 letters: ");
                        continue;
                    } else {
                        break;
                    }
                }
            }
            container.setContainerStatus(status);

            //Create a list containning allcontainers
            allContainers.add(container);
        }
        return allContainers;
    }


    //Check if container code contain 7 digits and 4 letters or not.
    public static boolean checkCode (String str){
        int cnt_w = 0;
        int cnt_d = 0;
        for (int i =0; i < str.length(); i++){
            if (Character.isLetter(str.charAt(i))){
                cnt_w ++;
            }
            if (Character.isDigit(str.charAt(i))){
                cnt_d ++;
            }
        }
        if (cnt_d ==7 && cnt_w==4 ){
            return true;
        }
        else{
            System.out.println("You input "+cnt_d+" digits and "+cnt_w+" letters");
            System.out.println("Please input 7 digits and 4 letters in container code.");
            return false;
        }
    }

    //Print container info
    public static void printAllContainerInfo (ArrayList<Container> lstContainer){
        for (Container con: lstContainer ) {
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println("Container Code          : "+con.getContainerNumber());
            System.out.println("Container Type          : "+con.getContainerType());
            System.out.println("Container Heigth        : "+con.getContainerHeight());
            System.out.println("Container Lenth         : "+con.getContainerLength());
            System.out.println("Container Status        : "+con.isContainerStatus());
            System.out.println("Container Appearance    : "+con.getContainerLook());
            System.out.println("Container import date   : "+con.getContainerImportDate());
            System.out.println("Container Holding       : "+con.getContainerHold());
            System.out.println("//////////////////////////////////////////////////////");
        }
    }



    //Conduct export procedure of a container
    public static boolean exportContainer(String code, ArrayList<Container> lstContainer){
        Scanner scan = new Scanner(System.in);
        for (Container con: lstContainer ) {
            //System.out.println("Code to find: "+code);
            //System.out.println("Code in queu: "+con.getContainerNumber());
            if (code.equals(con.getContainerNumber())){
                if (con.getContainerHold().equals("N")){
                    System.out.println("This container was expoted. Program exit.");
                    return false;
                }
                System.out.println("Please submit charge 1000$. The container owner submits: ");
                while(true) {
                    con.setContainerSubmmittedCharge(scan.nextInt());
                    if (con.getContainerSubmmittedCharge() < 1000) {
                        System.out.println("You must pay 1000$. Please submit charge again: ");
                        continue;
                    }
                    else {
                        int remain = con.getContainerSubmmittedCharge() - 1000;
                        System.out.printf("Please return %d$ to the container owner. ", remain);
                        con.setContainerHold("N");
                        System.out.printf("Please start to export the container coded "+code);
                        break;
                    }
                }
                return true;
            }
        }
        System.out.println("Code you input DOES NOT exist in system database.");
        return false;
    }


    public static boolean checkDuplicatedCode( String code, ArrayList<Container> lstContainer){
        for (Container con: lstContainer) {
            if (con.getContainerNumber().equals(code)){
                return true;
            }
        }
        return false;
    }
}
