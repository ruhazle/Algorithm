import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++) {
            //무적권 남아있으면 먼저 쓰기
            if(k > 0) {
                q.offer(enemy[i]);
                k--;
            } 
            //무적권 없으면 현재적과 무적권 쓴 제일 적은 적 비교
            else {
                int now = enemy[i];
                if(q.peek() < now) {
                    now = q.poll();
                    q.offer(enemy[i]);
                }
                if(n >= now) {
                    n -= now;
                } else break;
            }
            answer++;
        }
        return answer;
    }
}

