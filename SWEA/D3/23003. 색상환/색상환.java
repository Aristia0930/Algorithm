
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader  br=new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int t=Integer.parseInt(st.nextToken());
        Map<String,Integer> colors=new HashMap<>();
        colors.put("red",1);
        colors.put("orange",2);
        colors.put("yellow",3);
        colors.put("green",4);
        colors.put("blue",5);
        colors.put("purple",6);
        
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            String n1=st.nextToken();
            String n2 = st.nextToken();
            
            int a=colors.get(n1);
            int b=colors.get(n2);
            
            int ap=a+1;
            int am=a-1;
            if(ap>6){
                ap=1;
            }
            if(am==0){
                am=6;
            }

            
            
            if(a==b){
                System.out.println("E");
            }else if(ap==b || am==b){
                System.out.println("A");
            }else if(a+3==b ||a-3==b){
                System.out.println("C");
            }else{
                System.out.println("X");
            }
            
        }

	}
}