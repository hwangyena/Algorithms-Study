package basicAlgorithm;

import java.util.Scanner;

public class Digit {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int number, digit=0;
		
		System.out.print("���� ������ �Է��ϼ���: ");
		number = scn.nextInt();
		
		while(number != 0) {
			number /= 10;
			digit++;
		}
		System.out.printf("�� ���� %d�ڸ��Դϴ�.", digit);
	}

}
