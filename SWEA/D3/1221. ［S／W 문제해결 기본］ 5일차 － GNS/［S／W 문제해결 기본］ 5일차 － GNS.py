import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.*;
public class Solution {

	
	
	public static void main(String[] args) throws IOException{
		Map<String, Integer> dic = new HashMap<String, Integer>();
		
		dic.put("ZRO", 0);
		dic.put("ONE", 1);
		dic.put("TWO", 2);
		dic.put("THR", 3);
		dic.put("FOR", 4);
		dic.put("FIV", 5);
		dic.put("SIX", 6);
		dic.put("SVN", 7);
		dic.put("EGT", 8);
		dic.put("NIN", 9);
		
		Map<Integer, String> dic2 = new HashMap<Integer, String>();
		
		dic2.put(0, "ZRO");
		dic2.put(1, "ONE");
		dic2.put(2, "TWO");
		dic2.put(3, "THR");
		dic2.put(4, "FOR");
		dic2.put(5, "FIV");
		dic2.put(6, "SIX");
		dic2.put(7, "SVN");
		dic2.put(8, "EGT");
		dic2.put(9, "NIN");
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		
		for(int test=0;test<t;test++) {
		
			st= new StringTokenizer(br.readLine());
			String n=st.nextToken();
			int k=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			List<Integer> num=new ArrayList<>();
			for(int i=0;i<k;i++) {
				num.add(dic.get(st.nextToken()));
			
		}
		
		num.sort(null);
		StringBuilder sb= new  StringBuilder();
		for(int i=0;i<k;i++) {
			sb.append(dic2.get(num.get(i)));
			sb.append(" ");
			
		}
		System.out.println(n);
		System.out.println(sb);
		}
		
		
		
		

}
}