import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * 문제 설명
각각의 용량이 a, b, c 리터인 비커가 있습니다. 다음 조건에 따라 d 리터를 만들고 싶습니다.

정해진 3개의 비커 이외에 다른 비커는 사용할 수 없습니다.
사용할 수 있는 액체의 양은 무한합니다.
비커에는 액체를 넘치지 않게 가득 채우거나 담겨있는 액체를 모두 버리는 행동만 가능하고, 동시에 할 수는 없습니다.
비커끼리 액체를 이동시킬 수 있고, 이 상황에서도 다른 비커를 넘치지 않게 완전히 채우던가, 넘치지 않는다면 지금 비커를 완전히 비우는 행동만 가능합니다.
한번에 한가지 행동만 할 수 있습니다.
d리터는 어느 비커에 담겨 있어도 상관이 없습니다.
비커의 용량 a, b, c와 만들어야 할 d리터가 매개변수로 주어질 때, d 리터를 만들기 위한 행동의 최소 횟수를 return 하는 solution 함수를 완성해주세요.

제한 사항
비커의 용량은 100 이하의 자연수입니다.
만들어야 할 용량 d는 100 이하의 자연수입니다.
만약 d 리터를 만들 수 없다면, -1을 return 해주세요.

solution
bfs?
d 리터를 만들 수 없는진 어떻게 판단?

 */
public class Solution3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		System.out.println(solution(arr[0], arr[1], arr[2], arr[3]));
	}

	public static int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] abc = {a, b, c};
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[a+1][b+1][c+1];
        queue.add(new int[] {a, 0, 0});
        queue.add(new int[] {0, b, 0});
        queue.add(new int[] {0, 0, c});
        visited[a][0][0] = true;
        visited[0][b][0] = true;
        visited[0][0][c] = true;
        while (!queue.isEmpty()) {
			answer++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				// d리터 있는지 검사 후 return answer
				for (int j = 0; j < 3; j++) {
					if (cur[j] == d) {
						return answer;
					}
				}
				// 행동1: 비커 1개 가득 채움
				for (int j = 0; j < 3; j++) {
					if (cur[j] == abc[j]) {
						continue;	// 꽈ㅣㄱ찼네
					}
					int[] next = new int[cur.length];
					System.arraycopy(cur, 0, next, 0, cur.length);
					next[j] = abc[j];
					if (!visited[next[0]][next[1]][next[2]]) {
						queue.add(next);
						visited[next[0]][next[1]][next[2]] = true;
					}
				}
				// 행동2: a > b로 액체 이동
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j == k) continue;
						int from = cur[j];					// from의 양
						int to = cur[k];
						int toRemaining = abc[k] - to; 	// to의 남은 공간
						int[] next = new int[cur.length];
						System.arraycopy(cur, 0, next, 0, cur.length);
						if (from <= toRemaining) {		// 받을 공간 넉넉
							next[k] = to + from;
							if (!visited[next[0]][next[1]][next[2]]) {
								queue.add(next);
								visited[next[0]][next[1]][next[2]] = true;
							}
						} else {						// 온전히 받지 못함
							next[j] = from - toRemaining;
							next[k] = abc[k];
							if (!visited[next[0]][next[1]][next[2]]) {
								queue.add(next);
								visited[next[0]][next[1]][next[2]] = true;
							}
						}
					}
				}
			}
		}
        return -1;
    }

}
