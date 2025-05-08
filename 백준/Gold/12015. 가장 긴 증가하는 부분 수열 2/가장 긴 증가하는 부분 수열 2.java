
import java.util.*;
import java.io.*;

public class Main {
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int n =Integer.parseInt(br.readLine());
    	
    	int[] arr=new int[n];
    	int[] dp=new int[n];
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    		
    	}
    	int count=0;
    	dp[count++]=arr[0];
    	for(int i=1;i<n;i++) {
    		if(dp[count-1]<arr[i]) {
    			dp[count++]=arr[i];
    		}else {
    			//이분탐색
    			int start=0;
    			int end=count;
    			
    			while(start<end) {
    				int mid=(start+end)/2;
    				if(arr[i]<=dp[mid]) {
    					end=mid;
    				}else {
    					start=mid+1;
    				}
    				
    			}
    			
    			dp[start]=arr[i];
    			
    		}
    	}
    	int ans=0;
    	for(int i=0;i<n;i++) {
    		if(dp[i]!=0) {
    			ans++;
    		}
    	}
    	System.out.println(ans);
    	

    }
}
