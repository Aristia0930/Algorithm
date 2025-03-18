

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
		
		int t=Integer.parseInt(st.nextToken());
		for (int test=1;test<t+1;test++) {

			st= new StringTokenizer(br.readLine());
			int find=Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			String word=st.nextToken();
			
			Set<String> arr = new TreeSet<>(); 
			int len=word.length();
			for(int i=1;i<=len;i++) {
				for(int j =0; j<=len-i;j++) {
					arr.add(word.substring(j,j+i));
					
				}



			}
			 List<String> sortedArr = new ArrayList<>(arr);
			if (arr.size()>=find-1) {
			System.out.println("#"+test+" "+sortedArr.get(find-1));
			}
			else {
				System.out.println("#"+test+" none");
			}
		
		}
	}


}