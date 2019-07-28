package buoi9;

import java.util.ArrayList;
import java.util.Scanner;

import static buoi9.Control.*;
import static common.CommonFunc.*;

// Version 1.0
public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Staff>   lstStaff     = new ArrayList<>();
        ArrayList<Project> lstProject   = new ArrayList<>();
        ArrayList<Task>    lstTask      = new ArrayList<>();
        Control ctrl = new Control();
        lstStaff = ctrl.loadOldData("C:\\Users\\Nguyen\\Desktop\\staffData.txt");
        ctrl.listAllStaff(lstStaff);
        while (true) {
            System.out.println("\nPlease sellect one of the function below.");
            System.out.println("0. Add new staff");
            System.out.println("1. Remove a staff");
            System.out.println("2. Modify infomation of a staff");
            System.out.println("3. List all staff");
            System.out.println("4. Add new project");
            System.out.println("5. Add new task");
            System.out.println("6. List all tasks of a staff");
            System.out.println("7. List all overdue tasks");
            System.out.println("8. Exit this program");
            String funcSellect = scan.next();

            switch (funcSellect) {
                case "0":
                    lstStaff   = ctrl.addNewStaff(lstStaff, "C:\\Users\\Nguyen\\Desktop\\staffData.txt");
                    break;
                case "1":
                    lstStaff   = ctrl.removeAStaff(lstStaff, "C:\\Users\\Nguyen\\Desktop\\staffData.txt");
                    break;
                case "2":
                    lstStaff   = ctrl.modifyAStaff(lstStaff, "C:\\Users\\Nguyen\\Desktop\\staffData.txt");
                    break;
                case "3":
                    ctrl.listAllStaff(lstStaff);
                    break;
                case "4":
                    lstProject = ctrl.addNewProject(lstProject);
                    break;
                case "5":
                    if (lstProject.size() == 0 | lstStaff.size() == 0){
                        System.out.println("Please add both new project and new staff first.");
                        break;
                    }
                    lstTask    = ctrl.addNewTask(lstTask, lstProject, lstStaff);
                    break;
                case "6":
                    ctrl.filterTaskByIdStaff (lstTask);
                    break;
                case "7":
                    ctrl.filterOverdueTask (lstTask);
                    break;
                case "8":
                    System.exit(1);
                default:
                    System.out.println("Your sellection is not valid");
            }
        }

    }
}
