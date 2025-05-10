
import java.util.*;
import java.io.*;

public class Main {
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int n =Integer.parseInt(br.readLine());
    	
    	int[] arr=new int[n];
    	int[] dp=new int[n];
    	ArrayList<ArrayList<Integer>> array=new ArrayList<>();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    		dp[i]=1;
    		array.add(new ArrayList<>());
    		array.get(i).add(arr[i]);
    	}
    	
    	for(int i=1; i<n;i++) {
    		for(int j=0;j<i;j++) {
    			
    			if(arr[j]<arr[i]) {
    				
    				if(dp[i]<dp[j]+1) {
    					dp[i]=dp[j]+1;
    					array.set(i, new ArrayList<>(array.get(j)));
    					array.get(i).add(arr[i]);
    					
    				}
    				
    			}
    		}
    		
    		
    	}
    	int rs=0;
    	
    	int ans=0;
    	for(int i=0;i<n;i++) {
    		if(rs<dp[i]) {
    			rs=dp[i];
    			ans=i;
    			
    		}
    	}
    	System.out.println(rs);
    	for(int a:array.get(ans)) {
    		System.out.print(a+" ");
    	}
    	
 

    	

    }
}
