class Solution {
    public int solution(int[][] board) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int answer = 0;
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    for(int k = 0; k < 8; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length)
                            if(board[nx][ny] == 0)
                                board[nx][ny] = 2;
                    }
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}