import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt((s[1]));
            graph[start].add(end);
            graph[end].add(start);
        }

        Set<Integer> friends = new HashSet<>();
        for(int i = 0; i < graph[1].size(); i++){
            int node = graph[1].get(i);
            friends.add(node);
            for(int j = 0; j < graph[node].size(); j++) {
                friends.add(graph[node].get(j));
            }
        }

        friends.remove(1);
        System.out.println(friends.size());
    }
}
