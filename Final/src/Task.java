public class Task {
    private int taskNumber;
    private String dueDate;
    private String taskContent;
    private boolean status;
    public static class Builder {
        private final int taskNumber;
        private final String taskContent;
        private String dueDate = null;
        private boolean status = false;
        public Builder(int taskNumber, String taskContent) {
            this.taskNumber = taskNumber;
            this.taskContent = taskContent;
        }

        public Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder status(boolean status) {
            this.status = status;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
    private Task(Builder builder) {
        this.taskNumber = builder.taskNumber;
        this.dueDate = builder.dueDate;
        this.taskContent = builder.taskContent;
        this.status = builder.status;
    }

    public int getTaskNumber() {
        return taskNumber;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getTaskContent() {
        return taskContent;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    @Override
    public String toString() {
        return "-----TASK "+getTaskNumber()+"-----"+"\n"+
                "Due Date: "+getDueDate()+"\n"+
                "Content: "+getTaskContent()+"\n"+
                "Status: "+getStatus();
    }

}
