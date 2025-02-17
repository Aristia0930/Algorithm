
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0; i<10;i++) {
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int[] array=new int[n];
			
			for(int j=0; j<n;j++) {
				array[j]=Integer.parseInt(st.nextToken());
			}
			int ans=0;
			for(int j=2;j<n-2;j++) {
				int v1=array[j-2];
				int v2=array[j-1];
				int v=array[j];
				int v3=array[j+1];
				int v4=array[j+2];
				
				int rs=0;
				if(v1>rs) {
					rs=v1;
				}
				if(v2>rs) {
					rs=v2;
				}
				if(v3>rs) {
					rs=v3;
				}
				if(v4>rs) {
					rs=v4;
				}
				if(rs<v) {
				ans+=v-rs;
				}
				
			}
			
			System.out.printf("#%d %d\n",i+1,ans);
			

		}

	}
	
}
