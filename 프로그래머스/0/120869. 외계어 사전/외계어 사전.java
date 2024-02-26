import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(int i = 0; i < dic.length; i++) {
            if(dic[i].length() != spell.length)
                continue;
            else {
                if(check(dic[i], spell)){
                    answer = 1;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    boolean check(String s, String[] spell) {
        for(int i = 0; i < spell.length; i++) {
            if(s.contains(spell[i])) continue;
            else return false;
        }
        
        return true;
    }
}