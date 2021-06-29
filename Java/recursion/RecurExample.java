package recursion;

import java.util.Stack;

public class RecurExample {
	//Àç±Í ÇÔ¼ö
	static void recur(int n) {
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}
	
	//²¿¸® Àç±Í Á¦°Å
	static void recur_tail(int n) {
		while(n>0) {
			recur(n-1);		
			System.out.println(n);
			n-=2;
		}
	}
	
	//Àç±Í Á¦°Å
	static void non_recur(int n) {
		Stack<Integer> s = new Stack<>();
		
		while(true) {
			if(n>0) {
				s.push(n);
				n -= 1;
				continue;
			}
			
			if(!s.isEmpty()) {
				n = s.pop();
				System.out.println(n);
				n-=2;
				continue;
			}
			
			break;
		}
	}
	
	//recur3 
	static void recur3(int n) {
		if(n>0) {
			recur3(n-1);
			recur3(n-2);
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
//		recur(4);
//		recur_tail(4);
//		non_recur(4);
		
		recur3(4);
	}

}
