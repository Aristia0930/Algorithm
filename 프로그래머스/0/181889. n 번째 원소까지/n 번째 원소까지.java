import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> list=new ArrayList<>();
        for(int num: num_list){
            list.add(num);
        }
        List<Integer> list2=list.subList(0,n);
        
        
        int[] answer = list2.stream().mapToInt(i->i).toArray();
        return answer;
    }
}