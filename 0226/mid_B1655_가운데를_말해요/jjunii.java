package boj;

import java.io.*;
import java.util.*;

public class Boj1655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (i % 2 == 0) {
				maxHeap.add(x);
			} else {
				minHeap.add(x);
			}
			
			if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}
			
			sb.append(maxHeap.peek()).append('\n');
		}
		System.out.println(sb);
	}
}
