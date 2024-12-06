import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609_최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = getGCD(A, B);
        int lcm = A * B / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
    public static int getGCD(int A, int B){
        if(B == 0) return A;
        return getGCD(B, A % B);
    }
}
