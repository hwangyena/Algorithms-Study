package recursion;

public class Hanoi {
	static void hanoi(int num, int x, int y) {//num: ��ǥ��� ��ȣ, ���۱��, ��ǥ���
		if(num>1) 
			hanoi(num-1, x, 6-x-y); //�׷��� �߰� ������� �ű�
		System.out.println("���� ["+num+"]�� "+x+"��տ��� "+y+"������� �ű�");
		if(num>1)
			hanoi(num-1, 6-x-y, y);	//�׷��� ��ǥ ������� �ű�
	}
	public static void main(String[] args) {
		hanoi(3, 1, 3);
	}

}
