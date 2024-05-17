import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_15652 {
    static int[] temp;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        temp = new int[m];

        func(1, 0);
        System.out.println(sb);
    }

    static void func(int start, int depth) throws IOException {
        if(depth == m) {
            for(int a : temp) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            temp[depth] = i;
            func(i,depth + 1);
        }
    }
}
