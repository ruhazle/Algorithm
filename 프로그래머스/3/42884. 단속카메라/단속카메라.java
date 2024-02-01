import java.util.*;

class Solution {
    public int solution(int[][] routes) {
       int answer = 0;
        int count = 0;
        
        Arrays.sort(routes, (r1, r2) -> r1[0] == r2[0] ? r1[1] - r2[1] : r1[0] - r2[0]);

        int camera = routes[0][1];
        count++;
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= camera && camera <= routes[i][1])
                continue;
            else {
                camera = routes[i][1];
                count++;
            }
        }

        answer = count;
        count = 0;
        Arrays.sort(routes, (r1, r2) -> r1[0] == r2[0] ? r2[1] - r1[1] : r2[0] - r1[0]);
        camera = routes[0][0];
        count++;
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= camera && camera <= routes[i][1])
                continue;
            else {
                camera = routes[i][0];
                count++;
            }
        }
        return Math.min(answer, count);
    }
}