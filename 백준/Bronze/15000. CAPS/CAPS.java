import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<str.length();i++) {
        	sb.append((char)(str.charAt(i) - 32));
        }
        System.out.println(sb);
    }
}
