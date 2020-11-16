package basicAlgorithm;

import java.util.Scanner;

//연습문제 Q10
public class Minus {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sub;
		int a, b;
		Scanner scn = new Scanner(System.in);
		
		System.out.print("a의 값 : ");
		a = scn.nextInt();
		
		do {
			System.out.print("b의 값 : ");
			b = scn.nextInt();
			if(a>=b) System.out.println("a보다 큰 값을 입력하세요!");
		}while(a>=b);
		
		System.out.println("b - a는 "+(b-a)+"입니다.");
	}

}
