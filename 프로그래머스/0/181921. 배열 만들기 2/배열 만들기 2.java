import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String number = String.valueOf(i);
            boolean check = true;
            for (int j = 0; j < number.length(); j++) {
                if (number.charAt(j) != '0' && number.charAt(j) != '5') {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer.add(i);
            }
        }
        
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        
        return answer;
    }
}
