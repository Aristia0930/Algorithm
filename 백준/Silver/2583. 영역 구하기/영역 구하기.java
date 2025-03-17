
import java.util.*;
import java.io.*;

public class Main {
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static 	boolean[][] v;
	static Queue<int[]> q;
	static int value;
	static int[][] arr;
	static void bfs(int n,int m) {
    	while(!q.isEmpty()) {
    		int[] now=q.poll();
    		
    		if(v[now[0]][now[1]]) {
    			continue;
    		}
    		v[now[0]][now[1]]=true;
    		value++;
    		
    		for(int i=0;i<4;i++) {
    			int idx=now[1]+dx[i];
    			int idy=now[0]+dy[i];
    			
    			if(0<=idy && idy<n && 0<=idx && idx<m &&arr[idy][idx]==0) {
    				if (!v[idy][idx]) {
    					q.offer(new int[] {idy,idx});
    				}
    			}
    		}
    		
    	}
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	int m=Integer.parseInt(st.nextToken());
    	int k=Integer.parseInt(st.nextToken());
    	
    	arr=new int[n][m];

    	for(int i=0;i<k;i++) {
    		st=new StringTokenizer(br.readLine());
        	int x1=Integer.parseInt(st.nextToken());
        	int y1=Integer.parseInt(st.nextToken());
        	int x2=Integer.parseInt(st.nextToken());
        	int y2=Integer.parseInt(st.nextToken());
        	
        	for (int y=y1; y<y2;y++) {
        		for (int x=x1;x<x2;x++) {
        			arr[y][x]=1;
        		}
        	}
    		
    	}
    	int count=0;
    	List<Integer> ans=new ArrayList<Integer>();
    	v = new boolean[n][m];
    	q=new LinkedList<int[]>();
    	for (int y=0; y<n;y++) {
    		for (int x=0;x<m;x++) {
    			if(arr[y][x]==0 && !v[y][x]) {
    				q.offer(new int[] {y,x});
    				count+=1;
    				bfs(n,m);
    				ans.add(value);
    				value=0;
    				
    			}
    			
    		}
    	
    	} 	
    	System.out.println(count);
    	Collections.sort(ans);
    	for (int i: ans) {
    		System.out.print(i+" ");
    	}
 
    	
    	
    	

    	
    }
}
