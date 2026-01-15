class Solution {
    public int solution(int n, int w, int num) {
        //홀수 오른쪽
        //짝수 왼쪽 
        int c = (n + w - 1) / w;
        int[][] array=new int[c][w];
        int count=1;
        
        int value=1;
        int x=-1;
        int y=-1;
        for(int i=0;i<c;i++){
            if(value %2==1){
                for(int j=0;j<w;j++){
                    if(count==num){
                        x=value-1;
                        y=j;
                    }
                    array[value-1][j]=count;
                    count++;
                    
                    
                    if(count==n+1){
                        break;
                    }
                    
                }
            }else{
                for(int j=w-1;j>=0;j--){
                    if(count==num){
                        x=value-1;
                        y=j;
                    }
                    array[value-1][j]=count;
                    count++;
                    if(count==n+1){
                        break;
                    }
                }
                
            }
            value++;
            if(count==n+1){
                break;
            }
        }
    
    
        
        int answer = 0;
        answer= c-x-1;
        if(array[c-1][y]!=0){
            answer++;
        }
        return answer;
    }
}