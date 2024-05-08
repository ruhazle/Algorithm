import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        //참가자 수 세기
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        //참가자 중 완주한 수 뺴기
        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        //완주하지 못한 선수 찾기
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}