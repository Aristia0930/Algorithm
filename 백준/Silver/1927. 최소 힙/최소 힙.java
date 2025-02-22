import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q=new PriorityQueue<>();
		
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				if(q.size()==0) {
					System.out.println(0);
				}
				else {
				System.out.println(q.poll());
				}
			}
			else {
				q.add(n);
			}
		}
		

	}

}
