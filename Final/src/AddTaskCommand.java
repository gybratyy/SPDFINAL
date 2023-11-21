public class AddTaskCommand implements TaskCommandInterface {
    private Task task;
    private TaskManager taskManager;

    public AddTaskCommand(Task task, TaskManager taskManager) {
        this.task = task;
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        taskManager.tasks.add(task);
        taskManager.fileHandler.writeTasksToFile(taskManager.tasks);
    }
}
