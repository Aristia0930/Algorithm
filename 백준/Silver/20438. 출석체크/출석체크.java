
import java.util.*;
import java.io.*;

public class Main {

    
    public static void main (String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	int n=Integer.parseInt(st.nextToken());
    	int k=Integer.parseInt(st.nextToken());
    	int q=Integer.parseInt(st.nextToken());
    	int m=Integer.parseInt(st.nextToken());
    	
    	st= new StringTokenizer(br.readLine());
    	int[] arr= new int[n+4];
    	for(int i=0;i<k;i++) {
    		int people=Integer.parseInt(st.nextToken());
    		arr[people]=-1;
    	}
    	
    	st= new StringTokenizer(br.readLine());
    	
    	for(int i=0;i<q;i++) {
    		int people=Integer.parseInt(st.nextToken());
    		if (arr[people]!=-1) {
    			arr[people]=1;
				for(int r=people;r<=(n+3);r+=people) {
					if(arr[r]!=-1) {
						arr[r]=1;
					}
				}
    		}
    	}
    	int[] dp= new int[n+4];
    	
    	for(int i=3;i<n+4;i++) {
    		if(arr[i]!=1) {
    			dp[i]=dp[i-1]+1;
    		}
    		else {
    			dp[i]=dp[i-1];
    		}

//    		System.out.println(dp[i]);
//    		System.out.println();
    	}
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int absentCount = dp[end]-dp[start-1];

//            for (int j = start; j <= end; j++) {
//                if (arr[j] != 1) { // 출석하지 않은 학생
//                    absentCount++;
//                }
//            }
            System.out.println(absentCount);
        }
    }
    	

}
