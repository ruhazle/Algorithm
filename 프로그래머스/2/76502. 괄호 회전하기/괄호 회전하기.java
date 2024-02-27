import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(check(s)){
                answer ++;
            }
            String r = s.substring(0,1);
            s = s.substring(1, s.length()) + r;
        
        }
        return answer;
    }
    
    boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    if(s.charAt(i) == ')') {
                        if(stack.peek() == '(')
                            stack.pop();
                        else return false;
                    }
                    if(s.charAt(i) == '}') {
                        if(stack.peek() == '{')
                            stack.pop();
                        else return false;
                    }
                    if(s.charAt(i) == ']') {
                        if(stack.peek() == '[')
                            stack.pop();
                        else return false;
                    }
                }
            }
        }
        
        if(!stack.isEmpty()) return false;
        return true;
    }
}