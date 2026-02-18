package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630_Gyunghwan {
	static int N, countOne, countZero;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		countOne = 0;
		countZero = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		find(0, 0, N);
		System.out.println(countZero);
		System.out.println(countOne);
		

	}

	static void find(int r, int c, int size) {
		if (checkColor(r, c, size)) {
			// 모두 같은 색이라면 해당 색상 카운트 증가
			if (map[r][c] == 0) {
				countZero++;
			} else {
				countOne++;
			}
			return; 
		}

		
		int newSize = size / 2; // 절반 사이즈

		find(r, c, newSize); // 왼쪽 위
		find(r, c + newSize, newSize); // 오른쪽 위
		find(r + newSize, c, newSize); // 왼쪽 아래
		find(r + newSize, c + newSize, newSize); // 오른쪽 아래
	}

	static boolean checkColor(int r, int c, int size) {
		int color = map[r][c];

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
