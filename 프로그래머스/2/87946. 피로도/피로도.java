class Solution {
    int[][] dungeons;
    boolean[] visit;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.dungeons = dungeons;
        visit = new boolean[dungeons.length];
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0])
                dfs(i, k, 1);
        }
        answer = max;
        return answer;
    }
    
    void dfs (int cur, int tired, int depth) {
        visit[cur] = true;
        tired -= dungeons[cur][1];
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && tired >= dungeons[i][0])
                dfs(i, tired, depth+1);
        }
        max = Math.max(depth, max);
        visit[cur] = false;
    }
}