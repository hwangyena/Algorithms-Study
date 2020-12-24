package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BubbleSort_basic {
	//순서 바꾸기
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//bubble sort
	static void bubbleSort(int[] sort, int n) {
		System.out.println("=========교환 작업=========");
//		//뒤에서 시작, 앞을 순서대로 정렬
//		for(int i=0; i<n-1; i++) {
//			for(int j= n-1; j>i; j--) {
//				if(sort[j] < sort[j-1]) swap(sort, j-1, j);
//			}
//		}
		
		//앞에서 시작, 뒤를 순서대로 정렬
		for(int i=n-1; i>=0; i--) {
			for(int k=0; k<i; k++) {
				if(sort[k] > sort[k+1]) swap(sort, k, k+1);
			}
			
			for(int z=0; z<n; z++) {
				System.out.printf("%2d", sort[z]);
			}System.out.println("");
		}
		
		//내림차순 정렬
//		for(int i=n-1; i>=0; i--) {
//			for(int k=0; k<i; k++) {
//				if(sort[k] < sort[k+1]) swap(sort, k, k+1);
//			}
//		}
		
		System.out.println("=======================");
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("[버블정렬] 버전 1");
			System.out.print("요솟수 : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			bubbleSort(sort_arr, num);
			System.out.println("오름차순으로 정렬했습니다.");
			
			for(int i=0; i<num; i++) {
				System.out.println("arr["+i+"] : "+sort_arr[i]);
			}
			
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
