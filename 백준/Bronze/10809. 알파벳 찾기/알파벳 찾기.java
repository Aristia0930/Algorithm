

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		String s=sc.next();
		
        String[] word = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
        
    
        HashMap<String, Integer> words = new HashMap<>();
        
       
        for (int i = 0; i < word.length; i++) {
            words.put(word[i], -1); 
        }
		for(int i=0; i<s.length();i++) {
			Character c=s.charAt(i);
			if (words.get(c.toString())==-1) {
				words.put(c.toString(),i);
			}
		}
		
		for(int i=0;i<word.length;i++) {
			System.out.print(words.get(word[i]));
			System.out.print(" ");
		}

		
	

	}

}
