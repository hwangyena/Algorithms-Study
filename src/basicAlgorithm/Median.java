package basicAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Median {
	//ȿ���� ���� �ʴٰ��� -> WHY?
	static int mid3Lower(int a, int b, int c) {
		int mid;
		
		if(a>b && a<c || a<b && a>c) mid=a;
		else if(b<a && b>c || b>a && b<c) mid=b;
		else mid = c;
		
		return mid;
	}
	public static void main(String[] args) {
		BufferedReader bf = null;
		
		try {
			bf = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("�� ���� �߾Ӱ��� ���մϴ�.");
			System.out.print("a : ");
			int a= Integer.parseInt(bf.readLine());
			System.out.print("b : ");
			int b= Integer.parseInt(bf.readLine());
			System.out.print("c : ");
			int c= Integer.parseInt(bf.readLine());

			System.out.printf("mid(%d, %d, %d)�� �߰��� : %d",a,b,c,mid3Lower(a,b,c));
			
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
