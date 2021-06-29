package basicDataStructure;

import java.util.Scanner;

public class CardConvRev{
	//x�� r������ ��ȯ�Ͽ� �������� �迭 d�� ����
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x%r);	//������ ����
			x /= r;
		}while(x != 0);
		
		return digits;
	}
	
	//x�� r������ ��ȯ�Ͽ� ���������� �迭 d�� ����
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		char[] dR = new char[32];
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			dR[digits++] = dchar.charAt(x%r);	//������ ����
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
		
		System.out.println("10������ ��� ��ȯ�մϴ�.");
		System.out.print("��ȯ�ϴ� ���� �ƴ� ���� : ");
		int dex = scn.nextInt();
		
		do {
			System.out.print("� ������ ��ȯ�ұ��? (2-36) : ");
			int r = scn.nextInt();
			char[] convr = new char[32];
			System.out.printf("%d�����δ� ", r);
			//���� ��½�
			int digits = cardConvR(dex, r, convr);
			for(int i=digits; i>=0; i--)  System.out.print(convr[i]);
			//������� ��½�
			//int digits = cardConv(dex, r, convr);
			//for(int i=0; i<=digits; i++) System.out.print(convr[i]);
			
			
			System.out.println("�Դϴ�.\n�� �� �� �ұ��?(1. ��/2. �ƴϿ�)");
		}while(scn.nextInt() == 1);
	}

}
