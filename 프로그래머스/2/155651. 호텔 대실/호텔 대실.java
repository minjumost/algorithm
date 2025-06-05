import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        
        for(String[] book: book_time){
            String[] startTime = book[0].split(":");
            String[] endTime = book[1].split(":");
            
            int startMinutes = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            
            int endMinutes = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]) + 10;
            
            if(pq.isEmpty()){
                answer ++;
                pq.offer(new int[]{startMinutes, endMinutes});
                continue;
            }
            
            int[] prev = pq.poll();
            
            if(prev[1] <= startMinutes){
                pq.offer(new int[]{startMinutes, endMinutes});
            }
            else{
                answer ++;
                pq.offer(new int[]{startMinutes, endMinutes});
                pq.offer(prev);
            }
        }
        return answer;
    }
}