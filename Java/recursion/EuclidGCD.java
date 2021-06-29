package recursion;

import java.util.Scanner;

public class EuclidGCD {
	static private int gcd(int x, int y) {
		if(y == 0) return x;
		else return gcd(y, x%y);
	}

	static private int[] gcdArray(int x[], int y[]) {
		int array[] = new int[x.length];
		
		for(int i=0; i<array.length; i++) {
			array[i] = ((x[i]>y[i]) ? gcd(x[i], y[i]) : gcd(y[i],x[i]));
		}
		
		return array;
	}
	
//	static private int gcdAll(int a[]) {
//		int min = a[0];
//		int re[] = new int[a.length];
//		for(int i=1; i<a.length; i++) {
//			if(min > a[i]) min = a[i];
//		}
//		
//	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("�� ���� �ִ������� ���մϴ�.");
		
		System.out.print("������ �Է��ϼ��� : ");
		int x = scn.nextInt();
		System.out.print("������ �Է��ϼ��� : ");
		int y = scn.nextInt();
		
		while(y != 0) {
			int temp = x;
			x = y;
			y = temp%y;
		}
		
		System.out.println(x);
		System.out.println((x>y) ? gcd(x, y) : gcd(y,x));
		
		//�迭�� �ִ� ����� ���ϱ�
		int x_arr[] = {22, 21, 15, 75, 16};
		int y_arr[] = {8, 14, 27, 50, 46};
		int arr[] = gcdArray(x_arr, y_arr);
		
		for(int i=0; i<arr.length; i++) System.out.println(arr[i]);
	
		//�������� 7 - ��� ���� �ִ� ����� ���ϱ�
	}

}
