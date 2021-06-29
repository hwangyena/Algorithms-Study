package search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
	static class PhyscData{//Ŭ������ ����üó�� ���
		private String name;	
		private int height;
		private double vision;	
		
		PhyscData(String name, int height, double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		//���ڿ� ��ȯ �޼���
		public String toString() {
			return name + " " +height + " " +vision+" ";
		}

		public static final HeightOrderComparator VISION_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {	//�÷±��� �������� ����
				return (d1.vision > d2.vision) ? 1 :
					   (d1.vision < d2.height) ? -1 : 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PhyscData[] x= {
				new PhyscData("�̳���", 162, 0.3),
				new PhyscData("������", 168, 0.4),
				new PhyscData("���Ѱ�", 169, 0.8),
				new PhyscData("ȫ�ر�", 171, 1.5),
				new PhyscData("������", 173, 0.7),
				new PhyscData("��ȣ��", 174, 1.2),
				new PhyscData("�̼���", 175, 2.0)
		};
		System.out.println("�÷��� �󸶰� �Ǵ� ����� ã���ֳ���? : ");
		double vision = scn.nextDouble();
		int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision),PhyscData.VISION_ORDER);
		
		if(idx > 0 )	System.out.println("��Ұ� �����ϴ�.");
		else {
			System.out.println("x["+idx+"]�� �ֽ��ϴ�.");
			System.out.println("ã�� ������ : "+x[idx]);
		}
	}

}
