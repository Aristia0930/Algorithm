

import java.util.*;
import java.io.*;

public class Main {
	


    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	long[][] array=new long[n][n];
    	int x=-1;
    	int y=-1;
    	
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0; j<n;j++) {
    			int m=Integer.parseInt(st.nextToken());
    			array[i][j]=m;
    			if(m==0) {
    				x=i;
    				y=j;
    			}
    		}
    		
    		
    	}
    	long  t=0l;
    	long  sum=0l;
    	
    	int find_x =  (x==0) ? 1:0;
    	
    	for(int i=0; i<n;i++) {
    		t+=array[find_x][i];
    	}
    	for(int i=0; i<n;i++) {
    		sum+=array[x][i];
    	}
    	
    	long rs=t-sum;
    	
    	array[x][y]=rs;
    	
    	//행 열체크

    	for(int i=0 ;i <n;i++) {
        	long col=0l;
        	long row=0l;
    		for(int j=0;j<n;j++) {
    			row+=array[i][j];
    			col+=array[j][i];
    		}
        	if(col!=t) {
        		System.out.println(-1);
        		return;
        	}
        	if(row!=t) {
        		System.out.println(-1);
        		return;
        	}
    	}

    	
    	//대각선 체크
    	long d1=0l;
    	long d2=0l;
    	for(int i=0;i<n;i++) {
    		d1+=array[i][i];
    		d2+=array[i][n-1-i];
    	}
    	
    	if(d1!=t) {
    		System.out.println(-1);
    		return;
    	}

       	if(d2!=t) {
    		System.out.println(-1);
    		return;
    	}
       	
       	System.out.println(rs);
    	
    	
    	

    	
  
    	


    }
}
