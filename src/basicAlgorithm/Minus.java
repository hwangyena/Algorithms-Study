package basicAlgorithm;

import java.util.Scanner;

//�������� Q10
public class Minus {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sub;
		int a, b;
		Scanner scn = new Scanner(System.in);
		
		System.out.print("a�� �� : ");
		a = scn.nextInt();
		
		do {
			System.out.print("b�� �� : ");
			b = scn.nextInt();
			if(a>=b) System.out.println("a���� ū ���� �Է��ϼ���!");
		}while(a>=b);
		
		System.out.println("b - a�� "+(b-a)+"�Դϴ�.");
	}

}
