import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] beforeCompression = new int[n];
        int[] afterCompression = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            beforeCompression[i] = Integer.parseInt(st.nextToken());
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

