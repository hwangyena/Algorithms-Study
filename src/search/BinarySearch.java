package search;

import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int arr[], int n, int key) {
		int pStart = 0;	//�迭�� ���� �ε���
		int pEnd = arr.length -1;	//�迭�� �� �ε���
		
		while(true) {	
			int p = (pStart+pEnd) / 2;		//�迭�� �߰� �ε���		
			
			if(arr[p] == key) return p;	
			if(pStart == pEnd) return -1; 
			
			if(arr[p] > key) {	//key�� �ڿ� ���� -> �˻������� �ڷ� ����		
				System.out.println("key�� �ڿ� ����");
				pEnd = p-1;
			}
			else { 	//key�� �տ� ���� -> �˻������� ������ ����
				System.out.println("key�� �տ� ����");
				pStart = p+1;
			}
		}	
	}
	
	//����Լ��� ����Ž�� ����
	static int binarySearchX(int[] a, int start, int end, int key) {
		int p = (start+end)/2;	//�߰���
		
		if(a[p]==key) return p;
		if(start == end) return -1;
		
		if(a[p] < key) return binarySearchX(a, p+1, end, key);
		else return binarySearchX(a, start, p-1, key);
	
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("�迭�� ���� : ");
		int size = scn.nextInt();
		int array[] = new int[size];
		
		System.out.println("������������ �Է��ϼ���.");
		for(int i=0; i<size; i++) {
			System.out.print("x["+i+"] : ");
			array[i] = scn.nextInt();
		}
		System.out.print("�˻��� �� : ");
		int key = scn.nextInt();
		
		int idx = binarySearch(array, size, key);
		if(idx == -1) System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
		else System.out.println(key+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
	}

}
