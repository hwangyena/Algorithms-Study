package search;

import java.util.Scanner;

public class SeqSearch {
	//���� Ž��
	static int seqSearch(int[] arr, int n, int key) {
		int i=0;
		
		//while���� ����
		while(true) {
			if(i==n) return -1;	//ã�� ����
			if(arr[i] == key) return i;	//ã�� ���� > �ε��� ��ȯ
			i++;
		}
		
//		//for���� ����
//		for(i=0; i<=n; i++) 
//			if(arr[i] == key) return i;
//		return -1;
	}

	//���ʹ�
	static int seqSearchSen(int[] arr, int n, int key) {
		arr[n] = key;	//���� �߰�
		int i=0;
		while(true) {
			if(arr[i] == key) break;
			i++;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[11];
		for(int i=0; i<10; i++) arr[i] = i;
		System.out.print("�˻��� �� : ");
		int key = scn.nextInt();
		
		//����Ž��
		int seq = seqSearch(arr, 10, key);
		
		//���ʹ�
 		int seqSen = seqSearchSen(arr, 10, key);

 		if(seq == -1 || seqSen == -1) System.out.println("���� �˻����� �ʾҽ��ϴ�.");
 		else System.out.println("�˻��� �ε��� : "+seq+", ���ʹ� : "+seqSen);
	}

}
