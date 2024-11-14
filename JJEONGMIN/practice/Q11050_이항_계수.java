import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11050_이항_계수 {
    static int[][] dp = new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        binom(n, k);
        System.out.println(dp[n][k]);
    }
    public static int binom(int n, int k){
        if(n == k | k == 0) return dp[n][k] = 1;
        if(dp[n][k] > 0) return dp[n][k];
        return dp[n][k] = binom(n-1, k) + binom(n-1, k-1);
    }
}
