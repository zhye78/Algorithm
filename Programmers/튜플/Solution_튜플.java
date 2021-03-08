import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        s = s.substring(2, s.length() - 1);
        String[] arr = s.split(",\\{");
        int[] answer = new int[arr.length];
        
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        for(int i=0; i<arr.length; i++)
            arr[i] = arr[i].substring(0, arr[i].length()-1);
        //System.out.println(Arrays.toString(arr));
        
        for(int i=0; i<arr.length; i++){
            String[] sub = arr[i].split(",");
            //System.out.println(Arrays.toString(sub));
            for(String j : sub){
                int num = Integer.parseInt(j);
                //System.out.println(num);
                if(!list.contains(num))
                    list.add(num);
            }
            //System.out.println("list: " + list);
        }
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}