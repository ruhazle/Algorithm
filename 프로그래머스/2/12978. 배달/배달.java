import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 500001;
            }
        }
        
        for(int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            graph[a][b] = Math.min(graph[a][b], w);
            graph[b][a] = Math.min(graph[b][a], w);
            
        }
        
        
        for(int o = 1; o <= N; o++){
            for(int s = 1; s <= N; s++){
                for(int e = 1; e <= N; e++){
                    if(o == s || s == e) continue;
                    graph[s][e] = 
                        Math.min(graph[s][e], graph[s][o] + graph[o][e]);
                }
            }
        }
        
        for(int i = 0; i < graph[1].length; i++) {
            if(graph[1][i] <= K) answer++;
        }

        return answer;
    }
}