package basicAlgorithm;

public class MaxMin {
	static int max4(int a, int b, int c, int d) {
		int max = a;
		if(max<b) max = b;
		if(max<c) max = c;
		if(max<d) max = d;
		
		return max;
	}
	
	static int min3(int a, int b, int c) {
		int min=a;
		if(min>b) min=b;
		if(min>c) min=c;
		return min;
	}
	
	static int min4(int a, int b, int c, int d) {
		int min=a;
		if(min>b) min=b;
		if(min>c) min=c;
		if(min>d) min=d;
		return min;
	}
	public static void main(String[] args) {
		System.out.println("max4 예제(7, 10, 2, 20) : "+max4(7, 10, 2, 20));
		System.out.println("min3 예제(7, 10, 2) : "+min3(7, 10, 2));
		System.out.println("min4 예제(7, 10, 2, 20) : "+min4(7, 10, 2, 20));
	}

}
