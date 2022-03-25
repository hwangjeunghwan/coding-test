import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class 모의코테 {
	static class Solution {
	    
		static class books{
			int time;
			String name;
			boolean book;
			
			books(int time, String name, boolean book){
				this.time = time;
				this.name = name;
				this.book = book;
			}
			
		}
		static class BooksComparator implements Comparator<books>{
			@Override
			public int compare(books a,books b){
				if(a.time>b.time) return 1;
				if(a.time<b.time) return -1;
				return 0;
			}
		}
		
	    public String[] solution(String[][] booked, String[][] unbooked) {
	        String[] answer = {};
	       
	        List<books> list = new ArrayList<>();
	        for(int i=0; i<booked.length; i++) {
	        	String[] temp = booked[i][0].split(":");
	        	int hour = Integer.parseInt(temp[0]);
	        	int minute = Integer.parseInt(temp[1]);
	        	int second = (hour*3600) + (minute*60);
	        	
	        	list.add(new books(second, booked[i][1], true));
	        	
	        }
	        for(int i=0; i<unbooked.length; i++) {
	        	String[] temp = unbooked[i][0].split(":");
	        	int hour = Integer.parseInt(temp[0]);
	        	int minute = Integer.parseInt(temp[1]);
	        	int second = (hour*3600) + (minute*60);
	        	
	        	list.add(new books(second, unbooked[i][1], false));
	        	
	        }
	        Collections.sort(list, new BooksComparator());
	        
	        for(books b : list) {
	        	System.out.println(b.time + " " + b.name + " " + b.book);
	        }
	        
	     //   while(!list.isEmpty()) {
	        	
	  //      }
	       

	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[][] booked = {
				{"09:10", "lee"}	
		};
		String[][] unbooked = {
				{"09:00", "kim"}, {"09:05", "bae"}
		};
		s.solution(booked, unbooked);
	}
	


}
