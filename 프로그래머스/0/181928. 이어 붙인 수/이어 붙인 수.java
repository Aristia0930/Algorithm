class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String array1="";
        String array2="";
        
        for (int i :num_list) {
            if (i % 2 == 0) {
                array1 += i; // 짝수 인덱스 숫자 추가
            } else {
                array2 +=i; // 홀수 인덱스 숫자 추가
            }
        }
        
        return Integer.parseInt(array1)+Integer.parseInt(array2);
    }
}