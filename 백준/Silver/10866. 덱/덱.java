

import java.util.*;


import java.io.*;
import java.math.BigInteger;


public class Main {
	


	
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> array = new ArrayDeque<>();
        while(n!=0) {
        	
        	st= new StringTokenizer(br.readLine());
        	String s=st.nextToken();
        	if(s.equals("push_front")) {
        		array.addFirst(Integer.parseInt(st.nextToken()));
        	}
        	
        	if(s.equals("push_back")) {
        		array.addLast(Integer.parseInt(st.nextToken()));
        	}
        	if(s.equals("pop_front")) {
        		
        		if(array.isEmpty()) {
        			System.out.println(-1);
        		}
        		else{
            		int r=array.pollFirst();
            		System.out.println(r);
        				
        		}
  
        	}
        	if(s.equals("pop_back")) {
        		
        		if(array.isEmpty()) {
        			System.out.println(-1);
        		}
        		else{
             		int r=array.pollLast();
            		System.out.println(r);
        				
        		}
   
        	}
        	if(s.equals("size")) {
        		int r=array.size();
        		System.out.println(r);
        	}
        	if(s.equals("empty") && array.isEmpty()) {
        		System.out.println(1);
        	}
        	if(s.equals("empty") && !array.isEmpty()) {
        		System.out.println(0);
        	}
        	
        	if(s.equals("front")) {
        		if(array.isEmpty()) {
        			System.out.println(-1);
        		}
        		else{
        			int r=array.getFirst();
        			System.out.println(r);
        				
        		}
        		
        	}
        	if(s.equals("back")) {
        		if(array.isEmpty()) {
        			System.out.println(-1);
        		}
        		else{
        			int r=array.getLast();
        			System.out.println(r);
        				
        		}
        		
        	}
        	
        	n--;
        }

    
    
    }
}
