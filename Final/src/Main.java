public class Main {
    public static void main(String[] args) {
        TaskObserverInterface emailObserver = new EmailNotificationObserver();
        TaskObserverInterface smsObserver = new SMSNotificationObserver();

        NotificationChain notificationChain = new NotificationChain(emailObserver);
        NotificationChain smsNotificationChain = new NotificationChain(smsObserver);

        TaskManager manager = new TaskManager();

        notificationChain.setNextChain(smsNotificationChain);
        manager.registerObserverChain(notificationChain);

        Task task1 = new Task.Builder(1,"Content: finish your final assignment")
                .dueDate("2023.22.11 11:59PM")
                .status(false)
                .build();
        manager.addTask(task1);
        manager.notifyObservers(task1);

        manager.displayTasks();

        Task task2 = new Task.Builder(2,"Content: go get some sleep")
                .dueDate("2023.22.12 00:59AM")
                .build();
        manager.addTask(task2);
        manager.notifyObservers(task2);

        manager.displayTasks();

        manager.modifyTask(1);

        manager.displayTasks();
        manager.markTaskAsDone(2);
        manager.displayTasks();









    }


}
