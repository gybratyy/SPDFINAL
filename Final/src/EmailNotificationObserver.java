public class EmailNotificationObserver implements TaskObserverInterface {
    @Override
    public void update(Task task) {
        System.out.println("email notification for task: " + task.getTaskNumber()+ "task created successfully");
    }
}
