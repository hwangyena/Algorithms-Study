package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellSort {
	static void shellSort(int array[], int n) {
		int h;
		for(h=1; h<n/9; h=h*3+1);	//h 초깃값 구함
		System.out.println("h: "+h);
		
		for(; h>0; h /= 3) {
			for(int i=h; i<n; i++) {
				int j;	//비교해줄 인덱스 번호
				int tmp = array[i];	//정렬해야하는 값
				for(j=i-h; j>=0 && array[j] > tmp ; j-=h) {//정렬된 요소 마지막부터 처음까지
					array[j+h] = array[j];		//한 칸 뒤로 밀려남
				}
				array[j+h ] = tmp;	//정렬 위치를 찾음
			}
		}
	}
	//i : h로 나뉜 앞 <-> j : h로 나뉜 뒤
	
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
			
			shellSort(sort_arr, num);
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
