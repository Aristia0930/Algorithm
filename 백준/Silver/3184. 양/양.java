

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int max_d=0;
	static int max_s=0;
	static boolean[][] visted;
	static String[][] arr;
	static int n;
	static int m;
	//dfs  s양 d늑대
	static void dfs(int x,int y) {
		visted[x][y]=true;
		if(arr[x][y].equals("o")) {
			max_s++;
		}
		if(arr[x][y].equals("v")) {
			max_d++;
		}
		
		for(int i=0;i<4;i++) {
			int idx=x+dx[i];
			int idy=y+dy[i];
			if(0<=idx && idx<n && 0<=idy && idy<m&&!visted[idx][idy]&& !arr[idx][idy].equals("#")) {
				dfs(idx,idy);

			}
		}
		
		
	}


    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	
    	n =Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr=new String[n][m];
    	
    	for(int i=0;i<n;i++) {
    		String line = br.readLine();
    		for(int j=0;j<m;j++) {
    			arr[i][j]=String.valueOf(line.charAt(j));
    			
    		}
    	}
    	
    	//방문
    	visted=new boolean[n][m];
    	
    	int d=0;
    	int s=0;
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(!arr[i][j].equals("#")&& !visted[i][j]) {
    				max_d=0;
    				max_s=0;
    				dfs(i,j);
    				
    				if(max_d>=max_s) {
    					d+=max_d;
    				
    				}
    				else {
    					s+=max_s;
    				}
    			
    			}
    			
    		}
    	}
    	
    	System.out.println(s+" "+d);
    	
    	
    	
    
    }


}
