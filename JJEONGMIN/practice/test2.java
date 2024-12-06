import java.io.*;
import java.util.*;

class test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, List<Integer>> positions = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            positions.putIfAbsent(arr[i], new ArrayList<>());
            positions.get(arr[i]).add(i);
        }

        int count = 0;
        for(List<Integer> posList : positions.values()) {
            if(posList.size() < 2) continue;

            for(int i = 0; i < posList.size() - 1; i++) {
                int start = posList.get(i);
                int end = posList.get(i + 1);
                boolean isValid = true;

                for(int k = start + 1; k < end; k++) {
                    if(arr[k] >= arr[start]) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) count++;
            }
        }
        System.out.println(count);
    }
}

// 입력 예시
//5
//5 2 3 2 5
// 출력 예시
// 1

// 입력 예시
//9
//5 4 3 2 1 2 3 4 5
// 출력 예시
//4

// 입력 예시
//4
//2 2 2 2
// 출력 예시
//3