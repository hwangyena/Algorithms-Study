package search;

import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int arr[], int n, int key) {
		int pStart = 0;	//배열의 시작 인덱스
		int pEnd = arr.length -1;	//배열의 끝 인덱스
		
		while(true) {	
			int p = (pStart+pEnd) / 2;		//배열의 중간 인덱스		
			
			if(arr[p] == key) return p;	
			if(pStart == pEnd) return -1; 
			
			if(arr[p] > key) {	//key가 뒤에 있음 -> 검색범위를 뒤로 좁힘		
				System.out.println("key가 뒤에 존재");
				pEnd = p-1;
			}
			else { 	//key가 앞에 있음 -> 검색범위를 앞으로 좁힘
				System.out.println("key가 앞에 존재");
				pStart = p+1;
			}
		}	
	}
	
	//재귀함수로 이진탐색 구현
	static int binarySearchX(int[] a, int start, int end, int key) {
		int p = (start+end)/2;	//중간값
		
		if(a[p]==key) return p;
		if(start == end) return -1;
		
		if(a[p] < key) return binarySearchX(a, p+1, end, key);
		else return binarySearchX(a, start, p-1, key);
	
	}
	
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
		
		int idx = binarySearch(array, size, key);
		if(idx == -1) System.out.println("해당 값이 존재하지 않습니다.");
		else System.out.println(key+"은(는) x["+idx+"]에 있습니다.");
	}

}
