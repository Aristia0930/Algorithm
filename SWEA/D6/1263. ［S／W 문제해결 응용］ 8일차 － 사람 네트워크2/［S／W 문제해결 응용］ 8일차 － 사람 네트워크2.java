
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int t= Integer.parseInt(st.nextToken());
		
		for (int test=0; test<t;test++) {
			st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int node= Integer.parseInt(st.nextToken());
					if(i!=j && node==0) {
						node=1000000;
					}
					arr[i][j]=node;
					
				}
			
				
			}
			
			for(int k=0 ; k<n;k++ ) {
				for (int i=0; i<n;i++) {
					for (int j =0; j<n;j++) {
						arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
						
					}
				}
			}
			int ans =Integer.MAX_VALUE;
			for (int i=0; i<n;i++) {
				int count=0;
				for (int j =0; j<n;j++) {
					if(arr[i][j]<1000000) {
						count+=arr[i][j];
					}

				}

				ans=Math.min(ans,count);
			}
			
			System.out.println("#"+(test+1)+" "+ans);
		}
	}


}