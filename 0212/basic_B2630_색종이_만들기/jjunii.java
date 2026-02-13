package boj;

import java.io.*;
import java.util.*;

public class Boj2630 {

	static int N, white = 0, blue = 0;
	static int[][] paper;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		search(0, 0, N);
		
		System.out.println(white + "\n" + blue);
	}
	
	static void search(int x, int y, int size) {		// (x, y): 좌상단 시작점
		int color = paper[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] != color) {
					size /= 2;
					search(x, y, size);					// 1사분면
					search(x, y + size, size);			// 2사분면
					search(x + size, y, size);			// 3사분면
					search(x + size, y + size, size);	// 4사분면
					return;
				}
			}
		}
		
		if (color == 0) {
			white++;
		} else {
			blue++;
		}
	}
}
