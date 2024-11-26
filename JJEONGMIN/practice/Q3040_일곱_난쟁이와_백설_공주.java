import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q3040_일곱_난쟁이와_백설_공주 {
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    static List<Integer> answer = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        backtracking(new ArrayList<>(), 0);

        answer.forEach(System.out::println);
    }

    public static void backtracking(List<Integer> temp, int start) {
        if(answer != null) return;

        if(temp.size() == 7) {
            int sum = 0;
            for(int i : temp) sum += i;
            if(sum == 100) {
                answer = new ArrayList<>(temp);
            }
            return;
        }

        for(int i = start; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(arr[i]);
                backtracking(temp, i + 1);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}