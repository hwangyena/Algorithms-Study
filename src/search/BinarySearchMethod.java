package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchMethod {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("�迭�� ���� : ");
		int size = scn.nextInt();
		int array[] = new int[size];
		
		System.out.println("������������ �Է��ϼ���.");
		for(int i=0; i<size; i++) {
			System.out.print("x["+i+"] : ");
			array[i] = scn.nextInt();
		}
		System.out.print("�˻��� �� : ");
		int key = scn.nextInt();
		
		int idx = Arrays.binarySearch(array, key);
		if(idx < 0) {
			System.out.println("���� ����Ʈ : "+(idx*(-1)-1)+" / �˻��� �����Ͽ����ϴ�.");
		}
		else System.out.println(key+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
	}
}
