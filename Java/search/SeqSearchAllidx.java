package search;

import java.util.Scanner;

public class SeqSearchAllidx {
	//보초법을 사용한 순차탐색
	static int searchIdx(int[] arr, int n, int key, int[] idx) {
		int idxSize=0;
		arr[n] = key;
		int i=0;
		do {
			if(arr[i] == key) {	//검색성공!
				idx[idxSize++] = i;	//배열에 인덱스 저장
				System.out.println("idxSize : "+idxSize);
			} 
			i++;
		}while(n>i);
		
		if(idxSize != 0) return idxSize;
		else 	return -1;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("배열의 개수 : ");
		int size = scn.nextInt();
		int array[] = new int[size+1];
		int idxArray[] = new int[size];
		
		for(int i=0; i<size; i++) {
			System.out.print("x["+i+"] : ");
			array[i] = scn.nextInt();
		}
		System.out.print("검색할 값 : ");
		int key = scn.nextInt();
		
		int idx = searchIdx(array, size, key, idxArray);
		if(idx == -1) System.out.println("해당 값이 존재하지 않습니다.");
		else {
			System.out.println(key+"는 ");
			for(int i=0; i<idx; i++) System.out.print(idxArray[i]+" ");
			System.out.println(" 인덱스에 존재합니다.");
		}

	}

}
