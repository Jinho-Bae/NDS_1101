import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * ���� ����
������ �뷮�� a, b, c ������ ��Ŀ�� �ֽ��ϴ�. ���� ���ǿ� ���� d ���͸� ����� �ͽ��ϴ�.

������ 3���� ��Ŀ �̿ܿ� �ٸ� ��Ŀ�� ����� �� �����ϴ�.
����� �� �ִ� ��ü�� ���� �����մϴ�.
��Ŀ���� ��ü�� ��ġ�� �ʰ� ���� ä��ų� ����ִ� ��ü�� ��� ������ �ൿ�� �����ϰ�, ���ÿ� �� ���� �����ϴ�.
��Ŀ���� ��ü�� �̵���ų �� �ְ�, �� ��Ȳ������ �ٸ� ��Ŀ�� ��ġ�� �ʰ� ������ ä�����, ��ġ�� �ʴ´ٸ� ���� ��Ŀ�� ������ ���� �ൿ�� �����մϴ�.
�ѹ��� �Ѱ��� �ൿ�� �� �� �ֽ��ϴ�.
d���ʹ� ��� ��Ŀ�� ��� �־ ����� �����ϴ�.
��Ŀ�� �뷮 a, b, c�� ������ �� d���Ͱ� �Ű������� �־��� ��, d ���͸� ����� ���� �ൿ�� �ּ� Ƚ���� return �ϴ� solution �Լ��� �ϼ����ּ���.

���� ����
��Ŀ�� �뷮�� 100 ������ �ڿ����Դϴ�.
������ �� �뷮 d�� 100 ������ �ڿ����Դϴ�.
���� d ���͸� ���� �� ���ٸ�, -1�� return ���ּ���.

solution
bfs?
d ���͸� ���� �� ������ ��� �Ǵ�?

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
				// d���� �ִ��� �˻� �� return answer
				for (int j = 0; j < 3; j++) {
					if (cur[j] == d) {
						return answer;
					}
				}
				// �ൿ1: ��Ŀ 1�� ���� ä��
				for (int j = 0; j < 3; j++) {
					if (cur[j] == abc[j]) {
						continue;	// �ʤӤ�á��
					}
					int[] next = new int[cur.length];
					System.arraycopy(cur, 0, next, 0, cur.length);
					next[j] = abc[j];
					if (!visited[next[0]][next[1]][next[2]]) {
						queue.add(next);
						visited[next[0]][next[1]][next[2]] = true;
					}
				}
				// �ൿ2: a > b�� ��ü �̵�
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j == k) continue;
						int from = cur[j];					// from�� ��
						int to = cur[k];
						int toRemaining = abc[k] - to; 	// to�� ���� ����
						int[] next = new int[cur.length];
						System.arraycopy(cur, 0, next, 0, cur.length);
						if (from <= toRemaining) {		// ���� ���� �˳�
							next[k] = to + from;
							if (!visited[next[0]][next[1]][next[2]]) {
								queue.add(next);
								visited[next[0]][next[1]][next[2]] = true;
							}
						} else {						// ������ ���� ����
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
