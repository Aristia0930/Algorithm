

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static ArrayList<String> list=new ArrayList<>();
	static void mn(int depth,int[] array,int index,String ans,boolean[] check) {
		if(depth>=m) {
			if(!list.contains(ans)) {
				list.add(ans);
			}
		}
		else {
			for(int i=0;i<n;i++) {
				if(!check[i]) {
				check[i]=true;
				mn(depth+1,array,i,ans+array[i]+" ",check);
				check[i]=false;
				}
				
			}
		}
		
	}
	



    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	n=Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	st=new StringTokenizer(br.readLine());
    	int[] arr = new int[n];
    	for (int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	boolean[] check=new boolean[n];
    	
    	mn(0,arr,-1,"",check);
        for (String s : list) {
        	System.out.println(s.trim());
        }
  
    	
    	
    	
    }

    

}
