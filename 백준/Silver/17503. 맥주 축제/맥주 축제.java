import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N; // 날짜
    static int M; // 선호도의 합
    static int K; // 맥주 종류수
    static Beer[] beers;
    static Queue<Beer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        beers = new Beer[K];

        for(int i=0; i<K; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int like = Integer.parseInt(stringTokenizer.nextToken());
            int alchol = Integer.parseInt(stringTokenizer.nextToken());

            Beer beer = new Beer(like, alchol);
            beers[i] = beer;
        }

        Arrays.sort(beers, (o1, o2) ->{
            if(o1.alchol == o2.alchol){
                return o2.like - o1.like;
            }
            return o1.alchol - o2.alchol;
        });

        int likeSum = 0;
        int answer = 0;


        for(Beer beer: beers){
            likeSum += beer.like;

            queue.add(beer);

            if(queue.size() > N){
                Beer poll = queue.poll();
                likeSum -= poll.like;

            }

            if(queue.size() == N && likeSum >= M){
                answer = beer.alchol;
                break;
            }
        }

        if(queue.size() == N && likeSum >= M){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }

    }


    static class Beer implements Comparable<Beer>{
        int like;
        int alchol;

        public Beer(int like, int alchol){
            this.like = like;
            this.alchol = alchol;
        }

        @Override
        public String toString(){
            return "like: " + like + " alchol: " + alchol + "\n";
        }

        @Override
        public int compareTo(Beer o) {
            return this.like - o.like;
        }
    }


    }