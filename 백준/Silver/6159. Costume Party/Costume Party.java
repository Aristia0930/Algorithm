import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		String[] inputData=br.readLine().split(" ");
		int n=Integer.parseInt(inputData[0]);
		int s=Integer.parseInt(inputData[1]);
		int[] arr=new int[n];
		
		for (int i=0; i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int left=0;
		int count=0;
		while(left<n) {
			for(int right=left+1;right<n;right++) {
				if(right<n && arr[left]+arr[right]<=s) {
					count++;
				}
				
			}
			left++;
		}
		pw.println(count);
		pw.flush();
		pw.close();
		br.close();

	}

}