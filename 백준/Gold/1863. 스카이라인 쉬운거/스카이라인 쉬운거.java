import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            // 처음에 0이 들어올 수 있음
            if(y == 0) {
                answer += stack.size();
                stack.clear();
                continue;
            }

            // 스택이 비어있으면 push
            if(stack.isEmpty()){
                stack.push(y);
                continue;
            }

            // 높이가 높아지면 push
            if(stack.peek() < y){
                stack.push(y);
                continue;
            }

            // 높이가 낮아지면 
            if(stack.peek() > y){

                // 변곡점보다 높은 건물들 pop
                while(!stack.isEmpty() && stack.peek() > y){
                    stack.pop();
                    answer ++;
                }

                // 스택이 비면 해당 변곡점이 새로운 건물이 됨
                if(stack.isEmpty()){
                    stack.push(y);
                }

                // 남아있는 건물보다 높으면 새로운 건물이 됨
                else if(stack.peek() < y){
                    stack.push(y);
                }

                continue;
            }     
        }

        answer += stack.size();

        System.out.println(answer);
    }
}