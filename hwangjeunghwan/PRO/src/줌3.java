import java.util.*;

public class ¡‹3 {
	static class Solution {
	    public int solution(int[] histogram) {
	        int answer = -1;

	        for(int i=0; i<histogram.length; i++){
	            for(int j=1; j<histogram.length; j++){
	                int firsth = histogram[i];
	                int lasth = histogram[j];
	                int minh = Math.min(firsth, lasth);
	                
	                int area = (j-i+1)*minh;
	                answer = Math.max(area, answer);
	            }
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] histogram = {6, 5, 7, 3, 4, 2};	
		s.solution(histogram);
	}

}
