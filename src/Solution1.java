import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * ���� ����
�迭 bombs���� ������ź�� �� �� �Ŀ� ���������� ��ϵǾ� �ֽ��ϴ�. 
��ź �� ���� �����ϴ� �� 1�ʰ� �ɸ���, 
��ź�� ������ �ð��� ��ź ���Ÿ� �Ϸ��� �ð��� ������ ��ź�� ������ �ʽ��ϴ�. 
�� ��ź�� �ϳ��� ������, ������ ��ź�� ���ŵ� ��� ������ ������ �����մϴ�.

�������

bombs�� [3, 1, 2, 4]��� bombs[1], bombs[2], bombs[0], bombs[3]������ �����ؼ� 
4���� ��ź�� ������ �� �ֽ��ϴ�.
bombs�� [2, 2, 2, 2]��� � ������ �����ϴ��� 2���� ��ź�� ����(2�� �ҿ�)�� �Ŀ��� 
������ 2���� ��ź�� �����ϴ�.
�� ������ź�� ������ �ð��� ����ִ� �迭 bombs�� �Ű������� �־��� ��, 
������ �� �ִ� ��ź ������ �ִ��� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
������ź�� ������ 1 �̻�, 100,000 �����Դϴ�.
������ź�� ������ �ð��� 1 �̻�, 200,000������ �ڿ����Դϴ�.

solution
���� ��
for 1~N���� ���µ� i �̸��� ������ answer++
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
