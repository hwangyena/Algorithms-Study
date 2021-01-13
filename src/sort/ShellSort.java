package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellSort {
	static void shellSort(int array[], int n) {
		int h;
		for(h=1; h<n/9; h=h*3+1);	//h �ʱ갪 ����
		System.out.println("h: "+h);
		
		for(; h>0; h /= 3) {
			for(int i=h; i<n; i++) {
				int j;	//������ �ε��� ��ȣ
				int tmp = array[i];	//�����ؾ��ϴ� ��
				for(j=i-h; j>=0 && array[j] > tmp ; j-=h) {//���ĵ� ��� ���������� ó������
					array[j+h] = array[j];		//�� ĭ �ڷ� �з���
				}
				array[j+h ] = tmp;	//���� ��ġ�� ã��
			}
		}
	}
	//i : h�� ���� �� <-> j : h�� ���� ��
	
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
			
			shellSort(sort_arr, num);
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
