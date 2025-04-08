import java.util.*;
import java.io.*;
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans=-1;


    public static void main(String[] args) throws Exception {
    	
    	int[] arr=new int[101];
    	 StringTokenizer st= new StringTokenizer(br.readLine());
    	 
    	 
    	    
    	int n=Integer.parseInt(st.nextToken() );
    	
    	int m=Integer.parseInt(st.nextToken() );
    	
    	for(int i=0;i<n;i++) {
    		st= new StringTokenizer(br.readLine());
    		int k=Integer.parseInt(st.nextToken() );
    		arr[k]=Integer.parseInt(st.nextToken() );
    	}
    	
    
    	for(int i=0;i<m;i++) {
    		st= new StringTokenizer(br.readLine());
    		int k=Integer.parseInt(st.nextToken() );
    		arr[k]=Integer.parseInt(st.nextToken() );
    	}

    	
    	Queue<int[]> q= new LinkedList<int[]>();
    	boolean[] v = new boolean[101];
    	q.add(new int[] {1,0});
    	
    	while(!q.isEmpty()) {
    		int[] now =q.poll();
    		if(now[0]==100) {
    			ans=now[1];
    			break;
    		}
    		
    		
    		for(int i=1;i<=6;i++) {
    			if(i+now[0]<=100 && v[i+now[0]]==false) {
    				v[i+now[0]]=true;
    				if(arr[i+now[0]]==0) {
    					q.add(new int[] {i+now[0],now[1]+1});
    				}
    				else {
    					q.add(new int[] {arr[i+now[0]],now[1]+1});
    				}
    			}
    		}
    	}
    	System.out.println(ans);

    }

}