package basicDataStructure;

public class PrimeNumber {
	//첫번째 방법
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
		System.out.println("\n1. 나눗셈을 수행한 횟수 : "+counter);
	}
	
	//두번째 방법
	static void PrimeNumber2() {
		int counter = 0;
		int prime[] = new int[500];
		int ptr=0;
		prime[ptr++] = 2;
	
		for(int n=3; n<=1000; n+=2) {
			int i;
			for(i=1; i<ptr; i++) { //소수를 모아놓은 배열
				counter++;
				if(n%prime[i] == 0) break;
			}
			if(ptr==i) {	//배열을 끝까지 다 돌았음
				prime[ptr++] = n;
			}
		}
		
		System.out.println("2. 나눗셈을 수행한 횟수 : "+counter);
	}
	
	//세번째 방법
	static void PrimeNumber3() {
		int counter=0;
		int ptr=0;
		int[] prime = new int[500];
		prime[ptr++] = 2;
		prime[ptr++] = 3;	//제곱근 3보다 작은 수 X
		
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
		System.out.println("3. 나눗셈을 수행한 횟수 : "+counter);
	}
	
	public static void main(String[] args) {
		PrimeNumber1();
		PrimeNumber2();
		PrimeNumber3();
	}
}
