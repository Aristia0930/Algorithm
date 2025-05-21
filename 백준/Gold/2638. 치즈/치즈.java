
import java.util.*;
import java.io.*;

public class Main {

	//방문처리
	static boolean[][] visted2;
    static boolean[][] visted;
	//그래프
	static int[][] graph;
	

	
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
	//외부공기 체크 dfs
	static void dfsOut(int x,int y) {
		visted2[x][y]=true;
		
		for(int k=0;k<4;k++) {
			int idx=x+dx[k];
			int idy=y+dy[k];
			
			if(0<=idx && idx<n && 0<=idy && idy<m && graph[idx][idy]==0&&!visted2[idx][idy] ) {
				dfsOut(idx, idy);
			}
		}
		
	}
	



    public static void main(String[] args) throws Exception {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	n= Integer.parseInt(st.nextToken());
    	m= Integer.parseInt(st.nextToken());
    	graph=new int[n][m];
    	
    	
    	for(int i=0; i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<m;j++) {
    			graph[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int count=0;
    	
    	//루틴
    	while(true) {
    		visted=new boolean[n][m];
    		visted2=new boolean[n][m];
    		dfsOut(0, 0);
    		if(!visted2[0][m-1]) {
    			dfsOut(0, m-1);
    		}
    		if(!visted2[n-1][0]) {
    			dfsOut(n-1, 0);
    		}
    		if(!visted2[n-1][m-1]) {
    			dfsOut(n-1, m-1);
    		}
    		

    		
    		//치즈 녹이기
    		List<int[]> meltList = new ArrayList<>();
    		
    		for(int i=0; i<n;i++) {
    			for(int j=0;j<m;j++) {
    				if(graph[i][j]==1) {
    					int airCount=0;
    					
    					
    					for(int k=0;k<4;k++) {
    						int idx=i+dx[k];
    						int idy=j+dy[k];
    						
    						if(graph[idx][idy]==0&&visted2[idx][idy] && 0<=idx && idx<n && 0<=idy && idy<m ) {
    							airCount++;
    						}
    					}
    					
    					if(airCount>=2) {
    						meltList.add(new int[] {i,j});
    					}
    					
    				}
    				
    				
    				
    			}
    		}
    		
    		if(meltList.size()==0) {
    			break;
    		}

    		
    		//녹인 치즈 그래프에 반영하기 
    		for(int[] a: meltList) {
    			int x=a[0];
    			int y=a[1];
    			graph[x][y]=0;
    		}
    		
    		count++;
    		
    			
    	}
   
    	
    	System.out.println(count);

    }
}
