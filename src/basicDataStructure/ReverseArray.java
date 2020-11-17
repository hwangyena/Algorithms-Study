package basicDataStructure;

import java.util.Scanner;

public class ReverseArray {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void printArray(int[] a) {
		for(int i=0; i<a.length; i++) System.out.print(a[i]+" ");
		System.out.println("");
	}
	
	static void reverse(int[] a) {
		for(int i=0; i<a.length / 2; i++) {
			printArray(a);
			System.out.printf("a[%d]��(��) a[%d]�� ��ȯ�մϴ�.\n", i, a.length-i-1);
			swap(a, i, a.length - i-1);
		}
	}
	
	static int sumOf(int[] a) {
		int sum=0;
		for(int i=0; i<a.length; i++) {
			sum+=a[i];
		}return sum;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("��ڼ� : ");
		int idxNum = scn.nextInt();
		int array[] = new int[idxNum];
		
		for(int i=0; i<idxNum; i++) {
			System.out.print("x["+i+"] : ");
			array[i] = scn.nextInt();
		}
		
		reverse(array);
		System.out.println("��Ҹ� �������� �����߽��ϴ�.\n���\n");
		
		for(int i=0; i<array.length; i++) {
			//System.out.println("x["+i+"] : "+array[i]);
			System.out.print(array[i] + " ");
		}
		
		System.out.println("��ҵ��� �� : "+sumOf(array));
	}

}
