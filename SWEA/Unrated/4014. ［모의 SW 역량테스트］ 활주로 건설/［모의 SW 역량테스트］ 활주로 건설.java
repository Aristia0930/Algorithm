
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            List<List<Integer>> arr = new ArrayList<>();
            
          
            for (int i = 0; i < n; i++) {
                arr.add(new ArrayList<>());
            }
            
     
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }


            int count = 0;
            for (int i = 0; i < n; i++) {
                int check1 = 0;
                int check2=0;
                boolean[] v1 = new boolean[n];
                boolean[] v2 = new boolean[n];

                for (int j = 0; j < n - 1; j++) {
                    int n1 = arr.get(i).get(j);
                    int n2 = arr.get(i).get(j + 1);
                    int n3= arr.get(j).get(i);
                    int n4= arr.get(j+1).get(i);
                    
                    if (n1 != n2) {
       
                        if (Math.abs(n1 - n2) > 1) {
                            check1 = -1;
                        }

          
                        else if (n1 > n2) {

                            boolean canPlaceRamp = true;
                            for (int r = 0; r < x; r++) {
                             
                                if (j + 1 + r < n && arr.get(i).get(j + 1 + r) == n2 && !v1[j+1+r]) {
                                	v1[j+1+r]=true;
                                    continue;
                                } else {
                                    canPlaceRamp = false;
                                    
                                    break;
                                }
                            }
                            if (!canPlaceRamp) {
                                check1 = -1;
                            }
                        }
                 
                        else {
                            boolean canPlaceRamp = true;
                            for (int r = 0; r < x; r++) {
                     
                                if (j - r >= 0 && arr.get(i).get(j - r) == n1  && !v1[j-r]) {
                                	v1[j-r]=true;
                                	continue;
                                } else {
                                    canPlaceRamp = false;
                                    break;
                                }
                            }
                            if (!canPlaceRamp) {
                                check1 = -1;
                            }
                        }
                    }
                    
                    if (n3 != n4) {
                        
                        if (Math.abs(n3 - n4) > 1) {
                            check2 = -1;
                        }

          
                        else if (n3 > n4) {
                            boolean canPlaceRamp = true;
                            for (int r = 0; r < x; r++) {
                             
                                if (j + 1 + r < n && arr.get(j+1+r).get(i) == n4  && !v2[j+1+r]) {
                                	v2[j+1+r]=true;
                                	continue;
                                } else {
                                    canPlaceRamp = false;
                                    break;
                                }
                            }
                            if (!canPlaceRamp) {
                                check2 = -1;
                            }
                        }
                 
                        else {
                            boolean canPlaceRamp = true;
                            for (int r = 0; r < x; r++) {
                     
                                if (j - r >= 0 && arr.get(j-r).get(i) == n3 && !v2[j-r]) {
                                	v2[j-r]=true;
                                	continue;
                                    
                                    
                                } else {
                                    canPlaceRamp = false;
                                    break;
                                }
                            }
                            if (!canPlaceRamp) {
                                check2 = -1;
                            }
                        }
                    }
                }
                
                
                

                if (check1 == 0) {
                    count++;
                }
                if (check2 == 0) {
                    count++;
                }
            }
            
            System.out.println("#"+test+" "+count);
        }
    }
}
