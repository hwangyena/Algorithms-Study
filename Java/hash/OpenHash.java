package hash;

import hash.ChainHash.Node;

public class OpenHash<K, V> {
	//��Ŷ ����
	enum Status {OCCUPIED, EMPTY, DELETED};
	
	//��Ŷ
	static class Bucket<K, V>{
		private K key;			//Ű ��
		private V data;			//������
		private Status stat;	//����
		
		//������
		Bucket(){
			stat = Status.EMPTY;
		}
		
		//��� �ʵ忡 �� ����
		void set(K key, V data, Status stat) {
			this.key = key;
			this.data = data;
			this.stat = stat;
		}
		
		//���� ����
		void setStat(Status stat) {
			this.stat = stat;
		}
		
		//Ű&������ ��ȯ
		K getKey() { return key;	}
		V getValue() { return data;	}
		public int hashCode() { return key.hashCode(); }
		
	}
	
	
	private int size;				//�ؽ� ���̺� ũ��
	private Bucket<K, V>[] table;	//�ؽ� ���̺�
	
	//������
	public OpenHash(int size) {
		try {
			table = new Bucket[size];
			for(int i=0; i<size; i++)
				table[i] = new Bucket<K,V>();
			this.size = size;

		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//�ؽ� �� ���ϱ�
	public int hashValue(Object key) {
		return key.hashCode()%size;
	}
	
	//���ؽ� �� ���ϱ�
	public int rehashValue(int hash) {
		return (hash+1)%size;
	}
	
	
	//key�� ������ ��Ŷ �˻�(��Ŷ ��ȯ)
	//���� ��Ŷ table[hash]���� ���� ~ rehash�ϸ鼭 �ٸ� ���� ������� �ʾҴ��� Ȯ��
	private Bucket<K,V> searchNode(K key){
		int hash = hashValue(key);		//�˻��� �������� �ؽ� ��
		Bucket<K,V> p = table[hash];	//���� ��Ŷ
		
		for(int i=0; p.stat != Status.EMPTY && i<size; i++) {
			//��Ŷ ã��
			if(p.stat == Status.OCCUPIED && p.getKey().equals(key))	
				return p;
			hash = rehashValue(hash);	//rehash
			p = table[hash];
		}
		return null;
	}
	
	
	//key�� ���� ��� �˻�(������/�ε��� ��ȯ)
	public V search(K key) {
		Bucket<K, V> p = searchNode(key);
		if(p!=null)
			return p.getValue();
		else
			return null;
	}
	
	
	//�߰�
	public int add(K key, V data) {
		if(search(key) != null) return 1;	//�̹� ��ϵ� Ű
		
		int hash = hashValue(key);	//����� ������ �ؽ� ��
		Bucket<K, V> p = table[hash];
		
		for(int i=0; i<size; i++) {
			if(p.stat == Status.EMPTY || p.stat == Status.DELETED) { //���� OR ����ִ� ���
				p.set(key, data, Status.OCCUPIED);	//��Ŷ ����
				return 0;
			}
			hash = rehashValue(hash);	//rehash
			p = table[hash];
		}
		
		return 2;	//�ؽ� ���� ��
	}
	
	
	//���� -> �� �� �־��� ���̹Ƿ� DELETE�� ���� ����
	public int remove(K key) {
		Bucket<K,V> p = searchNode(key);	//��Ŷ ����
		if(p==null) return 1;				//�ش� Ű �� ����
		
		p.setStat(Status.DELETED);
		return 0;
	}
	
	
	//���
	public void dump() {
		for(int i=0; i<size; i++) {
			System.out.printf("%02d ", i);
			
			switch(table[i].stat) {
			case OCCUPIED:
				System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
				break;
			case EMPTY:
				System.out.println("-- �̵�� --");
				break;
			case DELETED:
				System.out.println("-- ���� �Ϸ� --");
				break;
			}
			
			System.out.println();
		}
	}
}