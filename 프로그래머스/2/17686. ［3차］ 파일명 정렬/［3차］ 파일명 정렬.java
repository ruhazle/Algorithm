import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> list = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
            char[] chars = files[i].toCharArray();
            String head = "";
            String number = "";
            int index = Integer.MAX_VALUE;
            for(int j = 0; j < chars.length; j++) {
                if(j > index && !Character.isDigit(chars[j]))
                    break;
                if(!Character.isDigit(chars[j])){
                    head += chars[j];
                }
                if(Character.isDigit(chars[j])) {
                    index = j;
                    number += chars[j];
                }
            }
            
            list.add(new File(i, head.toLowerCase(), Integer.parseInt(number)));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = files[list.get(i).order];
        }
            
        return answer;
    }
}

class File implements Comparable<File> {
    int order;
    String head;
    int number;
    
    File(int order, String head, int number) {
        this.order = order;
        this.head = head;
        this.number = number;
    }
    
    public int compareTo(File f) {
        int result = this.head.compareTo(f.head);
        if(result == 0) {
            result = Integer.compare(this.number, f.number);
            if(result == 0) {
                result = Integer.compare(this.order, f.order);
            }
        }
        
        return result;
    }
}