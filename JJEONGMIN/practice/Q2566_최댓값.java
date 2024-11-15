import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2566_최댓값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int h = 1, w = 1, num = 0;
        for(int i=1; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++){
                int cur = Integer.parseInt(st.nextToken());
                if(num < cur) {
                    h = i;
                    w = j;
                    num = cur;
                }
            }
        }
        System.out.println(num);
        System.out.print(h + " " + w);
    }
}
