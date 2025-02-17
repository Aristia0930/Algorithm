//////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0; i<10;i++) {
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int count = st.countTokens();
			int[] array=new int[count];
			
			for(int j=0; j<count;j++) {
				array[j]=Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<n;j++) {
				Arrays.sort(array);
				array[0]+=1;
				array[count-1]-=1;
			}
			Arrays.sort(array);
			System.out.printf("#%d %d\n",i+1,array[count-1]-array[0]);
			
			
			
		}
	}
}