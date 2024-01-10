import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }

        int M = sc.nextInt();
        long[] findArr = new long[M];
        for (int i = 0; i < findArr.length; i++) {
            findArr[i] = sc.nextLong();
        }

        int[] answer = new int[M];

        Arrays.sort(arr);

        for (int i = 0; i < findArr.length; i++) {
            long target = findArr[i];
            int lt = 0;
            int rt = arr.length - 1;
            if (arr[lt] > target || arr[rt] < target) {
                answer[i] = 0;
            } else {
                while (lt <= rt) {
                    int mid = (lt + rt) / 2;
                    if(arr[mid] == target) {
                        answer[i] = 1;
                        break;
                    }
                    if(arr[mid] > target) {
                        rt = mid - 1;
                    }
                    if(arr[mid] < target)
                        lt = mid + 1;
                }
                if(lt > rt) answer[i] = 0;
            }
        }

        for(int x : answer){
            System.out.println(x);
        }
    }
}