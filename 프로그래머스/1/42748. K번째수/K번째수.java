import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int order = commands[i][2] -1;
            
            int[] temp;
            if(start == end) {
                 temp = new int[1];
                 temp[0] = array[start];
            }
            else temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            answer[i] = temp[order];
        }
        return answer;
    }
}