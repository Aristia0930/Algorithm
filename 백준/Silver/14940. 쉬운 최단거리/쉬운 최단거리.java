import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int endx = 0;
		int endy=0;
		int[][] array=new int[n][m];
		for (int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
				if (array[i][j]==2) {
					endx=i;
					endy=j;
				}
			}
			
		}
		int[][] d=new int[n][m];
		bfs(array,d,endx,endy);	
		for (int i=0;i<n;i++) {
			for (int j=0; j<m;j++) {
				if(array[i][j]==0 && d[i][j]==0) {
					System.out.print(d[i][j]+" ");
				}
				else if (array[i][j]==2) {
					System.out.print(0+" ");
				}
				else if((array[i][j]!=0 )&& d[i][j]==0)  {
					System.out.print(-1+" ");
				}
				else {
					System.out.print(d[i][j]+" ");
				}
			
			}
			System.out.println();
		}
		
		


}
	
	static void bfs(int[][] g,int[][]d,int ex,int ey) {
		d[ex][ey]=0;
		Queue<int[]> q=new LinkedList<int[]>();;
		q.offer(new int[] {ex,ey});
		
		
		while (!q.isEmpty()) {
			int[] now=q.poll();
			int now_x=now[0];
			int now_y=now[1];
			
			
			for(int i=0;i<4;i++) {
				int idx=now_x+dx[i];
				int idy=now_y+dy[i];
				
				if(0<=idx && idx<n &&0<=idy &&idy<m && g[idx][idy]==1 ) {
					if(d[idx][idy]==0) {
						d[idx][idy]=d[now_x][now_y]+1;
						q.offer(new int[] {idx,idy});
					}
				}
				
				
			}
			
		}
		

	}
}