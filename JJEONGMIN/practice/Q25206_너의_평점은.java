import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q25206_너의_평점은 {
    static Map<String, Float> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        initial();
        double sum = 0;
        int gradeTotal = 0;
        for(int i=0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            Float grade = Float.parseFloat(st.nextToken());
            String rating = st.nextToken();

            if(rating.equals("P")) continue;
            sum += (grade * map.get(rating));
            gradeTotal += grade;
        }
        System.out.printf("%.6f", sum / gradeTotal);
    }
    public static void initial(){
        map.put("A+", 4.5F);
        map.put("A0", 4.0F);
        map.put("B+", 3.5F);
        map.put("B0", 3.0F);
        map.put("C+", 2.5F);
        map.put("C0", 2.0F);
        map.put("D+", 1.5F);
        map.put("D0", 1.0F);
        map.put("F", 0.0F);
    }
}
