import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 문제 설명
배열 bombs에는 시한폭탄이 몇 초 후에 터지는지가 기록되어 있습니다. 
폭탄 한 개를 제거하는 데 1초가 걸리며, 
폭탄이 터지는 시간과 폭탄 제거를 완료한 시간이 같더라도 폭탄은 터지지 않습니다. 
또 폭탄이 하나라도 터지면, 나머지 폭탄의 제거도 모두 실패한 것으로 간주합니다.

예를들어

bombs가 [3, 1, 2, 4]라면 bombs[1], bombs[2], bombs[0], bombs[3]순으로 제거해서 
4개의 폭탄을 제거할 수 있습니다.
bombs가 [2, 2, 2, 2]라면 어떤 순서로 제거하더라도 2개의 폭탄을 제거(2초 소요)한 후에는 
나머지 2개의 폭탄은 터집니다.
각 시한폭탄이 터지는 시간이 들어있는 배열 bombs가 매개변수로 주어질 때, 
제거할 수 있는 폭탄 개수의 최댓값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
시한폭탄의 개수는 1 이상, 100,000 이하입니다.
시한폭탄이 터지는 시간은 1 이상, 200,000이하인 자연수입니다.

solution
정렬 후
for 1~N까지 도는데 i 미만일 때까지 answer++
 */
public class Solution1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		int[] bombs = new int[N];
		for (int i = 0; i < N; i++) {
			bombs[i] = Integer.parseInt(line[i]);
		}
		System.out.println(solution(bombs));
	}
	public static int solution(int[] bombs) {
        int answer = 0;
        Arrays.sort(bombs);
        for (int time = 0; time < bombs.length; time++) {
			if (time + 1 > bombs[time]) {
				break;
			}
			answer++;
		}
        return answer;
    }
}
