import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2581_소수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0, min = Integer.MIN_VALUE;
        for(int i=M; i<=N; i++){
            if(i == 1) continue;
            if(checkMinor(i)){
                sum += i;
                if(min == Integer.MIN_VALUE) min = i;
            }
        }
        if(sum == 0 && min == Integer.MIN_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
    public static boolean checkMinor(int num){
        int sqrt = (int) Math.sqrt(num);
        for(int i=2; i<=sqrt; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
