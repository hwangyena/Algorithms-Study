package search;

import java.util.Scanner;

public class BinarySearchStart {
	static int binarySearch(int arr[], int n, int key) {
		int pStart = 0;	//�迭�� ���� �ε���
		int pEnd = arr.length -1;	//�迭�� �� �ε���
		
		while(true) {	
			int p = (pStart+pEnd) / 2;		//�迭�� �߰� �ε���		
			
			if(arr[p] == key) { //��Ҹ� ã���� ��
				while(arr[p] == key) {	//���� �տ��ִ� ��Ҹ� ã��
					p-=1;
				}return ++p;	//�տ� ���� �ε����� �������� �������
			}
			if(pStart == pEnd) return -1; 
			
			if(arr[p] > key) {	//key�� �ڿ� ���� -> �˻������� �ڷ� ����		
				pEnd = p-1;
			}
			else { 	//key�� �տ� ���� -> �˻������� ������ ����
				pStart = p+1;
			}
		}	
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
