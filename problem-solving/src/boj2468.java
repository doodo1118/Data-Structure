import java.util.LinkedList;
import java.util.Queue;

public class boj2468 {
	//���� * ��(N*N)
	//  ���� ���� ���츮 ~ ���� �������츮���� ���� ���� ��ȭ
	//  ������̿� �ش��ϴ� ������ ���츮�� ���� ��� pass
	//	������̿� ���� ������ ���츮�� ���� ��� �ش� ���츮�� �����¿� üũ 
	//ť �迭[100]
	//ť��{x��ǥ, y��ǥ ����)
	
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