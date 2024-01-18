import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static boolean[] visitied;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        graph = new ArrayList[N];
        visitied = new boolean[N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt((s[1]));
            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i = 0; i < graph.length; i++) {
            visitied[i] = true;
            DFS(1, i);
            if(answer == 1) break;
            visitied[i] = false;
        }

        System.out.println(answer);
    }

    static void DFS(int L, int node) {
        if(L == 5) {
            answer = 1;
        }
        else {
            for(int i = 0; i < graph[node].size(); i++) {
                int next = graph[node].get(i);
                if(!visitied[next]) {
                    visitied[next] = true;
                    DFS(L + 1, next);
                    visitied[next] = false;
                }
            }
        }
    }
}
