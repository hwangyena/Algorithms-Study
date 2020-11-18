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
		
		//n일 뒤의 날짜를 반환
		void YMDafter(YMD ymd, int n){
			int monthArray = ymd.m-1;
			int month = mdays[isLeap(ymd.y)][monthArray];	//현재 월의 일수를 가져옴
			ymd.d += n;
	
			while(ymd.d > month) {	//현재 월 일보다 큰 경우
				if(ymd.m==12) { 
					ymd.m=0;
					monthArray=0;
				}
				++ymd.m; //월 증가
				++monthArray;
				
				ymd.d -= month;
				month = mdays[isLeap(ymd.y)][monthArray];
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("시작일을 포함시키지 않은 n일후의 날짜구하기");
		System.out.print("년: "); ;int year = scn.nextInt();
		System.out.print("월: "); int month = scn.nextInt();
		System.out.print("일: "); int day = scn.nextInt();
		YMD days = new YMD(year, month, day);
		
		System.out.print("며칠뒤의 날짜를 구할까요? ");
		int n = scn.nextInt();
		days.YMDafter(days, n);
		System.out.println(n+"일 뒤의 날짜는 "+days.m+"월 "+days.d+"일 입니다.");
	}

}
