package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort {
	static void insertSort(int[] array, int n) {
		for(int i=1; i<n; i++) {
			int j;	//������ �ε��� ��ȣ
			int tmp = array[i];	//�����ؾ��ϴ� ��
			for(j=i; j>0 && array[j-1] > tmp ; j--) {//���ĵ� ��� ���������� ó������
				array[j] = array[j-1];		//�� ĭ �ڷ� �з���
			}
			array[j] = tmp;	//���� ��ġ�� ã��
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
