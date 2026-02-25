package boj;

import java.io.*;
import java.util.*;

public class Boj16235 {
	
	static int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	
	static int N, M, K;
	static int[][] ground, add;
	static Deque<Tree> trees = new ArrayDeque<>();
	static List<Tree> deads = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ground = new int[N][N];
		add = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Tree> init = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
		
			init.add(new Tree(x, y, z));
		}
		init.sort(Comparator.comparing((Tree t) -> t.age));
		
		for (Tree tree : init) {
			trees.offer(tree);
		}
		
		for (int i = 0; i < K; i++) {
			simulation();
		}
		
		System.out.println(trees.size());
	}
	
	static void simulation() {
		// 봄
		int size = trees.size();
		for (int i = 0; i < size; i++) {
			Tree tree = trees.pollFirst();
			if (tree.age <= ground[tree.x][tree.y]) {
				ground[tree.x][tree.y] -= tree.age;
				tree.age++;
				trees.offerLast(tree);
			} else {
				deads.add(tree);
			}
		}

		// 여름
		for (Tree dead : deads) {
			ground[dead.x][dead.y] += dead.age / 2;
		}
		deads.clear();
		
		// 가을
		List<Tree> news = new ArrayList<>();
		for (Tree tree : trees) {
			if (tree.age % 5 != 0) {
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int nx = tree.x + dir[i][0];
				int ny = tree.y + dir[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				news.add(new Tree(nx, ny, 1));
			}
		}
		
		for (Tree newTree : news) {
			trees.offerFirst(newTree);
		}
		
		// 겨울
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ground[i][j] += add[i][j];
			}
		}
	}
	
	static class Tree {
		int x;
		int y;
		int age;
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

}
