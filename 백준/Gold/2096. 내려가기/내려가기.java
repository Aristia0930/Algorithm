

import java.util.*;
import java.io.*;

public class Main {
	static int max_val=0;
	static int min_val =Integer.MAX_VALUE;
	static int n;

	
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n= Integer.parseInt(st.nextToken());
    	
    	
    	
    	
    	//최대값저장할 배열
    	int[][] max_arr= new int[n][3];
    	int[][] min_arr= new int[n][3];
    	for(int k=0;k<n;k++) {
    		min_arr[k][0]=Integer.MAX_VALUE;
    		min_arr[k][1]=Integer.MAX_VALUE;
    		min_arr[k][2]=Integer.MAX_VALUE;
    	}
    	
    	for(int i=0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		int c=Integer.parseInt(st.nextToken());
    		
    		if(i==0) {
    			max_arr[0][0]=a;
    			max_arr[0][1]=b;
    			max_arr[0][2]=c;
    			
    			min_arr[0][0]=a;
    			min_arr[0][1]=b;
    			min_arr[0][2]=c;
    		}else {
    			
    			//0 부분
    			max_arr[i][0]=Integer.max(max_arr[i-1][0]+a,max_arr[i][0]);
    			max_arr[i][0]=Integer.max(max_arr[i-1][1]+a,max_arr[i][0]);
    			
    			min_arr[i][0]=Integer.min(min_arr[i-1][0]+a,min_arr[i][0]);
    			min_arr[i][0]=Integer.min(min_arr[i-1][1]+a,min_arr[i][0]);
    			
    			//1부분
    			max_arr[i][1]=Integer.max(max_arr[i-1][0]+b,max_arr[i][1]);
    			max_arr[i][1]=Integer.max(max_arr[i-1][1]+b,max_arr[i][1]);
    			max_arr[i][1]=Integer.max(max_arr[i-1][2]+b,max_arr[i][1]);
    			
    			min_arr[i][1]=Integer.min(min_arr[i-1][0]+b,min_arr[i][1]);
    			min_arr[i][1]=Integer.min(min_arr[i-1][1]+b,min_arr[i][1]);
    			min_arr[i][1]=Integer.min(min_arr[i-1][2]+b,min_arr[i][1]);

    			//2부분
    			max_arr[i][2]=Integer.max(max_arr[i-1][2]+c,max_arr[i][2]);
    			max_arr[i][2]=Integer.max(max_arr[i-1][1]+c,max_arr[i][2]);
    			
    			min_arr[i][2]=Integer.min(min_arr[i-1][2]+c,min_arr[i][2]);
    			min_arr[i][2]=Integer.min(min_arr[i-1][1]+c,min_arr[i][2]);
    		}
    		

    	}  
    	
    	//최대값 찾기
    	max_val=Integer.max(max_arr[n-1][0],max_val);
    	max_val=Integer.max(max_arr[n-1][1],max_val);
    	max_val=Integer.max(max_arr[n-1][2],max_val);
    	
    	//최소값 찾기
    	min_val=Integer.min(min_arr[n-1][0],min_val);
    	min_val=Integer.min(min_arr[n-1][1],min_val);
    	min_val=Integer.min(min_arr[n-1][2],min_val);
    	
    	System.out.println(max_val+" "+min_val);


    	
    	

    }

}
