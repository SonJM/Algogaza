import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11653_소인수분해 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= N; i++) {
            while(N % i == 0) {
                list.add(i);
                N /= i;
            }
        }
        list.forEach(System.out::println);
    }
}
