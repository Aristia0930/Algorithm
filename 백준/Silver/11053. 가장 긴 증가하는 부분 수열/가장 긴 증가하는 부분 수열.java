
import java.util.*;
import java.io.*;

public class Main {
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[n];

        int[] dp = new int[n]; 

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<n;i++) {
        	dp[i]=1;
        	
        	for(int j=0;j<i;j++) {
        		if(arr[j]<arr[i]) {
        			dp[i]=Math.max(dp[i], dp[j]+1);
        		}
        	}
        	
        }
        
        int rs=0;
        for(int i=0;i<n;i++) {
        	if(rs<dp[i] ){
        		rs=dp[i];
        	}
        }
        System.out.println(rs);

    }


}
