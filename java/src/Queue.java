import LinkedList.Node;

public class Queue {
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
}
