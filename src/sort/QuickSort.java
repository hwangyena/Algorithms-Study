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
		int pl = left;	//���� Ŀ��
		int pr = right;	//������ Ŀ��
		int pivot = array[(pl+pr)/2];	//pivot(����)
		
		do {
			while(array[pl] < pivot) pl++;
			while(array[pr] > pivot) pr--;
			
			if(pl<=pr) swap(array, pl++, pr--);	//���� X -> ���� ��ȯ
		}while(pl<=pr);
		
		if(left < pr) quickSort(array, left, pr);
		if(right > pl) quickSort(array, pl, right);
	}
	
	//stack overflow �ذ� ��� 1)
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
	
	//3���� �� ���� ����
	private static void threeSort(int []arr, int front, int mid, int rear){
		if(arr[front]>arr[mid]) swap(arr, front, mid);
		if(arr[mid]>arr[rear]) swap(arr, mid, rear);	//rear�� ����
		if(arr[front]>arr[mid]) swap(arr, front, mid);	//front, mid �� ����
	}
	
	//medianQuickSort
	static void medianQuickSort(int[] array, int left, int right) {
		//pivot �����ϱ�
		int mid = (left+right)/2;
		threeSort(array, left, mid, right);
		
		if(right-left >= 3) {
			swap(array, mid, right-1);
			int pivot = array[right-1];	//pivot(����)
			int pl = left+1;	//���� Ŀ��
			int pr = right-2;	//������ Ŀ��
			
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
			System.out.println("[�� ����]");
			System.out.print("��ڼ� : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			medianQuickSort(sort_arr, 0, num-1);
			System.out.println("������������ �����߽��ϴ�.");
			
			for(int i=0; i<num; i++) {
				System.out.println("arr["+i+"] : "+sort_arr[i]);
			}
			
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
