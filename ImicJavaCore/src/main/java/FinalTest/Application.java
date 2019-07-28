package FinalTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scan             = new Scanner(System.in);
        ArrayList<Container> lst = new ArrayList<>();
        while (true) {
            System.out.println("Please select one of the function below");
            System.out.println("1. Add new container");
            System.out.println("2. Display all containers on console");
            System.out.println("3. Look for a container by container number");
            System.out.println("4. Detach data file");
            System.out.println("5. Exit program");
            String sel =scan.nextLine();
            lst = readFileObj("myObjects.txt");
            switch (sel) {
                case "1":
                    lst = addNewContainer(lst);
                    break;
                case "2":
                    displayAllContainers(lst);
                    break;
                case "3":
                    lookForAContainer(lst);
                    break;
                case "4":
                    detachDataFile(lst);
                    break;
                case "5":
                    System.exit(1);
                default:
                    System.out.println("Please select a valid number");
            }
        }


    }
    public static void detachDataFile(ArrayList<Container> lst){
        ArrayList<Container> availableContainerLst = new ArrayList<>();
        ArrayList<Container> emptyContainerLst     = new ArrayList<>();

        for (Container con: lst ) {
            if (con.isContainerStatus()){
                emptyContainerLst.add(con);
            }
            else {
                availableContainerLst.add(con);
            }
        }
        writeFileObj(availableContainerLst, "myObjects_availableContainerLst.txt");
        writeFileObj(emptyContainerLst, "myObjects.txt");
    }
    public static boolean lookForAContainer (ArrayList<Container> lst){
        Scanner scan             = new Scanner(System.in);
        System.out.println("Please input container number");
        String containerNu = scan.nextLine();

        for (Container con:lst) {
            if (con.getContainerNumber().equals(containerNu)){
                System.out.println("Dected the container you input");
                System.out.println(con.showContainer());
                return true;
            }
        }
        return false;
    }

    public static void displayAllContainers (ArrayList<Container> lst){
        System.out.println("All containers are listed below");
        for (Container con: lst) {
            System.out.println("/////////////////////////////////////");
            System.out.println(con.showContainer());
        }
    }

    public static ArrayList<Container> addNewContainer (ArrayList<Container> lst){
        String containerNumber= "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input container number");
        while (true) {
            containerNumber = scan.nextLine();
            if (checkDuplicate (containerNumber, lst)){
                System.out.println("Your numer is duplicated. Please input new number");
                continue;
            }
            else break;
        }
        System.out.println("Please input container height");
        float       containerHeight = scan.nextFloat();
        System.out.println("Please input container width");
        float       containerWidth=scan.nextFloat();
        System.out.println("Is this container empty? 1.Yes or <anyother>. No");
        boolean     containerStatus = (scan.next().equals("1")?  true:false);
        Container p1 = new Container(containerNumber, containerHeight, containerWidth, containerStatus);
        lst.add(p1);
        writeFileObj(lst, "myObjects.txt");
        return lst;
    }

    public static boolean checkDuplicate(String containerNumber, ArrayList<Container> lst){
        //TODO
        for (Container con: lst ) {
            if (con.getContainerNumber().equals(containerNumber)){
                return true;
            }
        }
        return false;
    }

    public static void writeFileObj (ArrayList<Container> lst, String path) {

        try {
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(lst);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
    }

    public static ArrayList<Container> readFileObj (String path) {
        ArrayList<Container> lst = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            lst = (ArrayList<Container>) oi.readObject();

            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            File file = new File(path);
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lst;
    }
}
