class Solution {
    
    static int N;
    static int T;
    static int[] numberList;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {

        N = numbers.length;
        T = target; 
        numberList = numbers;
        
        dfs(0, 0);
        return answer;
    }
    
    static void dfs(int depth, int sum){
        if(depth == N){
            
            if(sum == T){
                answer ++;
            }
            return;
        }
        
        dfs(depth + 1, sum + numberList[depth]);
        dfs(depth + 1, sum - numberList[depth]);
    }
}