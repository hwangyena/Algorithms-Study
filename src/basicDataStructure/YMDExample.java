package basicDataStructure;

import java.util.Scanner;

public class YMDExample extends DayOfYear{
	static class YMD{
		int y;
		int m;
		int d;
		
		YMD(int y, int m, int d){
			this.y = y;
			this.m = m;
			this.d = d;
		}
		
		//n�� ���� ��¥�� ��ȯ
		void YMDafter(YMD ymd, int n){
			int monthArray = ymd.m-1;
			int month = mdays[isLeap(ymd.y)][monthArray];	//���� ���� �ϼ��� ������
			ymd.d += n;
	
			while(ymd.d > month) {	//���� �� �Ϻ��� ū ���
				if(ymd.m==12) { 
					ymd.m=0;
					monthArray=0;
				}
				++ymd.m; //�� ����
				++monthArray;
				
				ymd.d -= month;
				month = mdays[isLeap(ymd.y)][monthArray];
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("�������� ���Խ�Ű�� ���� n������ ��¥���ϱ�");
		System.out.print("��: "); ;int year = scn.nextInt();
		System.out.print("��: "); int month = scn.nextInt();
		System.out.print("��: "); int day = scn.nextInt();
		YMD days = new YMD(year, month, day);
		
		System.out.print("��ĥ���� ��¥�� ���ұ��? ");
		int n = scn.nextInt();
		days.YMDafter(days, n);
		System.out.println(n+"�� ���� ��¥�� "+days.m+"�� "+days.d+"�� �Դϴ�.");
	}

}
