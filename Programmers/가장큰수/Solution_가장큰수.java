import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] arr = new String[len];
        for(int i=0;i<len;i++)
            arr[i] = Integer.toString(numbers[i]);
        Arrays.sort(arr,
                   (o1, o2) -> {return -Integer.compare(Integer.parseInt(o1+o2), Integer.parseInt(o2+o1));});
        if(arr[0].equals("0"))
            answer = "0";
        else
            for(String s: arr)
                answer += s;
        return answer;
    }
}