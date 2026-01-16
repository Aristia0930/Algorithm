import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        
        List<String> array=new ArrayList<>(Arrays.asList(str_list));
        int l=array.indexOf("l");
        int r=array.indexOf("r");
        
        List<String> list;
        if(l!=-1 && r!=-1){
            if(l<r){
                list=array.subList(0,l);
            }else{
                list=array.subList(r+1,array.size());
            }
        }else if(l==-1 && r!=-1){
            list=array.subList(r+1,array.size());
        }
        
        else if(r==-1 && l!=-1){
            list=array.subList(0,l);
        }else{
            list = Collections.emptyList();  
        }
   
        

        
        
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}