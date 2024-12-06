import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10757_큰_수_AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();
        int len = Math.max(lenA, lenB);
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++){
            int numA = 0;
            int numB = 0;
            if(i < lenA) numA = A.charAt(lenA-1-i) - '0';
            if(i < lenB) numB = B.charAt(lenB-1-i) - '0';
            int sum = numA + numB + carry;
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        if(carry > 0) sb.insert(0, carry);
        System.out.println(sb);
    }
}
