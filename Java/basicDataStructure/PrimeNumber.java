package basicDataStructure;

public class PrimeNumber {
	//ù��° ���
	static void PrimeNumber1(){
		int counter = 0;
		for(int n=2; n<=1000; n++) {
			int i;
			for(i=2; i<n; i++) {
				counter ++;
				if(n%i == 0) break;
			}
			if(n == i) System.out.print(n+" ");
		}
		System.out.println("\n1. �������� ������ Ƚ�� : "+counter);
	}
	
	//�ι�° ���
	static void PrimeNumber2() {
		int counter = 0;
		int prime[] = new int[500];
		int ptr=0;
		prime[ptr++] = 2;
	
		for(int n=3; n<=1000; n+=2) {
			int i;
			for(i=1; i<ptr; i++) { //�Ҽ��� ��Ƴ��� �迭
				counter++;
				if(n%prime[i] == 0) break;
			}
			if(ptr==i) {	//�迭�� ������ �� ������
				prime[ptr++] = n;
			}
		}
		
		System.out.println("2. �������� ������ Ƚ�� : "+counter);
	}
	
	//����° ���
	static void PrimeNumber3() {
		int counter=0;
		int ptr=0;
		int[] prime = new int[500];
		prime[ptr++] = 2;
		prime[ptr++] = 3;	//������ 3���� ���� �� X
		
		for(int n=5; n<1000; n+=2) {
			boolean flag = false;	
			for(int i=1; prime[i]*prime[i]<n; i++) {
				counter += 2;
				if(prime[i]%n == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				prime[ptr++] = n;
				counter++;
			}
		}
		System.out.println("3. �������� ������ Ƚ�� : "+counter);
	}
	
	public static void main(String[] args) {
		PrimeNumber1();
		PrimeNumber2();
		PrimeNumber3();
	}
}
