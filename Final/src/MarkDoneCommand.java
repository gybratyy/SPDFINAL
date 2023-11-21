public class MarkDoneCommand implements TaskCommandInterface {
    private int tasknumber;
    private TaskManager taskManager;

    public MarkDoneCommand(int tasknumber, TaskManager taskManager) {
        this.tasknumber = tasknumber;
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        for (Task t : taskManager.tasks){
            if (t.getTaskNumber()==tasknumber){
                t.setStatus(true);
            }
        }
        taskManager.fileHandler.writeTasksToFile(taskManager.tasks);
    }
}
