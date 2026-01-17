import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(int num:num_list){
            if(count==0){
               list.add(num); 
            }
            
            count++;
            
            if(count==n){
                count=0;
            }
        }
        
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}