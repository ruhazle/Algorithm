import java.util.*;

class Solution {
    String[] words = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        for(int i = 0; i < words.length; i++) {
            DFS(words[i]);
        }
        
        answer = list.indexOf(word) + 1;
        
        return answer;
    }
    
    void DFS(String cur) {
        if(cur.length() > 5) return;
        if(!list.contains(cur)) list.add(cur);
        for(int i = 0; i < words.length; i++) {
            DFS(cur+words[i]);
        }
    }
}