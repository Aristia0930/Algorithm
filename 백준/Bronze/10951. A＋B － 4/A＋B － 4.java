import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException  {

		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input=br.readLine();
			if( input == null) {
				break;
			}
			
			StringTokenizer st= new StringTokenizer(input);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
				
			System.out.println(a+b);
		}
		

	}
}