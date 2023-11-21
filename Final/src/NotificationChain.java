public class NotificationChain {
    private TaskObserverInterface handler;
    private NotificationChain nextChain;

    public NotificationChain(TaskObserverInterface handler) {
        this.handler = handler;
    }

    public void setNextChain(NotificationChain nextChain) {
        this.nextChain = nextChain;
    }

    public void notifyObserver(Task task) {
        if (handler != null) {
            handler.update(task);
        }

        if (nextChain != null) {
            nextChain.notifyObserver(task);
        }
    }
}
