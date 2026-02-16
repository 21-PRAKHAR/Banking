import java.util.*;

class LogManager {

    private List<LogEntry> allLogs = new ArrayList<>();
    private Map<String, List<LogEntry>> accountMap = new HashMap<>();
    private Deque<LogEntry> recentLogs = new ArrayDeque<>();

    // Feature 1: Add Log
    public void addLog(LogEntry log) {
        allLogs.add(log);
        accountMap
            .computeIfAbsent(log.getAccountNumber(), k -> new ArrayList<>())
            .add(log);

        recentLogs.addLast(log);
        if (recentLogs.size() > 100) { // optional limit
            recentLogs.removeFirst();
        }
    }

    // Feature 2: Get Logs by Account
    public List<LogEntry> getLogsByAccount(String account) {
        return accountMap.getOrDefault(account, Collections.emptyList());
    }

    // Feature 3: Recent N Logs
    public List<LogEntry> getRecentLogs(int n) {
        List<LogEntry> result = new ArrayList<>();
        Iterator<LogEntry> it = recentLogs.descendingIterator();
        while (it.hasNext() && n-- > 0) {
            result.add(it.next());
        }
        return result;
    }

    // Feature 4: Suspicious Activity
    public List<LogEntry> detectSuspicious() {
        List<LogEntry> suspicious = new ArrayList<>();

        for (LogEntry log : allLogs) {
            List<LogEntry> accLogs =
                accountMap.get(log.getAccountNumber());

            if (SuspiciousDetector.isSuspicious(log, accLogs)) {
                suspicious.add(log);
            }
        }
        return suspicious;
    }

    // Feature 5: Search by Action
    public List<LogEntry> searchByAction(ActionType type) {
        List<LogEntry> result = new ArrayList<>();
        for (LogEntry log : allLogs) {
            if (log.getActionType() == type) {
                result.add(log);
            }
        }
        return result;
    }
}