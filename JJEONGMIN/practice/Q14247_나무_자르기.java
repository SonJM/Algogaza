import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q14247_나무_자르기 {
    public static class Tree {
        int init;
        int level;

        public Tree(int init){
            this.init = init;
            this.level = 0;
        }
        public void updateLevel(int level){
            this.level = level;
        }
    }
    public static class TreeComparator implements Comparator<Tree> {
        @Override
        public int compare(Tree o1, Tree o2) {
            return o1.level - o2.level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Tree[] nodes = new Tree[100001];
        PriorityQueue<Tree> trees = new PriorityQueue<>(new TreeComparator());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            nodes[i] = new Tree(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            nodes[i].updateLevel(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i < N; i++){
            trees.offer(nodes[i]);
        }

        int result = 0;
        int count = 0;
        while(!trees.isEmpty()){
            Tree tree = trees.poll();
            result += (tree.init) + (tree.level * count++);
        }

        System.out.println(result);
    }
}
