class Solution {
    static int[] board;
    static int answer;
    public int solution(int n) {
        answer = 0;
        board = new int[n];
        DFS(0, n);
        return answer;
    }
    
    static void DFS(int r, int n) {
        if(r == n)
            answer++;
        else {
            for(int i = 0; i < n; i++) {
                board[r] = i;
                if(check(r))
                    DFS(r+1, n);
            }
        }
    }
    
    static boolean check(int r) {
        for(int i = 0; i < r; i++) {
            if(board[i] == board[r] 
               || Math.abs(i - r) == Math.abs(board[i] - board[r]))
               return false;
        }
        return true;
    }
}