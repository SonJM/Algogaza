import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978_소수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int j : arr) {
            if (find(j)) result++;
        }
        System.out.println(result);
    }
    public static boolean find(int num){
        if(num == 1) return false;
        int sqrt = (int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
