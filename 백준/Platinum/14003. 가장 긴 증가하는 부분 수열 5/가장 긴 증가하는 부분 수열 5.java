

import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	static int[] arr;
	static int[] array;
	static int count=0;
	static int search(int start, int end,int now) {
		
		while(start<end) {
			int mid=(start+end)/2;
			
			if(arr[now]<=array[mid]) {
				end=mid;
			}else {
				start=mid+1;
			}
			
			
		}
		
		return start;
	}
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int n =Integer.parseInt(br.readLine());
    	
    	arr=new int[n];
    	dp=new int[n];
    	
    	
    	array=new int[n+1];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    		

    	}
    	
    	count=0;
    	array[0]=Integer.MIN_VALUE;

    	int cnt=0;
    	for(int i=0;i<n;i++) {
    		if(array[count]<arr[i]) {
    			dp[i]=++count;
    			array[count]=arr[i];

    			
  
    		}else {
    			int start=0;
    			int end=count;
    			
    			int rs=search(start,end,i);
    			array[rs]=arr[i];
    			dp[i]=rs;


    			
    			
    			
    			
    		}
    	}
		StringBuilder sb = new StringBuilder();
		sb.append(count+"\n");

		Stack<Integer> s = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			if(dp[i] == count) {
				s.push(arr[i]);
				count--;
			}
		}
		
		while(!s.isEmpty()) {
			sb.append(s.pop()+" ");
		}
		System.out.println(sb.toString());
 

    	

    }
}
