import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * ���� ����
�����÷��̽� OO ���������� ���� �̺�Ʈ�� ���� �� �� ���� ���Ƿ� ������ 
Ŀ�� ���� ������ �߼��մϴ�. 
�迭 arr���� ������ ID�� �̺�Ʈ�� ��÷�� ������� ���������, 
�� ���� ID�� �ڿ����Դϴ�. ������ ��÷�� �� ��, 
���� ���� �ߺ����� ��÷�� ���� ��ĥ ���� �ߺ� ��÷�ƴ����� return �ϵ���
 solution �Լ��� �ۼ��ϼ���.
��, �ߺ����� ��÷�� ���� ���� ��� -1�� return �ϼ���.

���ѻ���
�迭�� ���̴� 1 �̻� 100,000 �����Դϴ�.
�迭�� ���Ҵ� 1 �̻� 1,000,000,000 ������ �ڿ����Դϴ�.

solution
int[][] again = new int[1000000000][2]; �� ����� �ߺ��Ǵ� ���� �ִ��� �ľ� �� ���� idx ���� ���
for���� �� ���Ҵٸ� -1 ���
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
			if (indexMap.containsKey(curNum)) {	// �ߺ� ��÷
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
