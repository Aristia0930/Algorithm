
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [][] a;
    static boolean [][] visited;
    static int max = 0;
    static boolean in_range(int x, int y) {
    	if(x >= 0 && x <n && y >= 0 && y < m) {
    		return true;
    	}
    	return false;
    }
    static int [] dx = {-1 ,0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    
    static void DFS(int r, int c, int count, int sum) {
    	if(count == 4) {
    		if(max < sum) {
    			max = sum;
    		}
    		return;
    	}
    	visited[r][c] = true;
    	for(int k = 0;k<4;k++) {
    		int x = r + dx[k];
    		int y = c + dy[k];
    		if(in_range(x, y) && !visited[x][y]) {
    			DFS(x, y, count + 1, sum + a[x][y]);
    		}
    	}
    	visited[r][c] = false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0;j<m;j++) {
        		a[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        for(int i = 0;i<n;i++) {
        	for(int j = 0;j<m;j++) {
        		DFS(i, j, 1, a[i][j]);
        	}
        }
        
        for(int i =0;i<n - 1;i++) { // - = - 모양
        	for(int j = 0;j<m - 2;j++) {
        		int sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1];
        		if(max < sum) {
        			max = sum;
        		}
        	}
        }
        
        for(int j = 0;j<m - 1;j++) { // 왼쪽 튀어나온 모양
        	for(int i = 0;i<n - 2;i++) {
        		int sum = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 1][j + 1];
        		if(max < sum) {
        			max = sum;
        		}
        	}
        }
        for(int i = 1;i<n;i++) {
        	for(int j = 0;j<m - 2;j++) {
        		int sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j + 1];
        		if(max < sum) {
        			max = sum;
        		}
        	}
        }
        for(int j = 1;j<m;j++) { // 왼쪽 튀어나온 모양
        	for(int i = 0;i<n - 2;i++) {
        		int sum = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 1][j - 1];
        		if(max < sum) {
        			max = sum;
        		}
        	}
        }
        System.out.println(max);
    }
}