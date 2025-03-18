import java.util.*;
import java.io.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        String answer="";
        int index = 0;
        int count = 0;

        while (answer.length() < t) {
            String num = Integer.toString(index, n).toUpperCase(); 
            index++; 
            
    
            for (int i = 0; i < num.length(); i++) {
                count++;  
                

                if (count ==p ) {
                    answer+=String.valueOf(num.charAt(i));
                }
                
                if (answer.length() == t) {
                    break;
                }
                if (count==m){
                    count=0;
                }
            }
        }
        
 
        return answer;
    }
}