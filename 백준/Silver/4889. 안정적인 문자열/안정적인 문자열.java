import java.util.*;

public class Main{
    public int solution(String s){
        int open = 0;
        int close = 0;
        
        for(char c: s.toCharArray()){
            if(c == '{'){
                open ++;
            }    
            else{
                if(open > 0){
                    open --;
                }
                else{
                    close ++;
                }
            }
        }
        return open/2 + open%2 + close/2 + close%2;
    }
    
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);    
        List<String> inputs = new ArrayList<>();
        
        while(true){
            String str = sc.nextLine();
            if(str.charAt(0) == '-'){
                break;
            }
            inputs.add(str);
        }
        
        for(int i=1; i<= inputs.size(); i++){
            System.out.print(i+". ");
            System.out.println(T.solution(inputs.get(i-1)));
        }
    }
}