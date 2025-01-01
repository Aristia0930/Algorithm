class Solution {
    public String solution(String code) {
        String answer = "";
        int mod=0;
        for (int i=0;i<code.length();i++){
            if (mod==0){

                if(i%2==0 && code.charAt(i)!='1'){
                answer+=code.charAt(i);
                }
                else if(code.charAt(i)=='1'){
                    mod=1;
                }



            }else if(mod==1) {
                if(i%2==1 && code.charAt(i)!='1'){
                    answer+=code.charAt(i);
                }
                else if(code.charAt(i)=='1'){
                    mod=0;
                }
            }

        }
        if (answer.length()==0){
            answer="EMPTY";
        }
        return answer;
    }
}