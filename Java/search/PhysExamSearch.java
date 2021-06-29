package search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
	static class PhyscData{//클래스를 구조체처럼 사용
		private String name;	
		private int height;
		private double vision;	
		
		PhyscData(String name, int height, double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		//문자열 반환 메서드
		public String toString() {
			return name + " " +height + " " +vision+" ";
		}

		public static final HeightOrderComparator VISION_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {	//시력기준 내림차순 정렬
				return (d1.vision > d2.vision) ? 1 :
					   (d1.vision < d2.height) ? -1 : 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PhyscData[] x= {
				new PhyscData("이나령", 162, 0.3),
				new PhyscData("유지훈", 168, 0.4),
				new PhyscData("김한결", 169, 0.8),
				new PhyscData("홍준기", 171, 1.5),
				new PhyscData("전서현", 173, 0.7),
				new PhyscData("이호연", 174, 1.2),
				new PhyscData("이수민", 175, 2.0)
		};
		System.out.println("시력이 얼마가 되는 사람을 찾고있나요? : ");
		double vision = scn.nextDouble();
		int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision),PhyscData.VISION_ORDER);
		
		if(idx > 0 )	System.out.println("요소가 없습니다.");
		else {
			System.out.println("x["+idx+"]에 있습니다.");
			System.out.println("찾은 데이터 : "+x[idx]);
		}
	}

}
