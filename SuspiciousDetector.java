import java.util.List;
class SuspiciousDetector {

    public static boolean isSuspicious(LogEntry log,
            List<LogEntry> recentLogsOfAccount) {

        // Rule 1: Withdrawal > 50,000
        if (log.getActionType() == ActionType.WITHDRAW &&
            log.getAmount() > 50000) {
            return true;
        }

        // Rule 2: More than 3 FAILED_LOGIN in last 5 logs
        int failedCount = 0;
        for (int i = recentLogsOfAccount.size() - 1;
             i >= 0 && failedCount <= 3 && 
             recentLogsOfAccount.size() - i <= 5;
             i--) {

            if (recentLogsOfAccount.get(i).getActionType() ==
                ActionType.FAILED_LOGIN) {
                failedCount++;
            }
        }
        return failedCount > 3;
    }
}
