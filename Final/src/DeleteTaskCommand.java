public class DeleteTaskCommand implements TaskCommandInterface {
    private int tasknumber;
    private TaskManager taskManager;

    public DeleteTaskCommand(int tasknumber, TaskManager taskManager) {
        this.tasknumber = tasknumber;
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        for (Task t : taskManager.tasks){
            if (t.getTaskNumber()==tasknumber){
                taskManager.tasks.remove(t);
            }
        }
        taskManager.fileHandler.writeTasksToFile(taskManager.tasks);
    }
}
