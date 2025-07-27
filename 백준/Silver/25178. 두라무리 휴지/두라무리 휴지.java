import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;
    private String s1, s2;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        s1 = br.readLine();
        s2 = br.readLine();

        System.out.println((stringResort() && charMatch() && removeVowel()) ? "YES" : "NO");
    }

    // 한 단어를 재배열해 다른 단어를 만들 수 있어야 함
    public boolean stringResort() {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2); 
    }

    // 두 단어의 첫글자와 마지막 글자는 서로 동일해야 함
    public boolean charMatch() {
        return s1.charAt(0) == s2.charAt(0) && s1.charAt(n - 1) == s2.charAt(n - 1);
    }

    // 모음을 제거한 문자열은 동일해야 함
    public boolean removeVowel() {
        String replacS1 = s1.replaceAll("[aeiou]", ""); 
        String replacS2 = s2.replaceAll("[aeiou]", "");

        return replacS1.equals(replacS2);
    }

}