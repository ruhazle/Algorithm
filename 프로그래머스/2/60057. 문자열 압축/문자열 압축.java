import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length()-1; i++) {
            int pressValue = pressLength(i, s);
            min = Math.min(min, pressValue);
        }
        answer = Math.min(answer, min);
        return answer;
    }
    
    int pressLength(int n, String str) {
        String press = "";
        int count = 1;
        String now = "";
        String prev = "";
        for(int i = n; i <= str.length()-n;) {
            now = str.substring(i, i+n);
            prev = str.substring(i-n, i);
            if(now.equals(prev)) {
                count++;
            } else {
                if(count == 1) {
                    press += prev;
                } else {
                    press += count;
                    press += prev;
                    count = 1;
                }
            }
            i+=n;
        }
        
        if(str.length() / 2 < n) {
            press += str.substring(0, n);
        }
        
        if(count == 1) {
            press += now;
        } else {
            press += count;
            press += now;
        }
        
        if(str.length() % n > 0) {
            press += str.substring(str.length()-str.length() % n, str.length());
        }

        return press.length();
    }
}