package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BubbleSort_forward {
	//���� �ٲٱ�
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
		
	//bubble sort
	static void bubbleSort(int[] sort, int n) {
		System.out.println("=========��ȯ �۾�=========");
		
		int sort_start=0; //start ������ ���� ����
		while(sort_start < n-1) {
			int sort_end = n-1;
			
			for(int i=n-1; i > sort_start; i--) {
				if(sort[i] < sort[i-1]) {
					swap(sort, i, i-1);
					sort_end = i;
				}
			}sort_start = sort_end;
			
			for(int z=0; z<n; z++) {
				System.out.printf("%2d", sort[z]);
			}System.out.println("");
		}
			
		System.out.println("=======================");
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("[��������] ���� 3");
			System.out.print("��ڼ� : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			bubbleSort(sort_arr, num);
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
