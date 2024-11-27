import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q9506_약수들의_합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == -1) break;
            check(N, sb);
        }
        System.out.println(sb);
    }
    public static void check(int num, StringBuilder sb){
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = num/2; i>0; i--){
            if(num % i == 0) {
                list.add(i);
                sum += i;
            }
        }
        if(sum == num) {
            sb.append(num).append(" = ");
            for(int i=list.size()-1; i>=0; i--){
                sb.append(list.get(i));
                if(i != 0) sb.append(" + ");
            }
            sb.append("\n");
        } else sb.append(num).append(" is NOT perfect.\n");
    }
}
