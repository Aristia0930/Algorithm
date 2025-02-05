import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		BigInteger  i= new BigInteger(sn.next(),2);
        BigInteger result = i.multiply(BigInteger.valueOf(17));
        System.out.println(result.toString(2));

	}
}