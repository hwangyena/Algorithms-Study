package basicAlgorithm;

public class Pyramid {
	static void spira(int n) {
		for(int i=1; i<=n; i++) { //피라미드 층 수
			for(int j=1; j<n+i; j++) {
				if(j>=(n-(i-1))) {
					System.out.print("*");
				}
				else System.out.print(" ");
			}System.out.println("");
		}
	}

	static void npira(int n) {
		for(int i=1; i<=n; i++) { //피라미드 층 수
			for(int j=1; j<=n+i-1; j++) {
				if(j>=(n-(i-1))) {
					System.out.print(i);
				}
				else System.out.print(" ");
			}System.out.println("");
		}
	}
	public static void main(String[] args) {
		spira(5);	//별모양 피라미드
		npira(4);	//숫자 피라미드
	}

}
