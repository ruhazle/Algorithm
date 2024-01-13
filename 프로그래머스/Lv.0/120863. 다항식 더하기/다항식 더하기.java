import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int num = 0;
        int numX = 0;
        String poly = polynomial.replace(" ", "");
        String[] polys = poly.split("\\+");
        for(String x : polys) {
            if(x.contains("x")) {
                String a = x.replace("x", "");
                if(a.equals(""))
                    numX += 1;
                else numX += Integer.parseInt(a);
            } else {
                num += Integer.parseInt(x);
            }
        }
        
        if(numX != 0 && num != 0){
            if(numX == 1){
                answer = "x + " + num;
            }
            else answer = numX + "x + " + num;
        } else if(numX == 0 && num == 0) {
            answer = 0 + " ";
        } else if(numX == 0) {
            answer = num + "";
        } else {
             if(numX == 1){
                answer = "x";
            }
            else answer = numX + "x";
        }
        
        return answer;
    }
}