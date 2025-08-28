package loop;

public class Loop {

	public static void main(String[] args) {
		System.out.println(programming1());
	}
	
	// 1부터 100 사이의 정수 중에서 3 또는 4의 배수의 합을 계산
	public static int programming1() {
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 || i % 4 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}

}
