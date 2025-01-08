import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int[][] queries) {
    	ArrayList<Integer> answer = new ArrayList<>();
        
    	
    	for(int i=0;i<queries.length;i++){
            int s=queries[i][0];
            int e=queries[i][1];
            int k=queries[i][2];
            int rs=1000001;
            for(int j=s;j<=e;j++){
                if(arr[j]>k){
                    rs=Math.min(rs,arr[j]);
                }
            }
            if(rs==1000001){
                rs=-1;
            }
            answer.add(rs);
        }
    	
        return answer;
    }
}