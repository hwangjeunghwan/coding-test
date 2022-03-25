
public class 큰수만들기 {
	static class Solution {
	    static String answer = "";
	    public String solution(String number, int k) {
	        StringBuilder sb = new StringBuilder();
	        int len = number.length()-k;
	        int idx = 0;
	        int maxnum = -1;
	        int temp_idx = 0;
	        for(int i=0; i<number.length()-k; i++){
	            maxnum =0;
	            for(int j=idx; j<=k+i; j++){
	                int num = Integer.valueOf(number.charAt(j)-'0');
	                if(maxnum<num){
	                    maxnum = num;
	                   idx = j+1;
	                }
	            }
	            sb.append(maxnum);


	        }

	        return sb.toString();
	    }


	}
}
