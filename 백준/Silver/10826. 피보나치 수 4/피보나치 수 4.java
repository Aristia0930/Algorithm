

import java.util.*;


import java.io.*;
import java.math.BigInteger;


public class Main {


	
	
    public static void main(String[] args) throws Exception  {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n= Integer.parseInt(st.nextToken());
    	
    	BigInteger[] ans=new BigInteger[10002];
    	int i=2;
    	ans[0]=BigInteger.ZERO;
    	ans[1]=BigInteger.ONE;
    	
    	while(i<=n) {
    		ans[i]=ans[i-1].add(ans[i-2]);
    		i++;
    	}
    	System.out.println(ans[n]);
        

    }

        

    
    

}
