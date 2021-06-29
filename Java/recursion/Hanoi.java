package recursion;

public class Hanoi {
	static void hanoi(int num, int x, int y) {//num: 목표기둥 번호, 시작기둥, 목표기둥
		if(num>1) 
			hanoi(num-1, x, 6-x-y); //그룹을 중간 기둥으로 옮김
		System.out.println("원반 ["+num+"]을 "+x+"기둥에서 "+y+"기둥으로 옮김");
		if(num>1)
			hanoi(num-1, 6-x-y, y);	//그룹을 목표 기둥으로 옮김
	}
	public static void main(String[] args) {
		hanoi(3, 1, 3);
	}

}
