package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSort_leftcopy {
	static int[] buff;	//left ���� ����
	
	public static void printArray(int[] a) { 
		for (int i=0;i<a.length;i++) System.out.print(a[i]+" "); 
		System.out.println(); 
	}
	
	static void __mergeSort(int[] array, int left, int right) {
		if(left < right) { //left == right �̸� ����
			int i;	//�迭 ��ü�� ��ȯ
			int center = (left+right)/2;
			int left_copy=0;//�迭�� left ����
			int buff_p=0;	//buff ��ȯ(����� left)
			int merge = left;	//�����迭(array)�� right <-> left �迭�� ���纻 buff �� ���Ͽ� left���� merge ����	
			
			
			__mergeSort(array, left, center);	//�迭�� �պκ� ����
			__mergeSort(array, center+1, right);	//�迭�� �޺κ� ����
			
			//���� ����
			for(i=left; i<=center; i++) buff[left_copy++] = array[i];
			while(i <= right && buff_p<left_copy) //i : right , buff_p : ����� left 
				array[merge++] = (buff[buff_p] <= array[i]) ? buff[buff_p++] : array[i++];
				
			while(buff_p<left_copy)//buff �����ִ°� merge
					array[merge++] = buff[buff_p++];

			printArray(buff);

		}
	}
	
	static void mergeSort(int[] array, int n) {
		buff = new int[n];
		__mergeSort(array, 0, n-1);
		buff = null;
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
			
			mergeSort(sort_arr, num);
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
