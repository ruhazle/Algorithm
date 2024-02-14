import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer  = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int Aindex = A.length - 1;
        int Bindex = B.length - 1;
        while(Aindex >= 0 && Bindex >= 0) {
            if(B[Bindex] > A[Aindex]){
                answer++;
                Bindex--;
                Aindex--;
            } else {
                Aindex--;
            }
        }
        return answer;
    }
}