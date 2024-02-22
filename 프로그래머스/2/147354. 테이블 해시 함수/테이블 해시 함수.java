import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);
        answer = colSum(data[row_begin-1], row_begin);
        for(int i = row_begin; i < row_end; i++) {
            answer = answer ^ colSum(data[i], i+1);
        }
        return answer;
    }
    
    int colSum(int[] tuple, int n) {
        int sum = 0;
        for(int i = 0; i < tuple.length; i++) {
            sum += tuple[i] % n;
        }
        
        return sum;
    }
}