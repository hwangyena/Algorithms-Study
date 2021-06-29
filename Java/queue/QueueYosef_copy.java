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
			N = Integer.parseInt(st.nextToken()); //큐 크기
			K = Integer.parseInt(st.nextToken()); //삭제를 반복할 +index
			
			StringBuilder sb = new StringBuilder();
			sb.append("<");
			//Deque 사용 (add, offer 차이~)
			Deque<Integer> queue = new ArrayDeque<Integer>();	//dequeue 선언
			
			for(int i=1; i<=N; i++) queue.add(i);	//추가
			
			for(int i=0; i<N; i++) { //큐의 크기만큼
				for(int j=0; j<K-1; j++) { //큐 순환(K 앞에있는 값들을 뒤로 보내줌)
					int num = queue.poll();	//큐의 가장 앞 element(rear)
					queue.add(num);
				}
				int answer = queue.poll(); //큐 가장 앞에있는 값을 꺼내줌
				sb.append(answer + ", ");
			}
			
			/*
			//ArrayList<> 사용
			ArrayList<Integer> queue = new ArrayList<Integer>();
			for(int i=1; i<=N; i++) queue.add(i);
			int kill = K-1;	//내가 다음번에 없앨 인덱스 값
			
			
			while(queue.size() != 0) {
				sb.append(queue.get(kill)+ ", ");
				queue.remove(kill);
				if(kill == 0) continue; //kill 0이면 값 하나남은거
				kill = (kill + K-1)%queue.size(); //kill할 인덱스의 규칙
			}
			*/
			sb.deleteCharAt(sb.length()-1);	//sb 마지막에 삽입된 ' ' 제거
			sb.setCharAt(sb.length()-1, '>'); //sb ',' -> '>'로 변경
			bw.write(sb.toString());
			
			bw.flush();
			bw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
