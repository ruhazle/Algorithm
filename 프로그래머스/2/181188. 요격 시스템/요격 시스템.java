import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        double m = targets[0][1] - 0.5;
        answer++;
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] <= m && m <= targets[i][1]) {
                continue;
            }
            else {
                m = targets[i][1] - 0.5;
                answer++;
            }
        }
        return answer;
    }
}