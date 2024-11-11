import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q14247_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            result += Integer.parseInt(st.nextToken());
        }

        int[] level = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            level[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(level);
        for(int i=0; i < N; i++){
            result += (long)level[i] * i;
        }
        System.out.println(result);
    }
}
