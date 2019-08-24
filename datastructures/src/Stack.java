import java.util.Scanner;


class Tmp{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		Stack stack = new Stack();
		s.nextLine();
		
		for(int i=0; i<T; i++) {
			String command = s.nextLine();
			String[] commands = command.split(" ");
			
			switch(commands[0]) {
				case "push":
					stack.push(Integer.parseInt(commands[1]));break;
				case "size":
					stack.size();break;
				case "empty":
					stack.empty();break;
				case "pop":
					stack.pop();break;
				case "top":
					stack.top();break;
			}
		}
	}
}

class Stack{
	Node cur;
	Node head;
	int size;
	
	Stack(){
		Node newNode = new Node();
		cur = newNode;
		head = newNode;
		size = 0;
	}
	class Node{
		Node prev;
		int data;
	}
	void push(int input){
		Node newNode = new Node();
		newNode.data = input;
		newNode.prev = head;
		head = newNode;
		size++;
	}
	int pop(){
		if(size==0) {
			System.out.println(-1);
			return 0;
		}
		Node tmp = head;
		head = head.prev;
		size--;
		
		System.out.println(tmp.data);
		return tmp.data;
	}
	
	int size(){
		System.out.println(size);
		return size;
	}

	int empty(){
		System.out.println(size==0?1:0);
		return size==0?1:0;
	}
	
	int top(){
		if(size==0) {
			System.out.println(-1);
			return 0;
		}
		System.out.println(head.data);
		return head.data;
	}
}