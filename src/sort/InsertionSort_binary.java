package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort_binary {
	static int binarySearch(int array[], int start, int end, int key) {
		int mid = (start+end)/2;
		
		if(start == end) return mid;
		
		if(key > array[mid]) return binarySearch(array, mid+1, end, key);
		else return binarySearch(array, start, mid, key);
	}
	
	static void insertSort(int[] array, int n) {
		for(int i=1; i<n; i++) {
			int j;	//������ �ε��� ��ȣ
			int tmp = array[i];

			//binary search
			int mid = binarySearch(array, 0, i, array[i]);
			
			for(j=i; j>mid ; j--) {//���ĵ� ��� ���������� ó������
				array[j] = array[j-1];		//�� ĭ �ڷ� �з���
			}
			array[mid] = tmp;	//���� ��ġ�� ã��
		}
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
			
			insertSort(sort_arr, num);
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
