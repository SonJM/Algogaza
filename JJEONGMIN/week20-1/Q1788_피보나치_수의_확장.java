import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1788_피보나치_수의_확장 {
    static int type;
    static int[] dp = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = fibo(N);
        System.out.println(type + "\n" + result);
    }
    public static int fibo(int N){
        return 0;
    }
}
