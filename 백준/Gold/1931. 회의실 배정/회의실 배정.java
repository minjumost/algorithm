import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N;
    static Meeting[] meetings;


    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());

        meetings = new Meeting[N];


        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);

        int answer = 0;
        int end = 0;

        for(Meeting meeting: meetings){
            if(meeting.start >= end){
                answer ++;
                end = meeting.end;
            }
        }

        System.out.println(answer);

    }


    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o){
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}