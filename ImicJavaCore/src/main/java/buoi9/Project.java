package buoi9;

import java.util.Date;

public class Project {
    private String id;
    private Date deadline;

    public Project (String id, Date dealine){
        boolean match = id.matches("[A-Z|0-9][A-Z||0-9][A-Z||0-9][A-Z||0-9]");
        if (match) {
            this.setId(id);
        }
        else {System.out.println("Error !!!! Project id must be 4 upcase letters");};
        this.setDeadline(getDeadline());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
