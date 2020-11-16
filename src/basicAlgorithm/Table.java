package basicAlgorithm;

public class Table {
	static void multiplication() {
		for(int j=0; j<10; j++) {
			if(j==0) System.out.print("   |");
			else System.out.printf("%3d ", j);
		}
		System.out.println("\n---+------------------------------------");
		for(int i=1; i<10 ; i++) {
			System.out.printf("%2d ", i);
			for(int j=0; j<10; j++) {
				if(j==0) System.out.print("|");
				else System.out.printf("%3d ", i*j);
			}
			System.out.println("");
		}
	}
	
	static void addition() {
		for(int j=0; j<10; j++) {
			if(j==0) System.out.print("   |");
			else System.out.printf("%3d ", j);
		}
		System.out.println("\n---+------------------------------------");
		for(int i=1; i<10 ; i++) {
			System.out.printf("%2d ", i);
			for(int j=0; j<10; j++) {
				if(j==0) System.out.print("|");
				else System.out.printf("%3d ", i+j);
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		//multiplication();
		addition();
	}

}
