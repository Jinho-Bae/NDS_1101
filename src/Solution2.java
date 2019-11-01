import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 문제 설명
투썸플레이스 OO 지점에서는 사은 이벤트로 매일 고객 한 명을 임의로 선정해 
커피 무료 쿠폰을 발송합니다. 
배열 arr에는 고객들의 ID가 이벤트에 당첨된 순서대로 들어있으며, 
각 고객의 ID는 자연수입니다. 쿠폰에 당첨된 고객 중, 
가장 빨리 중복으로 당첨된 고객은 며칠 만에 중복 당첨됐는지를 return 하도록
 solution 함수를 작성하세요.
단, 중복으로 당첨된 고객이 없는 경우 -1을 return 하세요.

제한사항
배열의 길이는 1 이상 100,000 이하입니다.
배열의 원소는 1 이상 1,000,000,000 이하의 자연수입니다.

solution
int[][] again = new int[1000000000][2]; 를 만들고 중복되는 것이 있는지 파악 후 전후 idx 차이 출력
for문을 다 돌았다면 -1 출력
 */
public class Solution2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer = Integer.MAX_VALUE;
	    Map<Integer, Integer> indexMap = new HashMap<>(); 
		boolean again = false;
		for (int i = 0; i < arr.length; i++) {
			int curNum = arr[i];
			if (indexMap.containsKey(curNum)) {	// 중복 당첨
				System.out.println("curNum: " + curNum + "i: " + i);
				again = true;
				int curGap = i - indexMap.get(curNum);
				if (curGap < answer) {
					answer = curGap;
				}
				indexMap.replace(curNum, i);
		      } else {
		        indexMap.put(curNum, i);
		      }
		}
		return again ? answer : -1;
	}

}
