import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i = 0; i < str1.length()-1; i++) {
            list1.add(str1.substring(i, i+2));
        }

        for(int i = 0; i < str2.length()-1; i++) {
            list2.add(str2.substring(i, i+2));
        }

        list1 = list1.stream().filter(x -> (x.charAt(0) >= 97 && x.charAt(0) <= 122) && (x.charAt(1) >= 97 && x.charAt(1) <= 122)).collect(Collectors.toList());
        list2 = list2.stream().filter(x -> (x.charAt(0) >= 97 && x.charAt(0) <= 122) && (x.charAt(1) >= 97 && x.charAt(1) <= 122)).collect(Collectors.toList());

        List<String> allList = new ArrayList<>();
        List<String> common = new ArrayList<>();
        for(String x : list1) {
            if(list2.contains(x)){
                common.add(x);
                list2.remove(x);
            }
            allList.add(x);
        }
        
        for(String x : list2) {
            allList.add(x);
        }

        if(allList.size() == 0) return 65536;
        else {
            double d = common.size() / (double) allList.size() * 65536;
            answer = (int) d;
        }
        
        return answer;
    }
}