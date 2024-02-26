class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String temp = "";
        for(char c : my_string.toCharArray()) {
            if(Character.isDigit(c)){
                temp += c;
            } else {
                if(temp.length() > 0) {
                    answer += Integer.parseInt(temp);
                    temp = "";
                }
            }     
        }
        
        if(temp.length() > 0) 
            answer += Integer.parseInt(temp);
        
        return answer;
    }
}