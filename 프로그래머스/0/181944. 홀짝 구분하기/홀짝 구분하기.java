import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans=" is odd";
        if (n%2==0){
            ans=" is even";
        }
        System.out.println(n+ans);
    }
}