import java.io.*;
import java.util.*;
class test1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        Map<Character, Character> finalMap = new HashMap<>();
        for(char key : map.keySet()) {
            if(!finalMap.containsKey(key)) {
                char finalValue = getFinalValue(key, map, new HashSet<>(), new ArrayList<>());
                if(finalValue == '?') {
                    for(char cycle : getCyclePath(key, map))
                        finalMap.put(cycle, '?');
                } else {
                    finalMap.put(key, finalValue);
                }
            }
        }

        for(char c : str.toCharArray()) {
            if(finalMap.containsKey(c)) {
                sb.append(finalMap.get(c));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    private static char getFinalValue(char key, Map<Character, Character> map, Set<Character> visited, List<Character> path) {
        if(visited.contains(key)) {
            return '?';
        }
        if(!map.containsKey(key)) {
            return key;
        }

        visited.add(key);
        path.add(key);
        char nextValue = map.get(key);
        char finalValue = getFinalValue(nextValue, map, visited, path);

        return finalValue;
    }

    private static List<Character> getCyclePath(char start, Map<Character, Character> map) {
        List<Character> cycle = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        char current = start;

        while(!visited.contains(current)) {
            visited.add(current);
            cycle.add(current);
            if(!map.containsKey(current)) break;
            current = map.get(current);
        }

        int cycleStart = cycle.indexOf(current);
        return cycle.subList(cycleStart, cycle.size());
    }
}

// 입력 예시
//xpyyaq pcbuXt
//9
//x H
//a o
//p e
//y z
//z l
//q r
//r q
//b o
//X n

// 출력 예시
//Hello? ecount