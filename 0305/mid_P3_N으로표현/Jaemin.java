// package 0305.mid_P3_N으로표현;
import java.util.*;
import java.util.logging.LogManager;

public class Jaemin {
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }
      static int solution(int N, int number) {
     List<Set<Integer>> dp = new ArrayList<>();
		
		for(int i = 0; i <= 8; i++) {
			dp.add(new HashSet<>());
		}
		
		int baseNumber = N;
		for(int i = 1; i <= 8; i++) {
			dp.get(i).add(baseNumber);
			baseNumber = baseNumber * 10 + N;
		}
		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j < i; j++) {
				for(int a : dp.get(j)) {
					for(int b : dp.get(i -j)) {
						dp.get(i).add(a + b);
						dp.get(i).add(a - b);
						dp.get(i).add(a * b);
						if(b != 0)dp.get(i).add(a /b);
					}
				}
			}
		}
		
		for(int i = 1; i <= 8; i++) {
			if(dp.get(i).contains(number)) return i;
		}
		
		return -1;
    }
}
