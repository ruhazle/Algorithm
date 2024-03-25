import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int index = arr[0];
        answer.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == index)
                index = arr[i];
            else {
                answer.add(arr[i]);
                index = arr[i];
            }
        }
        
        return answer;
    }
}