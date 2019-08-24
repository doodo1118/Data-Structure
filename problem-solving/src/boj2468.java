import java.util.LinkedList;
import java.util.Queue;

public class boj2468 {
	//높이 * 면(N*N)
	//  가장 높은 봉우리 ~ 가장 낮은봉우리까지 수면 높이 변화
	//  수면높이에 해당하는 높이의 봉우리가 없는 경우 pass
	//	수면높이와 같은 높이의 봉우리가 있을 경우 해당 봉우리만 상하좌우 체크 
	//큐 배열[100]
	//큐는{x좌표, y좌표 포함)
	
	Queue<cord> cordBucket = new LinkedList<cord>();
	cordBucket.add(new cord(1, 2));
}

class cord{
	int cordX;
	int cordY;
	
	cord(int cordX, int cordY){
		this.cordX = cordX;
		this.cordY = cordY;
	}
}