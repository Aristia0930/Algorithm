import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int z=stk.size();
            if(stk.isEmpty()){
                stk.add(arr[i]);
                i++;
            }
            else if(stk.get(z-1)<arr[i]){
                stk.add(arr[i]);
                i++;
            }
            else if(stk.get(z-1)>=arr[i]){
                stk.remove(z-1);
            }
            
        }
        
        return stk;
    }
}