class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] count = new int[201];
        for(int i = 0; i < lines.length; i++) {
            for(int j = lines[i][0]+101; j <= lines[i][1]+100; j++) {
                count[j]++;
            }
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 1) answer++;
        }
        return answer;
    }
}