import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] workDay = new int[progresses.length];
        int day = 1;
        for(int i = 0; i < progresses.length; i++) {
            int temp = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] == 0)
                workDay[i] = temp;
            else workDay[i] = temp + 1;
        }
        
        int nowWork = workDay[0];
        int count = 0;
        for(int i = 0; i < workDay.length; i++) {
            if(nowWork >= workDay[i]){
                count++;
            } else {
                answer.add(count);
                count = 0;
                nowWork = workDay[i];
                count++;
            }
        }
        
        answer.add(count);
        
        return answer;
    }
}