package basicAlgorithm;

public class Pyramid {
	static void spira(int n) {
		for(int i=1; i<=n; i++) { //�Ƕ�̵� �� ��
			for(int j=1; j<n+i; j++) {
				if(j>=(n-(i-1))) {
					System.out.print("*");
				}
				else System.out.print(" ");
			}System.out.println("");
		}
	}

	static void npira(int n) {
		for(int i=1; i<=n; i++) { //�Ƕ�̵� �� ��
			for(int j=1; j<=n+i-1; j++) {
				if(j>=(n-(i-1))) {
					System.out.print(i);
				}
				else System.out.print(" ");
			}System.out.println("");
		}
	}
	public static void main(String[] args) {
		spira(5);	//����� �Ƕ�̵�
		npira(4);	//���� �Ƕ�̵�
	}

}
