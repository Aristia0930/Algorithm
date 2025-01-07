class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        for(int i=0;i<=num_list.length;i++){
            if(i<num_list.length){
                answer[i]=num_list[i];
            }
            else{
                if(answer[i-2]<num_list[i-1]){
                    answer[i]=num_list[i-1]-answer[i-2];
                }
                else{
                    answer[i]=2*num_list[i-1];
                }
            }
        }
        return answer;
    }
}