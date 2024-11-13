import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if(command.equals("push")) num = Integer.parseInt(st.nextToken());
            execute(command, num, queue, sb);
        }
        System.out.println(sb);
    }
    public static void execute(String command, int num, Queue<Integer> queue, StringBuilder sb){
        switch (command){
            case "push" -> queue.offer(num);
            case "pop" -> sb.append(queue.poll());
            case "size" -> sb.append(queue.size()).append("\n");
            case "empty" -> {
                if(queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            case "front" -> {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            }
            case "back" -> {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else {
                    for(int i=0; i<queue.size(); i++){
                        int tmp = queue.poll();
                        queue.offer(tmp);
                        if(i == queue.size()) sb.append(tmp).append("\n");
                    }
                }
            }
        }
    }
}
