import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, minLeft, minRight;
	static long minSum = Long.MAX_VALUE;
	static long[] liquids;
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		liquids = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquids[i] = Long.parseLong(st.nextToken());
		}
		
		int left = 0;
		int right = N - 1;
		
		while (left < right) {
			long sum = liquids[left] + liquids[right];
			
			if (Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				minLeft = left;
				minRight = right;
			}
			
			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				break;
			}
		}
		
		bw.write(liquids[minLeft] + " " + liquids[minRight]);
		bw.flush();
	}
}