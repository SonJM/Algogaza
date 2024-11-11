import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q12893_적의_적 {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        boolean possible = true;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, 1)) {
                    possible = false;
                    break;
                }
            }
        }

        System.out.println(possible ? 1 : 0);
    }

    static boolean dfs(int v, int group) {
        visited[v] = group;

        for (int next : graph[v]) {
            if (visited[next] == 0) {
                if (!dfs(next, 3 - group)) {
                    return false;
                }
            } else if (visited[next] == group) {
                return false;
            }
        }
        return true;
    }
}