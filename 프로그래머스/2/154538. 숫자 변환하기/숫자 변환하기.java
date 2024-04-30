import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Target> q = new LinkedList<>();
        q.offer(new Target(y, 0));
        while(!q.isEmpty()){
            Target now = q.poll();
            if(now.num == x) {
                answer = now.count;
                break;
            }
            if(now.num % 2 == 0) q.offer(new Target(now.num / 2, now.count+1));
            if(now.num % 3 == 0) q.offer(new Target(now.num / 3, now.count+1));;
            if(now.num - n > 0) q.offer(new Target(now.num - n, now.count+1));;
        }
        
        return answer;
    }
}

class Target {
    int num;
    int count;
    
    Target(int num, int count) {
        this.num = num;
        this.count = count;
    }
}