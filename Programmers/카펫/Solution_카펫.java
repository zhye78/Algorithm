class Solution {
    public int[] solution(int brown, int yellow) {
        int[] arr = new int[2];
        for(int i=1; i<(int)yellow/2+2; i++){
            if(yellow%i == 0){
                if(2*i + 2*(yellow/i)+4 == brown){
                    arr[1] = yellow/i + 2;
                    arr[0] = i + 2;
                }
            }
        }
        return arr;
    }
}