import java.util.*;

class Solution {
    
    public int[][] rotation(int[][] arr, int len){
        int[][] newArr = new int[len][len];
        
        for(int i=0; i<len; i++){
            int[] addArr = new int[len];
            for(int j=0; j<len; j++){
                addArr[j] = arr[len-j-1][i];
            }
            newArr[i] = addArr;
        }
        
        return newArr;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int keyLen = key.length;
        int lockLen = lock.length;
        int start = lockLen - 1; //extendList에서 lock부분의 시작인덱스
        int end = start + lockLen; //extendList에서 lock부분의 종료인덱스
        boolean breaker = false;
        int count = 0;
        int lockCnt = 0;
        
        int[][] extendList = new int[lockLen * 3 - 2][lockLen * 3 - 2];
        //////extendList, lockCnt 초기화/////
        for(int i=0; i<lockLen; i++){
            for(int j=0; j<lockLen; j++){
                extendList[i + start][j + start] = lock[i][j];
                if(lock[i][j] == 0) lockCnt++;
            }
        }
        
        //lock이 다 1일때 true 리턴
        if(lockCnt == 0) return true;
        
        for(int r=0; r<4; r++){
            for(int i=0; i<end; i++){
                for(int j=0; j<end; j++){
                    breaker = false;
                    count = 0;
                    for(int a=0; a<keyLen; a++){
                        for(int b=0; b<keyLen; b++){
                            if(key[a][b] == 1 && extendList[i + a][j + b] == 1){
                                breaker = true;
                                break;
                            }
                            //만약 둘다 0이면 lock 범위 내인지 확인
                            else if(key[a][b] == 0 && extendList[i + a][j + b] == 0){
                                if(start <= i + a && i + a < end && start <= j + b && j + b < end){
                                    breaker = true;
                                    break;
                                }
                            }
                            else if(key[a][b] == 1 && extendList[i + a][j + b] == 0){
                                if(start <= i + a && i + a < end && start <= j + b && j + b < end){
                                    count++;
                                }
                            }
                        }
                        if(breaker) break;
                        if(count == lockCnt) return true;
                    }
                }
            }
            if(count == lockCnt) return true;
            key = rotation(key, keyLen);
        }
        
        //for(int[] arr: rotation(key, key.length))
            //System.out.println(Arrays.toString(arr));
        return answer;
    }
}