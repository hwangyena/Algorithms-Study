package basicAlgorithm;

import java.util.Scanner;

public class Digit {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int number, digit=0;
		
		System.out.print("양의 정수를 입력하세요: ");
		number = scn.nextInt();
		
		while(number != 0) {
			number /= 10;
			digit++;
		}
		System.out.printf("그 수는 %d자리입니다.", digit);
	}

}
