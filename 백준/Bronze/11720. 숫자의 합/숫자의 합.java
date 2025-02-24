import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String nums=br.readLine();
		int sum=0;
		for (int i=0;i<nums.length();i++) {
			sum+=nums.charAt(i)-'0';
		}
		System.out.println(sum);

	}

}