import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        int j = people.length-1;
        Arrays.sort(people);
        
        while(i <= j){
            answer++;
            if(people[i] + people[j] <= limit)
                i++;
            j--;
        }
        return answer;
    }
}