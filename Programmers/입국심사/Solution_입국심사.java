import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min = 1;
        long max = Long.valueOf(times[times.length-1]) * Long.valueOf(n);
        long mid;
        long count;
        
        while(min <= max){
            mid = (min + max) / 2;
            System.out.println(mid);
            count = 0;
            for(int t : times) count += (mid / t);
            if(count < n)
                min = mid + 1;
            else{
                answer = mid;
                max = mid - 1;
            }
        }
        return answer;
    }
}