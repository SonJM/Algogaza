import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5086_배수와_약수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;

            if(A % B == 0) sb.append("multiple").append("\n");
            else if(B % A == 0) sb.append("factor").append("\n");
            else sb.append("neither").append("\n");
        }
        System.out.println(sb);
    }
}
