import java.util.*;



public class Main{
    
    public void solution(int[] numbers){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int x: numbers){
            if(x > max){
                max = x;
            }
            if(x < min){
                min = x;
            }
        }
        System.out.print(min);
        System.out.print(" ");
        System.out.print(max);
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i< n; i++){
            numbers[i] = sc.nextInt();
        }
        T.solution(numbers);
        
    }
}