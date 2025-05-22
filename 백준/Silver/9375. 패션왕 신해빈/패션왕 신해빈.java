import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test_case = 1;test_case <= T;test_case++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();
                map.put(str2, map.getOrDefault(str2, 0) + 1);
            }
            int result = 1;
           
            for(int a : map.values()) {
            	result = result * (a + 1);
            }
            System.out.println(result - 1);
        }
    }
}
