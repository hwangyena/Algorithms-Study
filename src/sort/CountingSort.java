package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountingSort {
	static void countingSort(int[] array, int n, int max) {
		int[] f = new int[max+1];
		int[] b = new int[n];
		
		for(int i=0; i<n; i++) f[array[i]]++;	//1�ܰ�
		for(int i=1; i<=max; i++) f[i] += f[i-1]; //2�ܰ�
		for(int i=n-1; i>=0; i--) b[--f[array[i]]] = array[i];	//3�ܰ�
		for(int i=0; i<n ;i++) array[i] = b[i];	//4�ܰ�
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("[���� ����]");
			System.out.print("��ڼ� : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			int max = sort_arr[0];
			for(int i=1; i<num; i++) {
				if(max < sort_arr[i]) max = sort_arr[i];
			}
			countingSort(sort_arr, num, max);
			
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
