
import java.util.*;


import java.io.*;


public class Main {
	static int[] num;
	static int count;

	static void back(int c,int[] numbers,int i,int sum) {
		if(c==count) {
			num[sum]=1;
			
			return;
		}
		
		back(c+1,numbers,i+1,sum+numbers[i]);
		back(c+1,numbers,i+1,sum);

	}
	
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	count=Integer.parseInt(st.nextToken());
    	st=new StringTokenizer(br.readLine());
    	int[] numbers=new int[count];
    	int s=0;
        for (int i = 0; i < count; i++) {
        	int j=Integer.parseInt(st.nextToken());
            numbers[i] = j;
            s+=j;
            
        }
        num=new int[s+2];
        back(0,numbers,0,0);
        
        for(int i=1;i<num.length;i++) {
        	if(num[i]==0) {
        		System.out.println(i);
        		break;
        	}
        }
        

        

    }
    

}