import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int sum_value=0;
		
		for (int i=0;i<5;i++) {
			int j=Integer.parseInt(st.nextToken());
			sum_value+=j*j;
			
			
		}
		
		System.out.println(sum_value%10);
		
	

	}

}
