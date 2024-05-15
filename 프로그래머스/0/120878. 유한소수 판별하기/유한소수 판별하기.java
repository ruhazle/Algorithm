class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int gcd = gcd(b, a);
        if(gcd != b) {
            a /= gcd;
            b /= gcd;
        }
   
        for(int i = 2; i <= b; i++) {
            if(b % i == 0) {
                if(i != 2 && i != 5) {
                    answer = 2;
                    break;
                }
                
                while(b % i == 0)
                    b /= i;
            }
        }
        
        return answer;
    }
    
    int gcd(int n1, int n2) {
        if(n1 % n2 == 0)
            return n2;
        return gcd(n2, n1 % n2);
    }
}