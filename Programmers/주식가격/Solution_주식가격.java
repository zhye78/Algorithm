class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int count;
        for(int i=0;i<len-1;i++){
            count = 0;
            for(int j=i+1;j<len;j++){
                count++;
                if(prices[i] > prices[j])
                    break;
            }
            answer[i] = count;
        }
        return answer;
    }
}