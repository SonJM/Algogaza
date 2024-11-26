import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2720_세탁소_사장_동혁 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int q = money / 25;
            money %= 25;
            int d = money / 10;
            money %= 10;
            int n = money / 5;
            money %= 5;
            int p = money;
            sb.append(q + " " + d + " " + n + " " + p + "\n");
        }
        System.out.println(sb);
    }
}
