import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2903_중앙_이동_알고리즘 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 4;
        for(int i=0; i<N; i++){
            int sqrt = (int) Math.sqrt(result);
            result = (int) Math.pow(sqrt + (sqrt-1), 2);
        }
        System.out.println(result);
    }
}
