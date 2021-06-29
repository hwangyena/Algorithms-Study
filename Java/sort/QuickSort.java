package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort(int[] array, int left, int right) {
		int pl = left;	//왼쪽 커서
		int pr = right;	//오른쪽 커서
		int pivot = array[(pl+pr)/2];	//pivot(기준)
		
		do {
			while(array[pl] < pivot) pl++;
			while(array[pr] > pivot) pr--;
			
			if(pl<=pr) swap(array, pl++, pr--);	//교차 X -> 값을 교환
		}while(pl<=pr);
		
		if(left < pr) quickSort(array, left, pr);
		if(right > pl) quickSort(array, pl, right);
	}
	
	//stack overflow 해결 방법 1)
	static void quickSort_norecur(int[] array, int left, int right) {
		Stack<Integer> lstack = new Stack<>();
		Stack<Integer> rstack = new Stack<>();

		lstack.push(left);
		rstack.push(right);

		while(lstack.isEmpty() != true) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int pivot = array[(left+right)/2];
			
			do {
				while(array[pl] < pivot) pl++;
				while(array[pr] > pivot) pr--;
				
				if(pl<=pr) swap(array, pl++, pr--);
			}while(pl<=pr);
			
			if(left < pr) {
				lstack.push(left);
				rstack.push(pr);
			}
			if(right > pl) {
				lstack.push(pl);
				rstack.push(right);
			}
		}
	}
	
	//3개의 값 선행 정렬
	private static void threeSort(int []arr, int front, int mid, int rear){
		if(arr[front]>arr[mid]) swap(arr, front, mid);
		if(arr[mid]>arr[rear]) swap(arr, mid, rear);	//rear값 결정
		if(arr[front]>arr[mid]) swap(arr, front, mid);	//front, mid 값 결정
	}
	
	//medianQuickSort
	static void medianQuickSort(int[] array, int left, int right) {
		//pivot 선택하기
		int mid = (left+right)/2;
		threeSort(array, left, mid, right);
		
		if(right-left >= 3) {
			swap(array, mid, right-1);
			int pivot = array[right-1];	//pivot(기준)
			int pl = left+1;	//왼쪽 커서
			int pr = right-2;	//오른쪽 커서
			
			do {
				while(array[pl] < pivot) pl++;
				while(array[pr] > pivot) pr--;
				
				if(pl<=pr) swap(array, pl++, pr--);
			}while(pl<=pr);
			
			if(left < pr) medianQuickSort(array, left, pr);
			if(right > pl) medianQuickSort(array, pl, right);
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("[퀵 정렬]");
			System.out.print("요솟수 : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			medianQuickSort(sort_arr, 0, num-1);
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
