import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1212_8진수_2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        if (num.equals("0")) {
            System.out.println("0");
            return;
        }

        StringBuilder result = new StringBuilder();

        String first = toBinary(num.charAt(0) - '0');
        result.append(Integer.parseInt(first));

        for (int i = 1; i < num.length(); i++) {
            String binary = toBinary(num.charAt(i) - '0');
            while (binary.length() < 3) {
                binary = "0" + binary;
            }
            result.append(binary);
        }

        System.out.println(result);
    }

    public static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }
}
