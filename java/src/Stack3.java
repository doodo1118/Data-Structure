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
			head.next = head.next.next; //빨간줄 뜨는 이유 무엇
		//아니면 head.next = null ..? 하나씩 참조되지 않도록 만든건데, 메모리 해제가 언제 어떤조건에서 되는지 알면 굳이 안해도될수도?
		return true;
	}
	
	boolean peek(Object input){//오브젝트 비교연산자?
		while(head.next != null){
			
		}
			
	}
	
}
