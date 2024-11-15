import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1316_그룹_단어_체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(checker(str)) result++;
        }
        System.out.println(result);
    }
    public static boolean checker(String str){
        Map<Character, Integer> map = new HashMap<>();
        char prev = '0';
        for(char ch : str.toCharArray()){
            if(map.get(ch) != null && ch != prev) {
                return false;
            } else map.put(ch, map.getOrDefault(ch, 0)+1);
            prev = ch;
        }
        return true;
    }
}
