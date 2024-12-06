import java.io.*;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class test3 {
    static class Log {
        String time;
        String level;
        String message;

        public Log(String time, String level, String message) {
            this.time = time;
            this.level = level;
            this.message = message;
        }
    }
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] timeInfo = br.readLine().split(" ");
        String startTime = timeInfo[0];
        String endTime = timeInfo[1];
        String keyword = timeInfo[2].toLowerCase();

        int N = Integer.parseInt(br.readLine());

        Map<String, List<Log>> levelMap = new LinkedHashMap<>();
        levelMap.put("[INFO]", new ArrayList<>());
        levelMap.put("[WARN]", new ArrayList<>());
        levelMap.put("[ERROR]", new ArrayList<>());

        for (int i = 0; i < N; i++) {
            String[] logInfo = br.readLine().split(" ", 3);
            Log log = new Log(logInfo[0], logInfo[1], logInfo[2]);
            if (log.message.toLowerCase().contains(keyword)) {
                levelMap.get(log.level).add(log);
            }
        }

        boolean hasAnyLogs = false;

        for (String level : levelMap.keySet()) {
            List<Log> logs = levelMap.get(level);
            List<Log> filteredLogs = new ArrayList<>();

            for (Log log : logs) {
                if (isWithinTimeRange(log.time, startTime, endTime)) {
                    filteredLogs.add(log);
                }
            }

            if (!filteredLogs.isEmpty()) {
                hasAnyLogs = true;
                System.out.println(level + ":");

                int i = 0;
                while (i < filteredLogs.size()) {
                    Log currentLog = filteredLogs.get(i);
                    int count = 1;
                    int j = i + 1;

                    while (j < filteredLogs.size() &&
                            filteredLogs.get(j).message.equals(currentLog.message) &&
                            j == i + count) {
                        count++;
                        j++;
                    }

                    if (count > 1) {
                        System.out.println("- " + currentLog.time + " " + currentLog.message + " (x" + count + ")");
                        i += count;
                    } else {
                        System.out.println("- " + currentLog.time + " " + currentLog.message);
                        i++;
                    }
                }
                System.out.println();
            }
        }
        if (!hasAnyLogs) {
            System.out.println("No logs found.");
        }
    }

    static boolean isWithinTimeRange(String currentTime, String startTime, String endTime) {
        LocalTime current = LocalTime.parse(currentTime, timeFormatter);
        LocalTime start = LocalTime.parse(startTime, timeFormatter);
        LocalTime end = LocalTime.parse(endTime, timeFormatter);

        if (start.compareTo(end) <= 0) {
            return !current.isBefore(start) && !current.isAfter(end);
        } else {
            return !current.isBefore(start) || !current.isAfter(end);
        }
    }
}

// 입력 예시
//14:00:00 15:00:00 Database
//12
//13:59:58 [INFO] System ready
//14:00:01 [INFO] System started
//14:00:48 [INFO] Database started
//14:15:00 [WARN] Network delay in the database
//14:15:30 [ERROR] Database connection failed
//14:20:45 [ERROR] Database connection failed
//14:20:49 [ERROR] Database connection failed
//14:30:00 [WARN] High memory usage
//14:45:00 [ERROR] Database timeout
//14:59:59 [ERROR] Database connection failed
//15:00:00 [WARN] Database connection pool is almost full.
//15:00:02 [WARN] Database connection pool is almost full.

// 출력 예시
//[INFO]:
//- 14:00:48 Database started
//
//[WARN]:
//- 14:15:00 Network delay in the database
//- 15:00:00 Database connection pool is almost full.
//
//[ERROR]:
//- 14:15:30 Database connection failed (x3)
//- 14:45:00 Database timeout
//- 14:59:59 Database connection failed