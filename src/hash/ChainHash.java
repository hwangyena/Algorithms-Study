package hash;

public class ChainHash<K, V>{
	private int size;	//�ؽ� ���̺��� ũ��
	private Node<K,V>[] table;	//�ؽ� ���̺� ���� �迭
	
	//�ؽø� �����ϴ� ���
	class Node<K, V>{
		private K key;	//key
		private V value;	//value
		private Node<K,V> next;	//node ����
		
		//������
		Node(K key, V value, Node<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		K getKey() {
			return key;
		}
		
		V getvalue() {
			return value;
		}
		
		//Ű�� �ؽ� �� ��ȯ
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	//������
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
			
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//�ؽð�(value) ���ϱ�
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//Ű �� key�� ���� ��� �˻�(������ ��ȯ)
	public V search(K key) {
		int hash = hashValue(key);	//�ؽ� �� ���ϱ�
		Node<K, V> p = table[hash];	//������ ���(p)
		
		while(p!=null) {
			if(p.getKey().equals(key))
				return p.getvalue();
			p = p.next;
		}
		return null;	//���� ���
	}
	
	//node �� �տ� ����, �ִ� ��� ����
	public int add(K key, V value) {
		int hash = hashValue(key);
		Node<K, V> p = table[hash];
		
		//�̹� ��ϵ� key���� Ȯ��
		while(p!=null) {
			if(p.getKey().equals(key)) return 1;	//�̹� ��ϵ� key
			p = p.next;
		}
		Node<K, V> temp = new Node<K,V>(key, value, table[hash]);	//���ο� ���(���� �� ���� node�� ����)
		table[hash] = temp;	//���ο� ��带 �� �տ� ����
		return 0;
	}
	
	//key�� �ش��ϴ� node ����
	public int remove(K key) {
		int hash = hashValue(key);	//������ ������ �ؽ� ��
		Node<K, V> p = table[hash];	//������ ��� ���� ��
		Node<K, V> pp = null;		//������ ��� ���� ��� 
		
		while(p!=null) {
			if(p.getKey().equals(key)) {	//������ ��� ã��
				if(pp == null)	//�� �� ��� ����!
					table[hash] = p.next;
				else	//�߰� ��� ����
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;
		}
		return 1;
	}
	
	//�ؽ� ���̺� ����(���)
	public void dump() {
		for(int i=0; i<size; i++) {
			Node<K, V> p =table[i];
			System.out.printf("%02d ", i);
			while(p!=null) {
				System.out.printf("-> %s (%s)  ", p.getKey(), p.getvalue());
				p = p.next;
			}
			System.out.println();
		}
	}
	
	static public void main(String[] args) {
		
	}

}
