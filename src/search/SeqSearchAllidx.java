package search;

import java.util.Scanner;

public class SeqSearchAllidx {
	//���ʹ��� ����� ����Ž��
	static int searchIdx(int[] arr, int n, int key, int[] idx) {
		int idxSize=0;
		arr[n] = key;
		int i=0;
		do {
			if(arr[i] == key) {	//�˻�����!
				idx[idxSize++] = i;	//�迭�� �ε��� ����
				System.out.println("idxSize : "+idxSize);
			} 
			i++;
		}while(n>i);
		
		if(idxSize != 0) return idxSize;
		else 	return -1;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("�迭�� ���� : ");
		int size = scn.nextInt();
		int array[] = new int[size+1];
		int idxArray[] = new int[size];
		
		for(int i=0; i<size; i++) {
			System.out.print("x["+i+"] : ");
			array[i] = scn.nextInt();
		}
		System.out.print("�˻��� �� : ");
		int key = scn.nextInt();
		
		int idx = searchIdx(array, size, key, idxArray);
		if(idx == -1) System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
		else {
			System.out.println(key+"�� ");
			for(int i=0; i<idx; i++) System.out.print(idxArray[i]+" ");
			System.out.println(" �ε����� �����մϴ�.");
		}

	}

}
