

import java.util.*;
import java.io.*;


public class Main {
    static final int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1}; 
    static final int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
    
    static void dfs(int x, int y, int[][] map, boolean[][] visted, int h, int w) {
    	visted[x][y]=true;
    	
    	for (int i=0;i<8;i++) {
    		int idx=x+dx[i];
    		int idy=y+dy[i];
    		
    		if(0<=idx && idx<h&& 0<=idy && idy<w &&!visted[idx][idy] && map[idx][idy]==1) {
    			dfs(idx,idy,map,visted,h,w);
    		}
    	}
    }
	
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	while(true) {
    		StringTokenizer st= new StringTokenizer(br.readLine());
    		
    		int w=Integer.parseInt(st.nextToken());
    		int h=Integer.parseInt(st.nextToken());
    		
    		if(w==0 && h==0) {
    			break;
    		}
    		
    		int[][] array=new int[h][w];
    		
    		for(int i=0; i<h;i++) {
    			st= new StringTokenizer(br.readLine());
    			for(int j=0; j<w;j++) {
    				array[i][j]=Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		//방문
    		boolean[][] visited = new boolean[h][w];
    		
    		//섬
    		int cnt=0;
    		//dfs 
    		
    		for(int i=0; i<h;i++) {
    			
    			for(int j=0; j<w;j++) {
    				if(array[i][j]==1 && !visited[i][j]) {
    					dfs(i,j,array,visited,h,w);
    					cnt++;
    				}
    			}
    		}
    		
    		System.out.println(cnt);
    		
    	}
    	
    }
    

}
