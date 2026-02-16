import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LogManager manager = new LogManager();

        while (true) {
            System.out.println("\n1.Add Log  2.Get Logs by Account  3.Recent Logs");
            System.out.println("4.Suspicious Logs  5.Search by Action  6.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Account: ");
                    String acc = sc.next();

                    System.out.print("Action(DEPOSIT/WITHDRAW/TRANSFER/LOGIN/FAILED_LOGIN): ");
                    ActionType action = ActionType.valueOf(sc.next());

                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    System.out.print("Status(SUCCESS/FAILED): ");
                    Status status = Status.valueOf(sc.next());

                    manager.addLog(new LogEntry(acc, action, amt, status));
                    break;

                case 2:
                    System.out.print("Account: ");
                    System.out.println(manager.getLogsByAccount(sc.next()));
                    break;

                case 3:
                    System.out.print("N: ");
                    System.out.println(manager.getRecentLogs(sc.nextInt()));
                    break;

                case 4:
                    System.out.println(manager.detectSuspicious());
                    break;

                case 5:
                    System.out.print("Action: ");
                    System.out.println(
                        manager.searchByAction(ActionType.valueOf(sc.next()))
                    );
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}