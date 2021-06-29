package basicDataStructure;

import java.util.Random;

public class RandomPerson {
	static int maxOf(int[] num) {
		int max = num[0];
		for(int i=1; i<num.length; i++) {
			if(max<num[i]) max=num[i];
		}
		return max;
	}
	public static void main(String[] args) {	
		Random rdn = new Random();
		int numPerson = rdn.nextInt(10);	//�����ϰ� ��� �� ����
		int height[] = new int[numPerson];
		System.out.println("�� "+numPerson+"���� ����� �ֽ��ϴ�.");
		for(int i=0; i<numPerson; i++) {
			height[i] = rdn.nextInt(90) + 100;
			System.out.println("height["+i+"] = "+height[i]);
		}
		
		System.out.println("���� ū Ű�� "+maxOf(height)+"�Դϴ�.");
	}
}
