import java.util.*;
public class 줌2 {
	static class Solution {
		static class docu{
			int num;
			int time;
			int page;
			docu(int x, int y, int z){
				this.num = x;
				this.time = y;
				this.page = z;
			}
		}
	    public int[] solution(int[][] data) {
	        int[] answer = new int[data.length];
	        answer[0] = 1;
	        int j=1;
	        List<Integer> array = new ArrayList<>();
	        List<docu> list = new LinkedList<>();
	        int firsttime = data[0][1]+data[0][2];
	        for(int i=1; i<data.length; i++) {
	        	int dnum = data[i][0]; //문서번호
	            int time = data[i][1]; //시간
	            int page = data[i][2]; //페이지수
	           
	            if(firsttime>time) {
	            	if(!list.isEmpty()) {
	            		if(list.get(0).page>page) {
	            			list.add(0, new docu(dnum, time, page));
	            		}
	            		else if(list.get(0).page==page) {
	            			list.add(1, new docu(dnum, time, page));
	            		}
	            		else {
	            			list.add(new docu(dnum, time, page));
	            		}
	            	}
	            	else {
	            		list.add(new docu(dnum, time, page));
	            	}
	            }
	            else if(firsttime==time) {
	            	answer[j]=dnum;
	            	j++;
	            	firsttime=time+page;
	            }
	            else {
	            	while(!list.isEmpty()) {
	            		answer[j] = list.get(0).num;
	            		j++;
	            		firsttime = list.get(0).page+firsttime;
	            		list.remove(0);
	            		if(firsttime==time) {
	    	            	answer[j]=dnum;
	    	            	j++;
	    	            	firsttime=time+page;
	    	            	array.add(dnum);
	    	            	break;
	    	            }
	            		
	            		
	            	}
	            	
	            	if(!list.isEmpty()&&!array.contains(dnum)) {
	            		if(list.get(0).page>page) {
	            			list.add(0, new docu(dnum, time, page));
	            		}
	            		else if(list.get(0).page==page) {
	            			list.add(1, new docu(dnum, time, page));
	            		}
	            		else {
	            			list.add(new docu(dnum, time, page));
	            		}
	            	}
	            	else if(list.isEmpty()&&!array.contains(dnum)){
	            		list.add(new docu(dnum, time, page));
	            	}
	            
	            
	            }
	        	
	        }
	    	while(!list.isEmpty()) {
        		answer[j] = list.get(0).num;
        		j++;
        		firsttime = list.get(0).page+firsttime;
  
        		list.remove(0);
        		
        	}
	            
	                     

	        
	        
	        for(int i : answer) {
	        	System.out.println(i);
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] data = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
		s.solution(data);
	}

}
