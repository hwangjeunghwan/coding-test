
public class 기지국설치 {
	static class Solution {
	    public int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        int sidx=0;
	        for(int pos=1; pos<=n; pos++) {
	        	
	        	if(sidx<stations.length&&pos>=stations[sidx]-w) {
	        		pos = stations[sidx]+w;
	        		sidx++;
	        	}
	        	else {
	        		pos += 2*w;
	        		answer++;
	        	}
	        }

	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int n = 11; 
		int[] stations = {4, 11}; 
		int w =	1;
		System.out.println(s.solution(n, stations, w));
	}

}
