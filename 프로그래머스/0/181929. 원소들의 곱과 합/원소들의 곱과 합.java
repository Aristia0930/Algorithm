class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int num=1;
        int num2=0;
        for(int i:num_list){
            num*=i;
            num2+=i;
        }
        answer = num<(num2*num2) ? 1:0;
        return answer;
    }
}