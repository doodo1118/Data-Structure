public class LinkedList {
	//head is dummy node which has meaningless data.
    private Node head;
    private Node tail;
    private Node cur;
    
    private int size;
	
    LinkedList(){
    	this.head = new Node("");
    	this.tail = this.head;
    	this.cur = this.head;
    }
    
    public class Node{
    	private Object data;
    	private Node next;
    	
    	public Node(Object input){
    		this.data = input;
    		this.next = null;
    	}
    	
    	public String toString(){
    		return this.data.toString() + ", ";
    	}
    }
    
    boolean add(Object input){
    	Node newNode = new Node(input);
    	
    	tail.next = newNode;
    	tail = newNode;
    	size ++;
    	
    	return true;
    }
    
    boolean add(int index, Object input){
    	Node newNode = new Node(input);
    	
    	cur = head;
    	for(int i = 0; i < index; i ++){
    		cur = cur.next;
    	}
    	
    	newNode.next = cur.next;
    	cur.next = newNode;
    	size ++;
    	
    	return true;
    }
    
    //boolean addAll(Collection c){
    	
    //}
    
    boolean addFirst(Object input){
    	Node newNode = new Node(input);
    	
    	newNode.next = head.next;
    	head.next = newNode;
   
    	size ++;
    	
    	return true;
    }
    
    boolean remove(){
    	
    	cur = head;
    	
    	while(cur.next != tail)
    		cur = cur.next;
    	
    	tail = cur;
    	cur.next = null;
    	size --;
    	
    	return true;
    }
    
    boolean remove(Object input){
    	cur = head;
    	
    	while(cur.next.data != input && cur.next.data != null)
    		cur = cur.next;
    	
    	cur.next = cur.next.next;
    	size --;
    	
    	return true;
    }
    
    boolean removeFirst(){
    	if(head != tail){
    		head.next = head.next.next;
    		size --;
    	}
    	
    	return true;
    }
    
    boolean contains(Object o){
    	cur = head;
    	
    	while(cur.data != o && cur.next != null){
    		cur = cur.next;
    	}
    	
    	return cur.data == o;
    }
    
    public String toString(){
    	String listInfo = "";
    	cur = head.next;
    	
    	for(int i = 0; i < size; i++){
    		listInfo += cur.toString();
    		cur = cur.next;
    	}
    		
    	return listInfo;
    }
}