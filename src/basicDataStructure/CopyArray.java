package basicDataStructure;

import java.util.Scanner;

public class CopyArray {
	static void copy(int[] a, int[] b) {
		for(int i=0; i<a.length; i++) {
			b[i] = a[i];
		}
	}
	
	static void reverseCopy(int[] a, int[] b) {
		int j = a.length-1;
		for(int i=0; i<a.length; i++) b[i] = a[j--];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("배열의 크기는? ");
		int size = scn.nextInt();	//배열의 크기 입력받기
		
		int array1[] = new int[size];
		int array2[] = new int[size];
		int array3[] = new int[size];
		
		System.out.println("배열의 인자를 입력하세요.");
		for(int i=0; i<size; i++) {
			array1[i] = scn.nextInt();
		}
		System.out.print("입력한 배열: ");
		for(int i=0; i<size; i++) System.out.print(array1[i]+" ");

		copy(array1, array2);
		System.out.print("\n복사한 배열: ");
		for(int i=0; i<size; i++) System.out.print(array2[i]+" ");
		
		reverseCopy(array1, array3);
		System.out.print("\n역순으로 복사한 배열: ");
		for(int i=0; i<size; i++) System.out.print(array3[i]+" ");
	}

}
