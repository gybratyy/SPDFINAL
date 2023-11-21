public class SMSNotificationObserver implements TaskObserverInterface {
    @Override
    public void update(Task task) {
        System.out.println("SMS notification for task: " + task.getTaskNumber()+ "task created successfully");
    }
}
