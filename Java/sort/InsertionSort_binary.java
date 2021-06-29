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
			int j;	//비교해줄 인덱스 번호
			int tmp = array[i];

			//binary search
			int mid = binarySearch(array, 0, i, array[i]);
			
			for(j=i; j>mid ; j--) {//정렬된 요소 마지막부터 처음까지
				array[j] = array[j-1];		//한 칸 뒤로 밀려남
			}
			array[mid] = tmp;	//정렬 위치를 찾음
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("[삽입 정렬]");
			System.out.print("요솟수 : ");
			int num = Integer.parseInt(br.readLine());
			int sort_arr[] = new int[num];
			
			for(int i=0; i<num; i++) {
				System.out.print("arr["+i+"] : ");
				sort_arr[i] = Integer.parseInt(br.readLine());
			}
			
			insertSort(sort_arr, num);
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
