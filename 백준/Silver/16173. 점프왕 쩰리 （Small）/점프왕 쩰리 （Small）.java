

import java.util.*;
import java.io.*;

public class Main {

	
	
    static int[] dx = { 1, 0,};
    static int[] dy = {0, 1};
    static int n;
    static int[][] graph;
    static boolean[][] visted;

    
    static void dfs(int x, int y) {
    	
    	int count=graph[x][y];
    	visted[x][y]=true;
    	for(int i=0;i<2;i++) {
    		int nx=x+dx[i]*count;
    		int ny=y+dy[i]*count;
    		
    		if(nx<n && ny<n && visted[nx][ny]==false) {

    			dfs(nx,ny);


    		}
    	}
    }



    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	n=Integer.parseInt(st.nextToken());
    	
    	graph=new int[n][n];
    	visted=new boolean[n][n];
    	
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<n;j++) {
    			graph[i][j]=Integer.parseInt(st.nextToken());
    		}
    		
    	}
    	dfs(0,0);
    	
    	if(visted[n-1][n-1]) {
    		System.out.println("HaruHaru");
    	}else {
    		System.out.println("Hing");
    	}
    	


    }
}
