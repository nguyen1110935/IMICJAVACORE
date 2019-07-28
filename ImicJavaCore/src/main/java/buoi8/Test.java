package buoi8;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import static buoi8.Control.*;
import static common.CommonFunc.*;

public class Test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Container> lstContainerOk     = new ArrayList<>();
        ArrayList<Container> lstContainerBroken = new ArrayList<>();
        ArrayList<Container> lstContainerFrozen = new ArrayList<>();
        ArrayList<Container> lstContainerNormal = new ArrayList<>();
        ArrayList<Container> allContainers      = new ArrayList<>();

        while (true) {
            System.out.println("\nPlease sellect one of the function below.");
            System.out.println("0. Add new containers");
            System.out.println("1. List all Frozen containers and others");
            System.out.println("2. List all broken containers and others.");
            System.out.println("3. Conduct exporting the container away from Cat Lai port.");
            System.out.println("4. Exit this program");
            int funcSellect = scan.nextInt();
            switch (funcSellect) {
                case 0:
                    // Add new containers
                    System.out.println("Please input number of containers to store: ");
                    int numOfContainer = scan.nextInt();
                    allContainers.addAll(addNewContainer (numOfContainer));
                    // Remove to get new lists.
                    lstContainerOk.removeAll(lstContainerOk);
                    lstContainerBroken.removeAll(lstContainerBroken);
                    lstContainerFrozen.removeAll(lstContainerFrozen);
                    lstContainerNormal.removeAll(lstContainerNormal);
                    for (Container con : allContainers ) {
                        //Separate list based on status
                        if (con.isContainerStatus()) {
                            lstContainerOk.add(con);
                        } else {
                            lstContainerBroken.add(con);
                        }

                        //Separate list based on container type
                        if (con.getContainerType().toLowerCase().equals("frozen")){
                            lstContainerFrozen.add(con);
                        }
                        else {lstContainerNormal.add(con);}
                    }
                    break;
                case 1:
                    //Start to print all OK container information
                    System.out.println("Start to print all frozen containers information");
                    printAllContainerInfo(lstContainerFrozen);
                    System.out.println("Start to print all other containers information");
                    printAllContainerInfo(lstContainerNormal);
                    break;

                case 2:
                    //Start to print all OK container information
                    System.out.println("Start to print all OK containers information");
                    printAllContainerInfo(lstContainerOk);
                    System.out.println("Start to print all Broken containers information");
                    printAllContainerInfo(lstContainerBroken);
                    break;
                case 3:
                    //Conduct exporting the container away from Cat Lai port.

                    System.out.println("Start the procedure of export.");
                    System.out.println("Please input code of container: ");
                    String code = scan.next();
                    boolean endProcedure = exportContainer(code, allContainers);
                    while (endProcedure == false) {
                        System.out.println("1. Input code of container again.");
                        System.out.println("2. Exit the program.");
                        String sel = scan.next();
                        if (sel.equals("1")) {
                            System.out.println("Please input code again.");
                            code = scan.next();
                            endProcedure = exportContainer(code, allContainers);
                        }
                        else {
                            System.exit(1);
                        }
                    }
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("Your sellection is not valid");
            }
        }
    }
}
