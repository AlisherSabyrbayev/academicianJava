package ToDo;

public class Task {
    public final static int HIGH = 3;
    public final static int MEDIUM = 2;
    public final static int LOW = 1;

    public final static String COMPLETED = "Completed";
    public final static String IN_PROGRESS = "In Progress";
    public final static String NEW = "New";

    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return taskName.concat(" ").concat((priority+"")).concat(" ").concat(status);
    }
}
