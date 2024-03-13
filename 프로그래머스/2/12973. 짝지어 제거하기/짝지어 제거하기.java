import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for(int i = 1 ; i < chars.length; i++) {
            char c = chars[i];
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}