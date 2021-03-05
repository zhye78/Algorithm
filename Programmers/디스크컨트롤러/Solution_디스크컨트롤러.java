import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int last = -1;
        int now = 0;
        int len = jobs.length;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        while(count < len){
            for(int[] job: jobs){
                if(last < job[0] && job[0] <= now){
                    answer += (now - job[0]);
                    q.add(job[1]);
                }
            }
            if(q.size() > 0){
                answer += (q.size() * q.peek());
                last = now;
                now += q.poll();
                count++;
            }else{
                now++;
            }
        }
        return (int)(answer / len);
    }
}