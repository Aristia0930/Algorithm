import java.util.*;


import java.io.*;
import java.math.BigInteger;


public class Main {
	


	
    public static void main(String[] args)throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	int[] array= new int[n+1];
    	array[0]=0;
    	array[1]=1;
    	
    	if(n>=2) {
    	
	    	for(int i=2;i<=n;i++) {
	    		array[i]=array[i-1]+array[i-2];
	    	}
    	}
    	System.out.println(array[n]);
    	

    }
}
