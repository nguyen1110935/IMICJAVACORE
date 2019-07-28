package buoi9;

import java.util.ArrayList;

public interface iStaff {
    public ArrayList<Staff> addNewStaff  (ArrayList<Staff> lstStaff, String dataFile);
    public ArrayList<Staff> removeAStaff (ArrayList<Staff> lstStaff, String dataFile);
    public ArrayList<Staff> modifyAStaff (ArrayList<Staff> lstStaff, String dataFile);
    public void             listAllStaff (ArrayList<Staff> lstStaff);
}
