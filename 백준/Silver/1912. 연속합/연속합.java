import java.util.*;
import java.io.*;

public class Main {




    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	int[] arr=new int[n];
    	
    	st=new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	long max_value=Long.MIN_VALUE;
    	
    	long[]dp=new long[n];
    	dp[0]=arr[0];
  		if(max_value<dp[0]) {
			max_value=dp[0];
		}

    	
    	for(int i=1;i<n;i++) {
    		if(dp[i-1]+arr[i]<arr[i]) {
    			dp[i]=arr[i];
    		}
    		else{
    			dp[i]=dp[i-1]+arr[i];
    		}
    		
    		if(max_value<dp[i]) {
    			max_value=dp[i];
    		}

    	}
    	
    	
    	
    	System.out.println(max_value);
    	
    }
}