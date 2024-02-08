import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        int count = 600000;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        
        for(int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            if(sum1 > sum2) {
                int a = q1.poll();
                sum1 -= a;
                sum2 += a;
                q2.offer(a);
                answer++;
            }
            
            if(sum2 > sum1) {
                int b = q2.poll();
                sum2 -= b;
                sum1 += b;
                q1.offer(b);
                answer++;
            }
            
            if(sum1 == sum2)
                break;
            
            if(answer > count)
                break;
        }
        

        if(q1.isEmpty() || q2.isEmpty()) {
            answer = -1;
        }
        
        if(answer > count)
            answer = -1;
        
        return answer;
    }
}