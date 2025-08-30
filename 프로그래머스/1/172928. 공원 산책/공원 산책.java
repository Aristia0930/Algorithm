class Solution {
    public int[] solution(String[] park, String[] routes) {
    
        int h=park[0].length();
        int w=park.length;
        int x=0;
        int y=0;
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                if(park[i].charAt(j)=='S'){
                    y=i;
                    x=j;
                    break;
                }
            }
        }
        

        //시작 0,0 e +1 , w-1, n y+1
        for(String route:routes){
            String[] r=route.split(" ");
            int count=Integer.parseInt(r[1]);
            int nx=x;
            int ny=y;
            for(int i=0;i<count;i++){

                if(r[0].equals("E")){
                    nx=nx+1;
                    
                    
                }else if(r[0].equals("W")){
                    nx=nx-1;
                    
                }else if(r[0].equals("N")){
                    ny=ny-1;
                    
                }else{
                    ny=ny+1;
                }
                
                if(0<=nx && nx<h && 0<=ny && ny<w && (park[ny].charAt(nx)=='O' ||park[ny].charAt(nx)=='S' ) ){
                    
                }else{
                    nx=x;
                    ny=y;
                    break;
                }
                
            }
            x=nx;
            y=ny;

        }
        System.out.print(y);
        System.out.println(x);
        int[] answer = {y,x};
        
        return answer;
    }
}