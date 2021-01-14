package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
	static int[] temp_buf;

	static void mergeSort(int [] array, int left, int right) {
		if(left < right) {
			int center = (left+right)/2;
			
			mergeSort(array, left, center);
			mergeSort(array, center+1, right);
			
			int temp_idx=left;
			int left_p = left;	//left ��ġ
			int right_p = center+1;	//right ��ġ
			
			while(left_p <= center && right_p <= right) {
				if(array[left_p] < array[right_p]) temp_buf[temp_idx++] = array[left_p++];
				else temp_buf[temp_idx++] = array[right_p++];
			}
			
			//���� ��� ����
			while(left_p <= center) temp_buf[temp_idx++] = array[left_p++];
			while(right_p <= right) temp_buf[temp_idx++] = array[right_p++];
			
			
			for(int i=left; i<=right; i++) {
				array[i] = temp_buf[i];
			}
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
			
			temp_buf = new int[num];
			mergeSort(sort_arr, 0, num-1);
			
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
