import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28702_FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        arr[0] = br.readLine();
        arr[1] = br.readLine();
        arr[2] = br.readLine();

        int num = 0;
        for(int i=0; i<3; i++){
            if(arr[i].charAt(0) != 'F' && arr[i].charAt(0) != 'B'){
                num = (3-i) + Integer.parseInt(arr[i]);
            }
        }

        String result = null;
        if(num % 3 == 0 && num % 5 == 0) result = "FizzBuzz";
        else if(num % 3 == 0) result = "Fizz";
        else if(num % 5 == 0) result = "Buzz";
        else result = String.valueOf(num);

        System.out.println(result);
    }
}
