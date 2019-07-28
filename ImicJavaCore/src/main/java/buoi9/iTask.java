package buoi9;

import java.util.ArrayList;

public interface iTask {
    public ArrayList<Task> addNewTask (ArrayList<Task> lstTask, ArrayList<Project> lstProject, ArrayList<Staff> lstStaff);
    public void filterTaskByIdStaff (ArrayList<Task> lstTask);
    public void filterOverdueTask(ArrayList<Task> lstTask);
}
