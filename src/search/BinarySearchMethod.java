package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchMethod {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("배열의 개수 : ");
		int size = scn.nextInt();
		int array[] = new int[size];
		
		System.out.println("오름차순으로 입력하세요.");
		for(int i=0; i<size; i++) {
			System.out.print("x["+i+"] : ");
			array[i] = scn.nextInt();
		}
		System.out.print("검색할 값 : ");
		int key = scn.nextInt();
		
		int idx = Arrays.binarySearch(array, key);
		if(idx < 0) {
			System.out.println("삽입 포인트 : "+(idx*(-1)-1)+" / 검색에 실패하였습니다.");
		}
		else System.out.println(key+"은(는) x["+idx+"]에 있습니다.");
	}
}
