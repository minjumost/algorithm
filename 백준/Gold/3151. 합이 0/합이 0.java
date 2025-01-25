import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] numbers;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        long answer =0;

        for(int i=0; i<N; i++){
            int left = i+1;
            int right = N-1;

            while(left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if(sum == 0){

                    if(numbers[left] == numbers[right]) {
                        int n = right - left + 1;
                        answer += (long) n * (n - 1) / 2;
                        break;
                    }

                    long leftCount = 1;
                    while(left < right && numbers[left] == numbers[left+1]){
                        left++;
                        leftCount++;
                    }

                    long rightCount = 1;
                    while(left < right && numbers[right] == numbers[right-1]){
                        right--;
                        rightCount++;
                    }

                    answer += (leftCount * rightCount);

                    left++;
                    right--;

                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        System.out.println(answer);


    }
}