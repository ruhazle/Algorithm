class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] vilageNum = new int[101];
        int count = 1;
        for(int i = 1; i <= 100; i++) {
            while(true){
                if(count % 3 != 0 && count / 10 != 3 && count % 10 != 3 &&
                  count / 10 / 10 != 3 && count / 10 % 10 != 3)
                    break;
                count++;
            }
            
            vilageNum[i] = count;
            count++;
            
        }
        
        answer = vilageNum[n];
        return answer;
    }
}