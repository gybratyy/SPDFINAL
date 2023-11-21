import java.util.Scanner;
public class ModifyTaskCommand implements TaskCommandInterface {
    private int tasknumber;
    private TaskManager taskManager;

    public ModifyTaskCommand(int tasknumber, TaskManager taskManager) {
        this.tasknumber = tasknumber;
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter updated task content:");
        String newContent = s.nextLine();
        for (Task t : taskManager.tasks){
            if (t.getTaskNumber()==tasknumber){
                t.setTaskContent(newContent);
            }
        }
        taskManager.fileHandler.writeTasksToFile(taskManager.tasks);
    }
}
