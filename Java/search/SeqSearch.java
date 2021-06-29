package search;

import java.util.Scanner;

public class SeqSearch {
	//선형 탐색
	static int seqSearch(int[] arr, int n, int key) {
		int i=0;
		
		//while으로 구현
		while(true) {
			if(i==n) return -1;	//찾기 실패
			if(arr[i] == key) return i;	//찾기 성공 > 인덱스 반환
			i++;
		}
		
//		//for으로 구현
//		for(i=0; i<=n; i++) 
//			if(arr[i] == key) return i;
//		return -1;
	}

	//보초법
	static int seqSearchSen(int[] arr, int n, int key) {
		arr[n] = key;	//보초 추가
		int i=0;
		while(true) {
			if(arr[i] == key) break;
			i++;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[11];
		for(int i=0; i<10; i++) arr[i] = i;
		System.out.print("검색할 값 : ");
		int key = scn.nextInt();
		
		//선형탐색
		int seq = seqSearch(arr, 10, key);
		
		//보초법
 		int seqSen = seqSearchSen(arr, 10, key);

 		if(seq == -1 || seqSen == -1) System.out.println("값이 검색되지 않았습니다.");
 		else System.out.println("검색된 인덱스 : "+seq+", 보초법 : "+seqSen);
	}

}
