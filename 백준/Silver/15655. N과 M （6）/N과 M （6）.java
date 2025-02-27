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
		List<Integer> ans = new ArrayList<Integer>();
		nm(m,-1,array,n,0,ans);
	}
	
	static void nm(int k,int now,int[] array,int n,int count,List<Integer> ans) {
		if (k==count) {
			for (int i=0; i<ans.size();i++) {
				System.out.print(ans.get(i)+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i =now+1; i<n;i++) {
				ans.add(array[i]);
				nm(k,i,array,n,count+1,ans);
				ans.remove(ans.size()-1);
			}
		}
	}

}