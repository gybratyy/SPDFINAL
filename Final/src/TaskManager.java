import java.util.ArrayList;
public class TaskManager {
    private NotificationChain observerChain;
TaskFileHandler fileHandler = new TaskFileHandler("src/tasks.json");
    ArrayList<Task> tasks = new ArrayList<>();
public  TaskManager(){
    this.tasks = (ArrayList<Task>) fileHandler.readTasksFromFile();
}

     public void addTask(Task task) {
        TaskCommandInterface command = new AddTaskCommand(task, this);
         command.execute();
     }
     public void deleteTask(int tasknumber) {
        TaskCommandInterface command = new DeleteTaskCommand(tasknumber, this);
        command.execute();
    }
    public void markTaskAsDone(int tasknumber) {
        TaskCommandInterface command = new MarkDoneCommand(tasknumber, this);
        command.execute();
    }
    public void modifyTask(int tasknumber) {
        TaskCommandInterface command = new ModifyTaskCommand(tasknumber, this);
        command.execute();
    }

    public void registerObserverChain(NotificationChain observerChain) {
        this.observerChain = observerChain;
    }
    public void notifyObservers(Task task) {
        if (observerChain != null) {
            observerChain.notifyObserver(task);
        }
    }
    public void displayTasks(){
    for(Task t : this.tasks){
        t.toString();
    }
    }
}
