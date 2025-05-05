

import java.util.*;
import java.io.*;

public class Main {
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	Long[] arr = new Long[n];
    	
    	st=new StringTokenizer(br.readLine());
    	for(int i=0; i<n;i++) {
    		arr[i]=Long.parseLong(st.nextToken());
    	}
    	

    	Arrays.sort(arr);
    	Long min_sum=Long.MAX_VALUE;
    	Long n1=0L;
    	Long n2=0L;
    	Long n3=0L;

        
        for(int i=0;i<n;i++) {
        	
            int left = i+1;
            int right = n - 1;
            while(left<right) {
            	long sum=arr[left]+arr[right]+arr[i];
            	long absSum = Math.abs(sum);
            	if(absSum<min_sum) {
            		min_sum=absSum;
            		n3=arr[i];
            		n1=arr[left];
            		n2=arr[right];
            		
            		
            	}
            	
            	if(sum<0) {
            		left++;
            	}else {
            		right--;
            	}
            	
            }
        }
        

    	

    	System.out.println(n3+" "+n1+" "+n2);
    	


    	
    	
    	
    
    }


}
