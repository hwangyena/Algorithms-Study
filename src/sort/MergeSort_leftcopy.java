package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSort_leftcopy {
	static int[] buff;	//left 복사 공간
	
	public static void printArray(int[] a) { 
		for (int i=0;i<a.length;i++) System.out.print(a[i]+" "); 
		System.out.println(); 
	}
	
	static void __mergeSort(int[] array, int left, int right) {
		if(left < right) { //left == right 이면 정렬
			int i;	//배열 전체를 순환
			int center = (left+right)/2;
			int left_copy=0;//배열의 left 복사
			int buff_p=0;	//buff 순환(복사된 left)
			int merge = left;	//기존배열(array)의 right <-> left 배열의 복사본 buff 를 비교하여 left부터 merge 진행	
			
			
			__mergeSort(array, left, center);	//배열의 앞부분 정렬
			__mergeSort(array, center+1, right);	//배열의 뒷부분 정렬
			
			//병합 수행
			for(i=left; i<=center; i++) buff[left_copy++] = array[i];
			while(i <= right && buff_p<left_copy) //i : right , buff_p : 복사된 left 
				array[merge++] = (buff[buff_p] <= array[i]) ? buff[buff_p++] : array[i++];
				
			while(buff_p<left_copy)//buff 남아있는것 merge
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
			System.out.println("[병합 정렬]");
			System.out.print("요솟수 : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			mergeSort(sort_arr, num);
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
