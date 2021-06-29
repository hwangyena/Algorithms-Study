package queue;

import java.io.*;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class QueueYosef_copy {
	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	
	static int N, K;
	
	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //ť ũ��
			K = Integer.parseInt(st.nextToken()); //������ �ݺ��� +index
			
			StringBuilder sb = new StringBuilder();
			sb.append("<");
			//Deque ��� (add, offer ����~)
			Deque<Integer> queue = new ArrayDeque<Integer>();	//dequeue ����
			
			for(int i=1; i<=N; i++) queue.add(i);	//�߰�
			
			for(int i=0; i<N; i++) { //ť�� ũ�⸸ŭ
				for(int j=0; j<K-1; j++) { //ť ��ȯ(K �տ��ִ� ������ �ڷ� ������)
					int num = queue.poll();	//ť�� ���� �� element(rear)
					queue.add(num);
				}
				int answer = queue.poll(); //ť ���� �տ��ִ� ���� ������
				sb.append(answer + ", ");
			}
			
			/*
			//ArrayList<> ���
			ArrayList<Integer> queue = new ArrayList<Integer>();
			for(int i=1; i<=N; i++) queue.add(i);
			int kill = K-1;	//���� �������� ���� �ε��� ��
			
			
			while(queue.size() != 0) {
				sb.append(queue.get(kill)+ ", ");
				queue.remove(kill);
				if(kill == 0) continue; //kill 0�̸� �� �ϳ�������
				kill = (kill + K-1)%queue.size(); //kill�� �ε����� ��Ģ
			}
			*/
			sb.deleteCharAt(sb.length()-1);	//sb �������� ���Ե� ' ' ����
			sb.setCharAt(sb.length()-1, '>'); //sb ',' -> '>'�� ����
			bw.write(sb.toString());
			
			bw.flush();
			bw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
