import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int[] array = new int[n];
		st= new StringTokenizer(br.readLine());
		for (int i=0 ;i<n;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		
		nm(m,0,array,n,0,sb,new int[m]);
		System.out.print(sb.toString());
	}
	
	static void nm(int k,int now,int[] array,int n,int count,StringBuilder ans,int[] rs) {
		if (k==count) {
//			System.out.println("통과");
			for(int i=0; i<k;i++) {
				ans.append(rs[i]+" ");
			}
			ans.append("\n");
			return;
		}
		else {
			for(int i =0; i<n;i++) {
				rs[count]=array[i];
				nm(k,i,array,n,count+1,ans,rs);
				

			}
		}
	}

}