package buoi9;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static common.CommonFunc.*;

public class Control implements iStaff, iProject, iTask {

    public ArrayList<Staff> addNewStaff (ArrayList<Staff> lstStaff, String dataFile){
        Boolean duplicate =false;
        Scanner scan = new Scanner(System.in);
        Staff staff = new Staff();
        System.out.println("Please type name of new staff");
        staff.setName(scan.nextLine().trim());
        while (true) {
            System.out.println("Please set ID for new staff");
            String id = scan.next().trim();
            if (id.matches("[0-9]{4}")) {
                // Check duplicated staff
                for (Staff stf: lstStaff) {
                    if (id.equals(stf.getId())){
                        System.out.println("This code existed. Please input others");
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    duplicate= false;
                    continue;
                }
                staff.setId(id);
                break;
            }
            else {
                System.out.println("Please input id(MUST be 4 digits) again");
            }
        }
        while(true) {
            System.out.println("Please set gender of the staff(Female/Male/Others)");
            String str = scan.next().trim();
            Boolean match = str.matches("(Female|Male|Others)");
            if (match) {
                staff.setGender(str);
                break;
            }
            else {
                System.out.println("You MUST input Female/Male/Others");
                continue;
            }
        }
        System.out.println("Please set current salary of the staff (Thousand VND)");
        staff.setSalary(scan.nextFloat());
        lstStaff.add(staff);
        //Update data file
        updateStaffDatabase(lstStaff,dataFile);
        return lstStaff;
    }


    public void updateStaffDatabase (ArrayList<Staff> lstStaff, String dataFile){
        String writeStr = "";
        for (Staff stf: lstStaff) {
            if (stf.isDelete() == false) {
                writeStr = writeStr + "///////////////////////////////////\n";
                writeStr = writeStr + "Staff Code  : " + stf.getId() + "\n";
                writeStr = writeStr + "Staff Name  : " + stf.getName() + "\n";
                writeStr = writeStr + "Staff Gender: " + stf.getGender() + "\n";
                writeStr = writeStr + "Staff Salary: " + stf.getSalary() + "\n";
            }
        }
        writeFile(writeStr, dataFile);
    }



    public ArrayList<Staff> loadOldData (String filePatch){
        ArrayList<Staff> lstStaff = new ArrayList<>();
        Staff stf = null;
        String readStr = readFile(filePatch);
        String[] readArr = readStr.split("\n");
        for (int i=0; i< readArr.length;i++) {
            if (readArr[i].contains("Staff Code")){
                String[] line = readArr[i].split(":");
                stf = new Staff();
                stf.setId(line[1].trim());
            }
            else if (readArr[i].contains("Staff Name")){
                String[] line = readArr[i].split(":");
                stf.setName(line[1].trim());
            }
            else if (readArr[i].contains("Staff Gender")){
                String[] line = readArr[i].split(":");
                stf.setGender(line[1].trim());
            }
            else if (readArr[i].contains("Staff Salary")){
                String[] line = readArr[i].split(":");
                stf.setSalary(Float.parseFloat(line[1].trim()));
                lstStaff.add(stf);
            }
        }
        return lstStaff;
    }

    public void listAllStaff (ArrayList<Staff> lstStaff){
        for (Staff stf: lstStaff ) {
            if(stf.isDelete() == false) {
                System.out.println("///////////////////////////////////////////");
                System.out.println("Staff Code  : " + stf.getId());
                System.out.println("Staff Name  : " + stf.getName());
                System.out.println("Staff Gender: " + stf.getGender());
                System.out.println("Staff Salary: " + stf.getSalary());
                System.out.println("///////////////////////////////////////////");
            }
        }
    }

    public ArrayList<Staff> removeAStaff(ArrayList<Staff> lstStaff, String dataFile){
        boolean detect=false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input staff code");
        String code = scan.next().trim();
        for (Staff staff: lstStaff){
            if (code.equals(staff.getId())) {
                staff.setDelete(true);
                detect = true;
            }
        }
        if (detect==false){
            System.out.println("Error !!! This code does not exist in the database");
        }
        //Update data file
        updateStaffDatabase(lstStaff,dataFile);
        return lstStaff;
    }


    public ArrayList<Staff> modifyAStaff(ArrayList<Staff> lstStaff, String dataFile){
        boolean detect=false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input staff code");
        String code = scan.next().trim();
        for (Staff staff: lstStaff){
            if (code.equals(staff.getId())) {
                detect = true;
                while (true) {
                    System.out.println("1. Modify name of a staff");
                    System.out.println("2. Modify gender of a staff");
                    System.out.println("3. Modify salary of a staff");
                    String sel = scan.next().trim();

                    if (sel.equals("1")) {
                        System.out.println("Please input new name of staff");
                        staff.setName(scan.nextLine().trim());
                        break;
                    } else if (sel.equals("2")) {
                        System.out.println("Please input new gender of staff");
                        staff.setGender(scan.next().trim());
                        break;
                    } else if (sel.equals("3")) {
                        System.out.println("Please input new salary of staff");
                        staff.setSalary(scan.nextFloat());
                        break;
                    } else {
                        System.out.println("Error !!! You MUST select one of the option above");
                        continue;
                    }
                }
            }
        }
        if (detect==false){
            System.out.println("Error !!! This code does not exist in the database");
        }
        //Update data file
        updateStaffDatabase(lstStaff,dataFile);
        return lstStaff;
    }

    public ArrayList<Project> addNewProject (ArrayList<Project> lstProject){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input project id");
        String id = scan.next().trim();
        System.out.println("Please input project deadline. Ex: 12/Dec/2019");
        Date deadline = dateInput(scan.next().trim());
        Project proj = new Project(id, deadline );
        lstProject.add(proj);
        return lstProject;
    }

    public ArrayList<Task> addNewTask (ArrayList<Task> lstTask, ArrayList<Project> lstProject, ArrayList<Staff> lstStaff){
        Scanner scan = new Scanner(System.in);
        Task task = new Task();
        System.out.println("Please input task id");
        task.setId(scan.next().trim());
        while (true) {
            System.out.println("Please input task title");
            String tmp = scan.nextLine().trim();
            if (tmp.length() <=3){
                System.out.println("Name of task must be at least 4 letters");
                continue;
            }
            task.setTitle(tmp);
            break;
        }
        System.out.println("Please input task status");
        while (true) {
            String stt = scan.next().trim();
            Boolean match = stt.matches("(hold|finish|processing)");
            if (match) {
                task.setStatus(stt);
                break;
            } else {
                System.out.println("Task status MUST be hold|finish|processing");
                continue;
            }
        }
        System.out.println("Please input project this task belongs to.Please select one of project id below.");
        for (Project proj: lstProject) {
            System.out.println(proj.getId());
        }
        String projId = scan.next().trim();
        for (Project proj: lstProject) {
            if (projId.equals(proj.getId())) {
                System.out.println("Detected project id");
                task.setRelatedProject(proj);
            }
        }

        System.out.println("Please input task assignee (staff id)");
        String stfId = scan.next().trim();
        for (Staff stf : lstStaff) {
            if (stfId.equals(stf.getId())){
                System.out.println("Detected staff Id");
                task.setAssignee(stf);
            }
        }

        System.out.println("Please input task deadline");
        Date deadline = dateInput(scan.next().trim());
        task.setDeadline(deadline);

        lstTask.add(task);
        return  lstTask;
    }

    public void filterTaskByIdStaff (ArrayList<Task> lstTask){
        Scanner scan = new Scanner(System.in);
        int cnt=0;
        System.out.println("Please input staff id");
        String id = scan.next().trim();
        for (Task task: lstTask) {
            if (id.equals(task.getAssignee().getId())){
                System.out.println("Task name: "+task.getTitle());
                cnt++;
            }
        }
        if (cnt >= 3){
            System.out.println("There are too many tasks that you are in charge. Please manage time to complete them by deadline");

        }
    }

    public void filterOverdueTask(ArrayList<Task> lstTask){
        int cnt=0;
        for (Task task: lstTask) {
            if (task.getDeadline().before(new Date())){
                System.out.println("Task Id      : "+task.getId());
                System.out.println("Overdue task : "+task.getTitle());
                System.out.println("Task assignee: "+task.getAssignee().getName());
                cnt++;
            }
        }
        if (cnt == 0){
            System.out.println("There is no overdue task");
        }
    }
}
