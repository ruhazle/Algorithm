class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            answer[i] = num + ((num ^ (num+1)) >> 2) + 1;
        }
        return answer;
    }
}