import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];

        while(true) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(a == -1) break;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++){
                if(i == j) continue;
                if(graph[i][j] == 0) graph[i][j] = 999;
            }
        }

        for(int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (k == s || s == e) continue;
                    graph[s][e] = Math.min(graph[s][e], graph[s][k] + graph[k][e]);
                }
            }
        }

        int minScore = 999;
        for(int[] g : graph) {
            Arrays.sort(g);
            minScore = Math.min(minScore, g[n-1]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(minScore == graph[i][n-1]) list.add(i);
        }

        System.out.println(minScore + " " + list.size());
        for(int x : list)
            System.out.print(x + " ");


    }
}
