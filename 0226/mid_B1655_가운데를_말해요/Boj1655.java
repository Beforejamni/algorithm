package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj1655 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pqhigh=new PriorityQueue<>(Collections.reverseOrder());   //내림차순 젤 큰거 나옴
		PriorityQueue<Integer> pqlow=new PriorityQueue<>();	//오름차순 젤작은거 나옴
		
		for(int n=0;n<N;n++) {
			int num=Integer.parseInt(bf.readLine());
			
			if(pqhigh.size()==0) {
				pqhigh.offer(num);
			}
			else if(pqlow.size()==0) {
				if(pqhigh.peek()>num) {
					pqlow.offer(pqhigh.poll());
					pqhigh.offer(num);
				}else {
					pqlow.offer(num);
				}
				
			}
			else if(pqhigh.size()>pqlow.size()) {
				int highvalue=pqhigh.peek();
				if(highvalue>num) {
					pqlow.offer(pqhigh.poll());
					pqhigh.offer(num);
				}else {
					pqlow.offer(num);
				}
				
			}
			else {
				int	lowvalue=pqlow.peek();
				if(lowvalue<num) {
					pqhigh.offer(pqlow.poll());
					pqlow.offer(num);
				}else {
					pqhigh.offer(num);
				}
			}
			System.out.println(pqhigh.peek());
		}
		
	}
}
