class Solution {
    static int case1(int n){
        int number=0;
        for(int i=1;i<=n;i+=2){
            number+=i;
        }
        return number;
    }

    static int case2(int n){
        int number=0;
        for(int i=2;i<=n;i+=2){
            number+=(i*i);
        }
        return number;
    }
    
    public int solution(int n) {
        int answer = 0;
        if(n%2==0){
            return case2(n);
        }
        return case1(n);
    }
}