

import java.util.*;
import java.io.*;

public class Main {
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int ans=0;
    	
    	for(int i=1;i<=n;i++) {
    		String s=String.valueOf(i);
    		int sum=i;
    		for(int j=0;j<s.length();j++) {
    			char c= s.charAt(j);
    			sum+=Integer.parseInt(String.valueOf(c));
    		}
    		
    		if(sum==n) {
    			ans=i;
    			break;
    		}
    	}
    	System.out.println(ans);
    	

    	
    	


    	
    	
    	
    
    }


}
