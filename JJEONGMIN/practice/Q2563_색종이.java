import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2563_색종이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = new int[101][101];
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            fill(map, w, h);
        }
        int count = 0;
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(map[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }
    public static void fill(int[][] map, int w, int h){
        for(int i=w; i<w+10; i++){
            for(int j=h; j<h+10; j++){
                map[i][j] = 1;
            }
        }
    }
}
