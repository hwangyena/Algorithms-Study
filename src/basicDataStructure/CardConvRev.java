package basicDataStructure;

import java.util.Scanner;

public class CardConvRev{
	//x를 r진수로 변환하여 역순으로 배열 d에 저장
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x%r);	//나머지 저장
			x /= r;
		}while(x != 0);
		
		return digits;
	}
	
	//x를 r진수로 변환하여 순차적으로 배열 d에 저장
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		char[] dR = new char[32];
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			dR[digits++] = dchar.charAt(x%r);	//나머지 저장
			x /= r;
		}while(x != 0);
		int j = digits;
		for(int i=0; i<=digits; i++) {
			d[i] = dR[j--];
		}
		
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("10진수를 기수 변환합니다.");
		System.out.print("변환하는 음이 아닌 정수 : ");
		int dex = scn.nextInt();
		
		do {
			System.out.print("어떤 진수로 변환할까요? (2-36) : ");
			int r = scn.nextInt();
			char[] convr = new char[32];
			System.out.printf("%d진수로는 ", r);
			//역순 출력시
			int digits = cardConvR(dex, r, convr);
			for(int i=digits; i>=0; i--)  System.out.print(convr[i]);
			//순서대로 출력시
			//int digits = cardConv(dex, r, convr);
			//for(int i=0; i<=digits; i++) System.out.print(convr[i]);
			
			
			System.out.println("입니다.\n한 번 더 할까요?(1. 예/2. 아니오)");
		}while(scn.nextInt() == 1);
	}

}
