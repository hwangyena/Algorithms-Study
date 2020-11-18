package basicDataStructure;

import java.util.Scanner;

public class DayOfYear {
	static int[][] mdays= {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31},	//���
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31}	//����
	};
	
	//���� �Ǵ�
	static int isLeap(int year) {
		return (year%4==0 && year%100 != 0 || year%400==0) ? 1:0;
	}
	
	//y�� m�� d���� �� �� ��� �� ��
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		for(int i=0; i<m-1; i++) {
			days+=mdays[isLeap(y)][i];
		}
		return days;
	}
	
	//�ι�° ���
	static int dayOfYear2(int y, int m, int d) {
		m--;
		while(m > 0) {
			d += mdays[isLeap(y)][--m];
		}
		return d;
	}
	
	//y�� m�� n���� �� �� ���� �� ��
	static int leftDayOfYear(int y, int m, int d) {
		int days = mdays[isLeap(y)][--m] - d; //�̹� �� ���� �ϼ�
		for(int i=mdays[0].length-1; i>m; i--) {
			days += mdays[isLeap(y)][i];
		}
		return days;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("�� �� ��� �� �� �� ���մϴ�.");
		
		System.out.print("��: "); int year = scn.nextInt();
		System.out.print("��: "); int month = scn.nextInt();
		System.out.print("��: "); int day = scn.nextInt();
		
		System.out.println("�� �� "+dayOfYear(year,month,day)+"��°�Դϴ�.");
		System.out.println("�� �� "+dayOfYear2(year,month,day)+"��°�Դϴ�.");
		System.out.println("�� �� ���� �ϼ��� "+leftDayOfYear(year,month,day)+"�� �Դϴ�.");
	}
}
