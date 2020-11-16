package basicAlgorithm;

public class Triangle {
	//직각 이등변 삼각형 - 왼쪽 아래
	static void triangleLB(int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	//직각 이등변 삼각형 - 왼쪽 위
	static void triangleLU(int n) {
		for(int i=n; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}System.out.println("");
		}
	}
	
	//직각 이등변 삼각형 - 오른쪽 아래
	static void triangleRB(int n) {
		for(int i=n; i>0; i--) {
			for(int j=1; j<=n; j++) {
				if(j>=i) System.out.print("*");
				else System.out.print(" ");
			}System.out.println("");
		}
	}
	
	//직각 이등변 삼각형 - 오른쪽 위
	static void triangleRU(int n) {
		for(int i=0; i<n ;i++) {
			for(int j=0; j<n; j++) {
				if(j>=i) System.out.print("*");
				else System.out.print(" ");
			}System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		triangleLB(5);
		triangleLU(5);
		triangleRB(5);
		triangleRU(5);
	}
}
