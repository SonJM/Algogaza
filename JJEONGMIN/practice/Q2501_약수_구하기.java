import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2501_약수_구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0, result = 0;
        for(int i = 1; i<=N; i++){
            if(N % i == 0) count++;
            if(count == K) {
                result = i;
                break;
            }
        }
        if(N == 1) System.out.println(1);
        else System.out.println(result);
    }
}
