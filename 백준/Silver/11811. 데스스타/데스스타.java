

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int[] arr=new int[n];
    	int[][] array=new int[n][n];
    	
    	for (int i=0; i<n;i++) {
    		st= new StringTokenizer(br.readLine());
        	for (int j=0; j<n;j++) {
        		array[i][j]=Integer.parseInt(st.nextToken());

        	}
    	}
    	
    	for (int i=0; i<n;i++) {
        	for (int j=0; j<n;j++) {
        		if(i!=j) {
        			arr[i]|=array[i][j];
        		}

        	}
    	}
    	for (int i=0; i<n;i++) {
    		System.out.print(arr[i]+" ");
    	}
    
    	
    	

    			
    }
    

}
