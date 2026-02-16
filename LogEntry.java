class LogEntry {
    private static int counter = 1;

    private int logId;
    private String accountNumber;
    private ActionType actionType;
    private double amount;
    private long timestamp;
    private Status status;

    public LogEntry(String accountNumber, ActionType actionType,
                    double amount, Status status) {
        this.logId = counter++;
        this.accountNumber = accountNumber;
        this.actionType = actionType;
        this.amount = amount;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public int getLogId() { return logId; }
    public String getAccountNumber() { return accountNumber; }
    public ActionType getActionType() { return actionType; }
    public double getAmount() { return amount; }
    public Status getStatus() { return status; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "LogId=" + logId +
               ", Acc=" + accountNumber +
               ", Action=" + actionType +
               ", Amount=" + amount +
               ", Status=" + status +
               ", Time=" + timestamp;
    }
}