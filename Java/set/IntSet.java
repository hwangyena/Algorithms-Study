package set;

public class IntSet {
	private int max;
	private int num;
	private int[] set;
	
	//������
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max];	//���� �迭 ����			
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//������ �ִ� ����(max) ��ȯ
	public int capacity() { 
		return max;
	}
	
	//������ ���� ��� ����(num) ��ȯ
	public int size() { 
		return num;
	}
	
	//���տ��� n ã��
	public int indexOf(int n) { 
		for(int i=0; i<num; i++)
			if(set[i]==n)
				return i;	//�ε��� ��ȯ
		return -1;	//�˻� ����
	}
	
	//���տ� n �ִ��� Ȯ��
	public boolean contains(int n) {	
		return (indexOf(n) != -1) ? true : false; 
	}
	
	//���տ� n �߰�
	public boolean add(int n) {	
		if(num >= max || contains(n) == true) return false;
		else {
			set[num++] = n;
			return true;
		}
	}
	
	//���տ� n ����
	public boolean remove(int n) {
		int idx;
		if(num==0 || (idx = indexOf(n)) == -1) return false;
		else {
			set[idx] = set[--num];	//������ ��Ҹ� ������ ������ �ű�
			return true;
		}
	}
	
	//���� s�� ����
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num;	//������ ��� ��(������ �������� n��ũ��, max������ ����)
		for(int i=0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	
	//���� s�� ����
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;	//������ ��� ��(����� �������� �����ϴ� num��ũ��, max������ ����)
		for(int i=0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	//���� s�� ������
	public boolean equalTo(IntSet s) {
		if(num != s.num) return false;
		
		for(int i=0; i<num; i++) {
			int j=0;
			for(; j<s.num; j++) { //���� i��ҿ� j�� �����Ҷ� ���� ������ break
				if(set[i] == s.set[j]) break;
			}
			if(j == s.num) return false;	//�� for������ break�� ���� ���ϴ� ���
		}
		return true;
	}
	
	//���� s1, s2�� ������ ����
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1);	//s1�� ���� ���տ� ����
		for(int i=0; i< s2.num; i++)
			add(s2.set[i]);	//s2�� ���� �ڿ� ����
	}
	
	//"{ }" �������� ���
	//@override
	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		for(int i=0; i<num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}
	
	//������ Ȯ��
	public boolean isEmpty() {
		return (num == 0) ? true : false;
	}
	
	//������ ���� á���� Ȯ��
	public boolean isFull() {
		return (num == max) ? true : false;
	}
	
	//���� �ʱ�ȭ
	public void clear() {
		num = 0;
	}
}
