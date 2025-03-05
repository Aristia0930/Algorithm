

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx= {-1,1,0,0,0,0};
	static int[] dy= {0,0,1,-1,0,0};
	static int[] dh= {0,0,0,0,1,-1};
	static int n;
	static int m;
	static int h;
	static boolean[][][] v;
	static Queue<int[]> q;
	static int ans;
	static void bfs(int[][][] array) {	
		while (!q.isEmpty()) {
			int [] value = q.poll();
			int ix=value[0];
			int iy=value[1];
			int ih=value[2];
			int date=value[3];
			if (ans<date) {
				ans=date;
			}
			
			for (int i=0; i<6; i++) {
				int idx=ix+dx[i];
				int idy=iy+dy[i];
				int idh=ih+dh[i];
				
				if(0<=idx && idx<m && 0<=idy && idy<n && 0<=idh && idh<h && !v[idh][idy][idx] && array[idh][idy][idx]==0) {
					q.add(new int[] {idx,idy,idh,date+1});
					v[idh][idy][idx]=true;
					
				}
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		m =Integer.parseInt(st.nextToken());
		n =Integer.parseInt(st.nextToken());
		h =Integer.parseInt(st.nextToken());
		
		int[][][] array = new int[h][n][m];
		v=new boolean[h][n][m];	
		for (int i=0;i<h;i++) {
			for (int j=0; j<n; j++) {
				st= new StringTokenizer(br.readLine());
				for (int k=0; k<m; k++) {
					array[i][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
		 q = new LinkedList<int[]>();
		 
		for (int i=0;i<h;i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<m; k++) {
					if(array[i][j][k]==1) {
						int [] start= {k,j,i,0};
						q.add(start);
						v[i][j][k]=true;
					}
				}
			}
		}
		bfs(array);
		boolean check=true;
		for (int i=0;i<h;i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<m; k++) {
					if(array[i][j][k]!=-1 && v[i][j][k]==false) {
						check=false;
					}
				}
			}
		}
		
		if (!check) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}



		
		
	}

}
