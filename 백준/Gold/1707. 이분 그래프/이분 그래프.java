import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        //주어진 테스트 케이스만큼 돌림
        for(int t = 0; t < K; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1];
            check = new int[V+1];
            visited = new boolean[V+1];
            isEven = true;

            for(int i = 1; i < V+1; i++) {
                A[i] = new ArrayList<>();
            }

            //에지 데이터 저장
            for(int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            //모든 노드에서 DFS 실행해야함
            for(int i = 1; i <= V; i++) {
                if(isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if(isEven) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    static void DFS(int node) {
        visited[node] = true;
        for(int i : A[node]){
            if(!visited[i]) {
                //바로 직전의 노드와 다른 집합으로 분류해줘야 한다
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else {
                if(check[i] == check[node]){
                    isEven= false;
                }
            }
        }
    }
}
