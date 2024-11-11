import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14728_벼락치기 {
    private static class Problem {
        int time;
        int score;
        Problem(int time, int score){
            this.time = time;
            this.score = score;
        }
    }
    private static int N, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Problem[] problems = new Problem[N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(time, score);
        }

        int[][] dp = new int[N + 1][T + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= T; j++) {
                if(problems[i].time <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - problems[i].time] + problems[i].score);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][T]);
    }
}
