import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[][] len  = new int[numlist.length][2];
        
        for(int i = 0; i < numlist.length; i++) {
            len[i][0] = numlist[i];
            len[i][1] = Math.abs(numlist[i] - n);
        }
        
        Arrays.sort(len, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        
        for(int i = 0; i < len.length; i++) {
            answer[i] = len[i][0];
        }
        
        return answer;
    }
}