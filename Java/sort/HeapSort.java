package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HeapSort {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void printHeap(int[] array, int end) {
		for(int i=0; i<=end; i++) {
			System.out.println("Heap ["+i+"] : "+array[i]);
		}
		System.out.println("-------------------");
	}
	
	//start~end까지 heap으로 만듦
	static void downHeap(int[] array, int start, int end) {
		int temp = array[start]; //0
		int parent;
		int child;
		
		for(parent = start; parent < (end+1)/2; parent = child) {
			int cl = parent*2 + 1;
			int cr = cl +1;
			
			child = (array[cl] < array[cr] && cr <= end) ? cr : cl;
			if(temp >= array[child]) break;
			array[parent] = array[child];
		}
		array[parent] = temp;
	}
	
	//heap 정렬
	static void heapSort(int[] a, int n) {
		for(int i = (n-1)/2; i>=0 ; i--) {
			downHeap(a, i, n-1);
		}
		
		for(int i=n-1; i>0; i--) {
			swap(a, 0, i);
			downHeap(a, 0, i-1);
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("[힙 정렬]");
			System.out.print("요솟수 : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			heapSort(sort_arr, num);
			
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
