public class Stack3 {
	Node head;
	Node cur;
	int size;
	
	Stack3(){
    	this.head = new Node("");
    	this.cur = this.head;
	}
	
	class Node{
		Object data;
		Node next;
		
    	public Node(Object input){
    		this.data = input;
    		this.next = null;
    	}
    	
    	public String toString(){
    		return this.data.toString() + ", ";
    	}
	}
	
	boolean push(Object input){
    	Node newNode = new Node(input);
    	
    	newNode.next = head;
    	head = newNode;
    	size ++;
    	
    	return true;
	}
	
	Node pop(){
		Node tmp;
		
		if(this.size<1){
			System.out.println("");
			return null;
		}
		
		tmp = head;
		head = head.next;
		this.size --;
		
		return tmp;
	}
	
	int top(){
		return ;
	}
	
	int size(){
		return size;
	}
	
	int empty(){
		return size == 0 ? 1 : 0;
	}
	
	boolean dump(){
		while(head.next != null)
			head.next = head.next.next; //������ �ߴ� ���� ����
		//�ƴϸ� head.next = null ..? �ϳ��� �������� �ʵ��� ����ǵ�, �޸� ������ ���� ����ǿ��� �Ǵ��� �˸� ���� ���ص��ɼ���?
		return true;
	}
	
	boolean peek(Object input){//������Ʈ �񱳿�����?
		while(head.next != null){
			
		}
			
	}
	
}
