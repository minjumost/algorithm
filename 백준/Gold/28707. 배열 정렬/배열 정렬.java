import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A;
    static List<Operation> operations;
    static Map<String, Integer> costMap;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        A = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        M = Integer.parseInt(bufferedReader.readLine());

        operations = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int l = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int r = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int c = Integer.parseInt(stringTokenizer.nextToken());
            operations.add(new Operation(l, r, c));
        }

        System.out.println(solve());
    }

    static int solve() {
        String initialState = arrayToString(A);
        int[] sortedArray = A.clone();
        Arrays.sort(sortedArray);
        String sortedState = arrayToString(sortedArray);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        costMap = new HashMap<>();
        pq.offer(new State(initialState, 0));
        costMap.put(initialState, 0);

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.state.equals(sortedState)) {
                return current.cost;
            }

            for (Operation op : operations) {
                String nextState = applyOperation(current.state, op);
                int nextCost = current.cost + op.c;

                if (!costMap.containsKey(nextState) || costMap.get(nextState) > nextCost) {
                    costMap.put(nextState, nextCost);
                    pq.offer(new State(nextState, nextCost));
                }
            }
        }

        return -1;
    }

    static String applyOperation(String state, Operation op) {
        String[] parts = state.substring(1, state.length() - 1).split(", ");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        int temp = array[op.l];
        array[op.l] = array[op.r];
        array[op.r] = temp;

        return arrayToString(array);
    }

    static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    static class Operation {
        int l, r, c;

        public Operation(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    static class State {
        String state;
        int cost;

        public State(String state, int cost) {
            this.state = state;
            this.cost = cost;
        }
    }
}