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

        Queue<qItem> Q = new LinkedList<>();
        Q.add(new qItem(1, 1));
        visited[1] = true;

        while(!Q.isEmpty()){
            qItem now = Q.poll();

            if(now.depth == 2 || now.depth == 3) {
                answer.add(now.node);
            }

            for(int i = 0; i < graph[now.node].size(); i++){
                int next = graph[now.node].get(i);
                if(!visited[next]) {
                    Q.add(new qItem(next, now.depth+1));
                    visited[next] = true;
                }
            }
        }

        System.out.println(answer.size());

    }
}

class qItem {
    int node;
    int depth;

    qItem(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}