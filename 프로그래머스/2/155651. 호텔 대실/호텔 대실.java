import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] book = new int[1451];
        for(String[] x : book_time) {
            String[] start = x[0].split(":");
            String[] end = x[1].split(":");
            int sm = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int em = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
            for(int i = sm; i < em; i++) {
                book[i]++;
            }
        }
        
        Arrays.sort(book);
        answer = book[book.length-1];
        
        return answer;
    }
}