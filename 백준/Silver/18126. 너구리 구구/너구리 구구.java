import java.util.*;


import java.io.*;
import java.math.BigInteger;


public class Main {
	
    public static void main(String[] args) throws Exception  {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	int[][] array=new int[n+1][n+1];
    	for(int i=0;i<n-1;i++) {
    		st=new StringTokenizer(br.readLine());
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		int c=Integer.parseInt(st.nextToken());
    		array[a][b]=c;
    		array[b][a]=c;
    		
    	}
    	 long[] dist = new long[n + 1];
    	boolean[] visited= new boolean[n+1];
    	Queue<Integer> q= new LinkedList<>();
    	visited[1]=true;
    	q.offer(1);
    	dist[1]=0;
    	
    	while(!q.isEmpty()) {
    		int now=q.poll();
    		
    		for(int i=1;i<n+1;i++) {
    			if(array[now][i]!=0 &&!visited[i]) {
    				dist[i]=dist[now]+array[now][i];
    				visited[i]=true;
    				q.offer(i);
    			}
    		}
    	}
    	
    	long ans=0l;
    	for(int i=1;i<n+1;i++) {
    		ans=Math.max(ans,dist[i]);
    	}
    	System.out.println(ans);
    	
    	
    	
    	
    	

    }

        

    
    

}
