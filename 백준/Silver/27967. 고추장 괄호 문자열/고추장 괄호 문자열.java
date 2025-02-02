import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	static String[] arr;
	static String ans;
	static boolean check=false;
	
	public static void dfs(int n,int ps,int val,String s ) {
		if(val<0 || ps>n) {
			return;
		}
		if(ps==n && val==0&& !check) {
			ans=s;
			check=true;
			return;
		}
		if(ps==0) {
			dfs(n, ps+1, val+1, s+"(");
		}
		else if (ps < n) {
			if(arr[ps].equals("G")) {
				dfs(n, ps+1, val+1, s+"(");
				dfs(n, ps+1, val-1, s+")");
			}
			else {
				if(arr[ps].equals("(")) {
					dfs(n, ps+1, val+1, s+"(");
				}else {
					dfs(n, ps+1, val-1, s+")");
				}

			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		arr=br.readLine().split("");
		dfs(n, 0, 0, "");
		pw.println(ans);
		pw.flush();
		
 		
		

	}

}