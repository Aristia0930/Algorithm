import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, K;
	static final int maxL = 100_001;
	static int[] location = new int[maxL];
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
		return o1[1] - o2[1];
	});
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < maxL; i++) {
			location[i] = -1;
		}
		
		pq.offer(new int[] {N, 0});
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int subin = now[0];
			int time = now[1];
			
			if (subin == K) {
				location[subin] = time;
				break;
			}
			
			if (location[subin] != -1) {
				continue;
			} else {
				location[subin] = time;
			}
			
			if (subin - 1 >= 0) {
				pq.offer(new int[] {subin - 1, time + 1});
			}
			if (subin + 1 < maxL) {
				pq.offer(new int[] {subin + 1, time + 1});
			}
			if (subin * 2 < maxL) {
				pq.offer(new int[] {subin * 2, time});
			}
		}
		
		bw.write(location[K] + "");
		bw.flush();
	}
}