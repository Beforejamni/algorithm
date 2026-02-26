package progrmmers;

import java.util.*;

class Solution {

    int[] stones;
    int k;
    
    public int solution(int[] stones, int k) throws Exception {
        this.stones = stones;
        this.k = k;
        
        int start = 1, end = 0;
        for (int s : stones) {
            end = Math.max(end, s);
        }

        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (isPossible(mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean isPossible(int x) {
        int cnt = 0;
        for (int s : stones) {
            if (s < x) {
                cnt++;
                if (cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}