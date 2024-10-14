import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M, K;
	static Cell[][] map; // 기존의 map을 graph처럼 사용
	static int result;
	static PriorityQueue<Cell> pq; // 우선순위 큐 하나로 통합

	static int[][] dydx = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우 방향

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Cell[1000][1000]; // 세포 상태를 저장할 map
			result = 0;
			pq = new PriorityQueue<>((o1, o2) -> o2.maxtime - o1.maxtime); // maxtime 기준으로 우선순위 큐 생성

			// 초기 세포 배치
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						result++; // 초기 세포 개수 증가
						Cell cell = new Cell(life, i + 500, j + 500); // 중앙에 맞추기 위해 500을 더해줌
						map[i + 500][j + 500] = cell; // 세포를 map에 저장
						pq.add(cell); // 우선순위 큐에 추가
					}
				}
			}

			// K 시간 동안 진행
			for (int time = 0; time < K; time++) {
				PriorityQueue<Cell> newPq = new PriorityQueue<>((o1, o2) -> o2.maxtime - o1.maxtime);

				while (!pq.isEmpty()) {
					Cell cell = pq.poll();

					// 활성화된 세포 번식 처리
					if (cell.time == cell.maxtime && cell.live == 1) { // 활성화 상태일 때 번식
						for (int[] dir : dydx) {
							int ny = cell.y + dir[0];
							int nx = cell.x + dir[1];

							if (map[ny][nx] == null) { // 빈 칸에 새로운 세포 번식
								result++;
								Cell newCell = new Cell(cell.maxtime, ny, nx);
								map[ny][nx] = newCell;
								newPq.add(newCell);
							}
						}
					}

					// 시간 경과에 따른 세포 상태 변화
					cell.time--; // 남은 시간 감소
					if (cell.time == 0) {
						if (cell.live == 1) { // 활성화 상태에서 시간이 다 되면 죽음
							cell.live = 0;
							result--; // 죽은 세포는 결과에서 제외
						} else if (cell.live == 2) { // 비활성화 상태에서 활성화로 변경
							cell.live = 1;
							cell.time = cell.maxtime;
						}
					}

					// 아직 살아있는 세포는 큐에 다시 추가
					if (cell.live > 0) {
						newPq.add(cell);
					}
				}

				pq = newPq; // 큐 교체
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}

	// Cell 클래스
	static class Cell {
		int maxtime;
		int time;
		int live; // 2이면 비활성화, 1이면 활성화, 0이면 죽음
		int y;
		int x;

		Cell(int maxtime, int y, int x) {
			this.maxtime = maxtime;
			this.y = y;
			this.x = x;
			time = maxtime;
			live = 2; // 처음에는 비활성화 상태
		}
	}
}