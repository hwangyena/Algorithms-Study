package basicDataStructure;

import java.util.Scanner;

public class DayOfYear {
	static int[][] mdays= {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31},	//평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31}	//윤년
	};
	
	//윤년 판단
	static int isLeap(int year) {
		return (year%4==0 && year%100 != 0 || year%400==0) ? 1:0;
	}
	
	//y년 m월 d일의 그 해 경과 일 수
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		for(int i=0; i<m-1; i++) {
			days+=mdays[isLeap(y)][i];
		}
		return days;
	}
	
	//두번째 방법
	static int dayOfYear2(int y, int m, int d) {
		m--;
		while(m > 0) {
			d += mdays[isLeap(y)][--m];
		}
		return d;
	}
	
	//y년 m월 n일의 그 해 남은 일 수
	static int leftDayOfYear(int y, int m, int d) {
		int days = mdays[isLeap(y)][--m] - d; //이번 달 남은 일수
		for(int i=mdays[0].length-1; i>m; i--) {
			days += mdays[isLeap(y)][i];
		}
		return days;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("그 해 경과 일 수 를 구합니다.");
		
		System.out.print("년: "); int year = scn.nextInt();
		System.out.print("월: "); int month = scn.nextInt();
		System.out.print("일: "); int day = scn.nextInt();
		
		System.out.println("그 해 "+dayOfYear(year,month,day)+"일째입니다.");
		System.out.println("그 해 "+dayOfYear2(year,month,day)+"일째입니다.");
		System.out.println("그 해 남은 일수는 "+leftDayOfYear(year,month,day)+"일 입니다.");
	}
}
