

import java.util.*;


import java.io.*;
import java.math.BigInteger;


public class Main {

	
    public static void main(String[] args) throws Exception  {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	
    	for(int i=0; i<n;i++) {
    		String[] array=br.readLine().split(" ");
    		
    		String temp1=array[0];
    		String temp2=array[1];
    		
    		int len=array.length;
    		for(int j=2;j<len;j++) {
    			System.out.print(array[j]+" ");
    		}
    		System.out.print(temp1+" ");
    		System.out.println(temp2);
    		
    	}
    	
    	
    	
    	
    	

    }

        

    
    

}
