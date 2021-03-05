import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        ArrayList<String> stack = new ArrayList<>();
        ArrayList<String> sub = new ArrayList<>();
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        stack.add(begin);
        int count;
        String word;
        
        if(!wordsList.contains(target)) return 0;
        
        while(wordsList.size() > 0){
            sub.clear();
            for(String s : stack){
                for(int w=0; w<wordsList.size(); w++){
                    count = 0;
                    word = wordsList.get(w);
                    for(int i=0; i<s.length(); i++){
                        if(s.charAt(i) != word.charAt(i)) count++;
                        if(count == 2) break;
                    }
                    if(count == 1){
                        sub.add(word);
                        wordsList.remove(word);
                        w--;
                    }
                }
            }
            answer++;
            if(sub.contains(target)) return answer;
            stack.clear();
            stack.addAll(sub);
        }
        
        return answer;
    }
}