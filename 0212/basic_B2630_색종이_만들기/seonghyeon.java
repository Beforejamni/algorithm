package samsung01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int n, bCnt, wCnt;
	static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        cut(0,0,n);
        System.out.println(wCnt);
        System.out.println(bCnt);
    }
    
    public static void cut(int x, int y, int size) {
    	if(size == 1) {
    		if(board[x][y] == 1) {
    			bCnt+=1;
    		}else wCnt+=1;
    		return;
    	}
    	int count = countBlue(x,y,size);
    	if(count == size*size) {
    		bCnt+=1;
    		return;
    	}else if(count == 0) {
    		wCnt+=1;
    		return;
    	}
    	
    	int nextSize = size/2;
    	cut(x,y,nextSize);
    	cut(x,y+nextSize, nextSize);
    	cut(x+nextSize, y, nextSize);
    	cut(x+nextSize, y+nextSize, nextSize);
    }
    
    private static int countBlue(int x, int y, int size) {
    	int cnt = 0;
    	
    	for(int i=x;i<x+size;i++) {
    		for(int j=y;j<y+size;j++) {
    			if(board[i][j] == 1) cnt++;
    		}
    	}
    	return cnt;
    }
}