import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] beforeCompression = new int[n];
        int[] afterCompression = new int[n];
        for(int i = 0; i < n; i++) {
            beforeCompression[i] = sc.nextInt();
        }

        int[] sortedArr = Arrays.stream(beforeCompression).distinct().sorted().toArray();
        Arrays.sort(sortedArr);

        for(int i = 0; i < beforeCompression.length; i++) {
            int low = 0;
            int high = sortedArr.length-1;
            int target = beforeCompression[i];

            while(low <= high) {
                int mid = (low + high) / 2;
                if(sortedArr[mid] == target) {
                    afterCompression[i] = mid;
                    break;
                }
                if(sortedArr[mid] < target)
                    low = mid+1;
                if(target < sortedArr[mid])
                    high = mid-1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int x : afterCompression) {
            sb.append(x);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}

