package buoi9;

import java.util.Date;

public class Task {
    private String id;
    private String title;
    private String status;
    private Project relatedProject;
    private Staff assignee;
    private Date deadline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getRelatedProject() {
        return relatedProject;
    }

    public void setRelatedProject(Project relatedProject) {
        this.relatedProject = relatedProject;
    }

    public Staff getAssignee() {
        return assignee;
    }

    public void setAssignee(Staff assignee) {
        this.assignee = assignee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
