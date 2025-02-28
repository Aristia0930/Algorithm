import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String name = sc.next();
		
		
		String ans="";
		int count=0;
		
		for (int i =0 ; i<name.length();i++) {
			if (!ans.contains(String.valueOf(name.charAt(i)))) {
				ans+=name.charAt(i);
			}
			else {
				count++;
			}
			
		}

		ans+=(count+4);
		
		
		ans=(1906+num)+ans;
		
		
		
		StringBuilder sb= new StringBuilder(ans);
		sb.reverse();
	
		sb.insert(0, "smupc_");
		System.out.println(sb);

	}

}
